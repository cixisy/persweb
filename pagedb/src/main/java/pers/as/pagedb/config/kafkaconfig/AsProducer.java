package pers.as.pagedb.config.kafkaconfig;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.kafka.clients.producer.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName: AsProducer
 * @description: kafka生产者类，用于初始化kafka生产者信息
 * @author: AS
 * @create: 2023-01-04 10:41
 */
@Data
public class AsProducer {
    private KafkaProducer<String, String> kafkaProducer;
    private String bootstrap_servers;
    private String retries;
    private String batch_size;
    private String linger_ms;
    private String buffer_memory;
    private String acks;
    private String key_serializer;
    private String value_serializer;

    public AsProducer(){
        setParam();
        Properties props = new Properties();
        // kafka集群，broker-list
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrap_servers);
        props.put(ProducerConfig.ACKS_CONFIG, this.acks);
        // 重试次数
        props.put("retries", this.retries);
        // 批次大小
        props.put("batch.size", this.batch_size);

        // 等待时间
        props.put("linger.ms", this.linger_ms);
        // RecordAccumulator缓冲区大小
        props.put("buffer.memory", this.buffer_memory);
        // 设置序列化
        props.put("key.serializer", this.key_serializer);
        props.put("value.serializer", this.value_serializer);
        this.kafkaProducer = new KafkaProducer<String, String>(props);
    }
    /*
    初始化参数
     */
    public void setParam(){
        YamlPropertiesFactoryBean yamlProFb = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("/dev-redmi/kafka.yml"));
        Properties properties = yamlProFb.getObject();
        this.bootstrap_servers = properties.get("askafka.producer.bootstrap_servers").toString();
        this.retries = properties.get("askafka.producer.retries").toString();
        this.batch_size = properties.get("askafka.producer.batch_size").toString();
        this.linger_ms = properties.get("askafka.producer.linger_ms").toString();
        this.buffer_memory = properties.get("askafka.producer.buffer_memory").toString();
        this.acks = properties.get("askafka.producer.acks").toString();
        this.key_serializer = properties.get("askafka.producer.key_serializer").toString();
        this.value_serializer = properties.get("askafka.producer.value_serializer").toString();
    }

    /*
    kafka发送消息
     */
    public void send() throws InterruptedException {
        for (int i = 100; i < 200; i++) {
            Map<String, Object> recordMap = new HashMap<String, Object>(20);
            recordMap.put("seq", i);
            recordMap.put("name", "测试" + i);
            recordMap.put("age", i % 20);
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("Testtopic",
                    String.valueOf(i), JSON.toJSONString(recordMap));
            this.kafkaProducer.send(producerRecord, new Callback() {
                // 回调函数，该方法会在Producer收到ack时调用，为异步调用
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    String topic = metadata.topic();
                    int partition = metadata.partition();
                    long offset = metadata.offset();
                    if (e != null) {
                        System.out.printf("消息发送失败:", topic, partition, offset,
                                e.getMessage());

                    } else {
                        System.out.printf("消息发送成功:"+ topic+ partition+ offset);
                    }
                }
            });

            Thread.sleep(2 * 1000);

        }
        kafkaProducer.close();
    }





}
