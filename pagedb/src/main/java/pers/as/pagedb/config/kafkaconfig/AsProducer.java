package pers.as.pagedb.config.kafkaconfig;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AsProducer
 * @description: kafka生产者类，用于初始化kafka生产者信息
 * @author: AS
 * @create: 2023-01-04 10:41
 */
@Component  // bean注解
@ConfigurationProperties(prefix = "kafka.producer")
public class AsProducer {
    private KafkaProducer<Object, Object> kafkaProducer;


}
