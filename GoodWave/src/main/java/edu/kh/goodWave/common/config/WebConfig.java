package edu.kh.goodWave.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class WebConfig {

    @Bean
    public MappingJackson2HttpMessageConverter MappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
}
