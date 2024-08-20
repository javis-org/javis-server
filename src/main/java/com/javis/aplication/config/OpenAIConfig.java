package com.javis.aplication.config;

import com.theokanning.openai.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class OpenAIConfig {
    @Value("${openai.api-key}")
    private String apiKey;

    @Bean
    public OpenAiService openAiService() {
        // 요청 타임아웃을 설정 (예: 60초)
        Duration timeout = Duration.ofSeconds(60);
        return new OpenAiService(apiKey, timeout);
    }
}
