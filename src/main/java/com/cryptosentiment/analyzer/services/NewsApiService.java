package com.cryptosentiment.analyzer.services;

import com.cryptosentiment.analyzer.integrations.NewsApiClient;
import com.cryptosentiment.analyzer.models.NewsApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsApiService {

    private final RestTemplate restTemplate;
    private final NewsApiClient newsApiClient;

    public NewsApiService(RestTemplate restTemplate, NewsApiClient newsApiClient) {
        this.restTemplate = restTemplate;
        this.newsApiClient = newsApiClient;
    }

    public NewsApiResponse fetchNews(String query, String language) {
        String url = newsApiClient.buildUrl(query, language);
        return restTemplate.getForObject(url, NewsApiResponse.class);
    }
}
