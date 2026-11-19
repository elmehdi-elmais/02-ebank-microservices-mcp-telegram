package org.sid.ebankbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankBotApplication.class, args);
    }

    @Bean
    CommandLineRunner run(@Value("${spring.ai.openai.api-key}") String apiKey) {
        return args -> System.out.println("API Key: " + apiKey);
    }
}
