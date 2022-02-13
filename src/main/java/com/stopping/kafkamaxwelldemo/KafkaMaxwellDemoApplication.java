package com.stopping.kafkamaxwelldemo;

import com.stopping.kafkamaxwelldemo.POJO.Maxwell;
import com.stopping.kafkamaxwelldemo.POJO.Users;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

import java.util.List;

@SpringBootApplication
public class KafkaMaxwellDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaMaxwellDemoApplication.class, args);
    }

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("maxwell", 1, (short) 1);
    }

    @KafkaListener(id = "1", topics = "maxwell")
    public void listen(Maxwell<Users> maxwell) {
        System.out.println(maxwell);
    }
}
