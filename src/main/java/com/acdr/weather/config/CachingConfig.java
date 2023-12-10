package com.acdr.weather.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@EnableCaching
@AllArgsConstructor
public class CachingConfig {


	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
		List<String> cachNames = new ArrayList<String>();
		cachNames.add("weather");
		cacheManager.setCacheNames(cachNames);
		return cacheManager;
	}
}
