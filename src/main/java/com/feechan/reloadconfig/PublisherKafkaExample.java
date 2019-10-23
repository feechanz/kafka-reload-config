package com.feechan.reloadconfig;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author Feechan
 * @since 10/23/2019
 */
public class PublisherKafkaExample {
    public static void main(String[] args) {
        String serverAddress = "localhost:9092";

        String topicName = "refresh-config";
        String keyName = "key01";

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddress);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i =0;i<10;i++){
            producer.send(new ProducerRecord<String, String>(topicName, keyName,"percobaan data ke "+ i));
        }
        producer.close();
    }
}
