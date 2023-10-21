package com.acdr.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperty {

    @Value("${weatherappauthentication.api-base-url}")
    public String apiBaseUrl;

    @Value("${weatherappauthentication.access-token}")
    public String accessToken;

    @Value("${weatherappauthentication.header-key-for-access-token}")
    public String headerKeyForAccessToken;
}
