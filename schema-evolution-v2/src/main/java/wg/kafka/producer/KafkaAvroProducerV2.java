package wg.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import wg.kafka.Customer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class KafkaAvroProducerV2 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "100");
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");

        KafkaProducer<String, Customer> kafkaProducer = new KafkaProducer<>(properties);
        String topic = "customer-avro-2";

        Customer customer = Customer.newBuilder()
            .setFirstName("New John")
            .setLastName("Doe")
            .setAge(60)
            .setHeight(180.0f)
            .setWeight(76.5f)
            .build();

        ProducerRecord<String, Customer> producerRecord = new ProducerRecord<>(
            topic, customer
        );

        kafkaProducer.send(producerRecord, (recordMetadata, e) -> {
            if (e == null) {
                System.out.println("Success! \n" + recordMetadata.toString());
            } else {
                e.printStackTrace();
            }
        });

        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
