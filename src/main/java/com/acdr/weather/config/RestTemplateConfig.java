package com.acdr.weather.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@AllArgsConstructor
public class RestTemplateConfig {

    private final ApplicationProperty applicationProperty;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(headerInterceptor()));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestInterceptor headerInterceptor() {
        return (request, body, execution) -> {
            HttpHeaders headers = request.getHeaders();
            headers.add(applicationProperty.headerKeyForAccessToken, applicationProperty.accessToken);

            return execution.execute(request, body);
        };
    }
}
