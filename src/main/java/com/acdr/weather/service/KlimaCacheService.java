package com.acdr.weather.service;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acdr.weather.helper.RestClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KlimaCacheService {

	private final CacheManager cacheManager;
	private final RestClient restClient;

	public void printKey() {
		Cache cache = cacheManager.getCache("weather");
		ConcurrentHashMap<?, ?> nativeCache = (ConcurrentHashMap<?, ?>) cache.getNativeCache();

		if (!nativeCache.isEmpty()) {
			Enumeration<?> enumeration = nativeCache.keys();
			while (enumeration.hasMoreElements()) {
				Object key = enumeration.nextElement();
				System.out.println(key);
			}

		}
	}

	@Cacheable(value = "weather", key = "{#endpoint,#responseType.getName()}")
	public <T> ResponseEntity<T> get(final String endpoint, Class<T> responseType) {
		return restClient.get(endpoint, responseType);
	}

	@Cacheable(value = "weather", key = "{#endpoint,#responseType.getClass().getName()}")
	public <T> ResponseEntity<T> get(final String endpoint, ParameterizedTypeReference<T> responseType) {
		return restClient.get(endpoint, responseType);
	}

}
