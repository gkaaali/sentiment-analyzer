package com.cryptosentiment.analyzer.integrations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NewsApiClient {

    @Value("${newsapi.base-url}")
    private String baseUrl;

    @Value("${newsapi.api-key}")
    private String apiKey;

    public String buildUrl(String query, String language) {
        return UriComponentsBuilder.fromHttpUrl(baseUrl + "/everything")
                .queryParam("q", query)
                .queryParam("language", language)
                .queryParam("apiKey", apiKey)
                .toUriString();
    }
}
