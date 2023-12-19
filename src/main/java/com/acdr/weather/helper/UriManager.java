package com.acdr.weather.helper;

import java.util.Map;

public abstract class UriManager {

    public static String buildUriFromQueryParams(final String endpoint, final Map<String, String> params) {
        StringBuilder baseEndpoint = new StringBuilder(endpoint.concat("?"));
        for (Map.Entry<String, String> entry : params.entrySet()) {
            baseEndpoint.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        return baseEndpoint.toString();
    }
}
