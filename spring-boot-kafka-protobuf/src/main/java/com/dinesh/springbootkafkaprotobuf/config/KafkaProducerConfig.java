package com.dinesh.springbootkafkaprotobuf.config;

import com.dinesh.springbootkafkaprotobuf.model.OrderMessageOuterClass;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${schema.registry.url:http://localhost:8081}")
    private String schemaRegistryUrl;

    // --- 1. STRING PRODUCER CONFIGURATION ---
    @Bean
    public ProducerFactory<String, String> stringProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name = "stringKafkaTemplate")
    public KafkaTemplate<String, String> stringKafkaTemplate() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    // --- 2. NATIVE BYTE ARRAY PRODUCER CONFIGURATION ---
    @Bean
    public ProducerFactory<String, byte[]> bytesProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Switch to native byte array serialization
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

         return new DefaultKafkaProducerFactory<>(configProps);
    }

    // --- 2. PROTOBUF PRODUCER CONFIGURATION ---
    @Bean
    public ProducerFactory<String, OrderMessageOuterClass.OrderMessage> protobufProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // Use Confluent's Protobuf Serializer
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);

        // Point to Schema Registry
        configProps.put("schema.registry.url", schemaRegistryUrl);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name = "bytesKafkaTemplate")
    public KafkaTemplate<String, byte[]> bytesKafkaTemplate() {
        return new KafkaTemplate<>(bytesProducerFactory());
    }

    @Bean(name = "protobufKafkaTemplate")
    public KafkaTemplate<String, OrderMessageOuterClass.OrderMessage> protobufKafkaTemplate() {
        return new KafkaTemplate<>(protobufProducerFactory());
    }
}