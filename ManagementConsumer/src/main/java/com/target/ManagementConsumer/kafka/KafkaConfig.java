package com.target.ManagementConsumer.kafka;

import java.util.HashMap;
import java.util.Map;

import com.target.ManagementConsumer.model.Email;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@Configuration
class KafkaConfig {

    private String bootstrapServers="localhost:9092";

    Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "reflectoring-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    public ConsumerFactory<String, Email> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Email> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Email> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setMessageConverter(new StringJsonMessageConverter());

        return factory;
    }

}
