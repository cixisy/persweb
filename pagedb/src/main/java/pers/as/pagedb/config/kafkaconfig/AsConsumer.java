package pers.as.pagedb.config.kafkaconfig;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * @ClassName: AsConsumer
 * @description: kafka消费者
 * @author: AS
 * @create: 2023-01-05 15:40
 */
public class AsConsumer {

    private static KafkaConsumer<String, String> kafkaConsumer;
    private String bootstrap_servers;
    private String group_id;
    private String enable_auto_commit;
    private String auto_commit_interval_ms;
    private String session_timeout_ms;
    private String max_poll_records;
    private String auto_offset_reset;
    private String key_deserializer;
    private String value_deserializer;

    public KafkaConsumer<String, String> instance(boolean autoCommit, String groupID, int records) {
        setParam();
        if (kafkaConsumer == null) {
            Properties props = new Properties();
            props.put("bootstrap.servers", this.bootstrap_servers);//kafka的地址
            props.put("group.id", groupID);//组名 不同组名可以重复消费
            props.put("auto.offset.reset", this.auto_offset_reset);//消费规则，默认earliest
            props.put("enable.auto.commit", this.enable_auto_commit);//是否自动提交，默认为true
            props.put("auto.commit.interval.ms", this.auto_commit_interval_ms);//poll(拉)的回话处理时长,即多久自动提交一次
            props.put("max.poll.records", records);//一次最大拉取的条数
            props.put("key.deserializer", this.key_deserializer);//键序列化
            props.put("value.deserializer",this.value_deserializer);//值序列化
            props.put("session.timeout.ms", this.session_timeout_ms);//超时时间

            kafkaConsumer = new KafkaConsumer(props);
        }
        return kafkaConsumer;
    }

    public void setParam() {
        YamlPropertiesFactoryBean yamlProFb = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("/dev-redmi/kafka.yml"));
        Properties properties = yamlProFb.getObject();
        this.bootstrap_servers = properties.get("kafka.producer.bootstrap-servers").toString();
        this.group_id = properties.get("kafka.producer.group-id").toString();
        this.auto_offset_reset = properties.get("kafka.producer.auto-offset-reset").toString();
        this.enable_auto_commit = properties.get("kafka.producer.enable-auto-commit").toString();
        this.auto_commit_interval_ms = properties.get("kafka.producer.auto-commit-interval").toString();
        this.max_poll_records = properties.get("kafka.producer.max-poll-records").toString();
        this.key_deserializer = properties.get("kafka.producer.key-deserializer").toString();
        this.value_deserializer = properties.get("kafka.producer.value-deserializer").toString();
        this.session_timeout_ms = properties.get("kafka.producer.properties.session.timeout.ms").toString();

    }

}
