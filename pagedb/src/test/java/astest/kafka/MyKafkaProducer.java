package astest.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.alibaba.fastjson.JSON;

/**
 * kafka生产者代码
 *
 */
public class MyKafkaProducer {

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        // kafka集群，broker-list
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.13.37:9900,192.168.13.37:9901");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        // 重试次数
        props.put("retries", 1);
        // 批次大小
        props.put("batch.size", 16384);
        // 等待时间
        props.put("linger.ms", 1);
        // RecordAccumulator缓冲区大小
        props.put("buffer.memory", 33554432);
        // 设置序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 100; i < 200; i++) {
            Map<String, Object> recordMap = new HashMap<String, Object>(20);
            recordMap.put("seq", i);
            recordMap.put("name", "测试" + i);
            recordMap.put("age", i % 20);
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("Testtopic",
                    String.valueOf(i), JSON.toJSONString(recordMap));
            producer.send(producerRecord, new Callback() {
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
        producer.close();
    }
}