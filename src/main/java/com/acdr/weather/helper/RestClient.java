package com.acdr.weather.helper;

import com.acdr.weather.config.ApplicationProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@Slf4j
public class RestClient {

    private final ApplicationProperty applicationProperty;

    private final RestTemplate restTemplate;

    public <T> ResponseEntity<T> get(final String endpoint, Class<T> responseType)  {
        var url = applicationProperty.apiBaseUrl
                .concat("/")
                .concat(applicationProperty.apiVersion)
                .concat(endpoint)
                .concat("appid=")
                .concat(applicationProperty.accessToken);

        return restTemplate.exchange(url, HttpMethod.GET,null, responseType);
    }

    public <T> ResponseEntity<T> get(final String endpoint, ParameterizedTypeReference<T> responseType)  {
        var url = applicationProperty.apiBaseUrl.concat(endpoint);
        return restTemplate.exchange(url, HttpMethod.GET,null, responseType);
    }
}
