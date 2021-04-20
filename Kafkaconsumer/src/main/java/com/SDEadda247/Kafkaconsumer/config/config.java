package com.SDEadda247.Kafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.SDEadda247.Kafkaconsumer.user.user;
@EnableKafka
@Configuration
public class config {
    
    @Bean
    public ConsumerFactory<String, String> consumerfactory(){
        Map<String,Object> configs=new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
        return new DefaultKafkaConsumerFactory<>(configs);
    }
    
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> KafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory=new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerfactory());
        return factory;
    }
    
    
    @Bean
    public ConsumerFactory<String, user> userconsumerfactory(){
        Map<String,Object> configs=new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG,"group_json");
    	return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(),new JsonDeserializer<>(user.class));
    	
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, user> userKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, user> factory=new ConcurrentKafkaListenerContainerFactory<String, user>();
        factory.setConsumerFactory(userconsumerfactory());
        return factory;
    }
    
    

}
