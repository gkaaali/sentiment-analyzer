package com.cryptosentiment.analyzer.controllers;

import com.cryptosentiment.analyzer.models.NewsApiResponse;
import com.cryptosentiment.analyzer.services.NewsApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsApiController {

    private final NewsApiService newsApiService;

    public NewsApiController(NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }

    @GetMapping("/news")
    public NewsApiResponse getNews(
            @RequestParam String query,
            @RequestParam(defaultValue = "en") String language) {
        return newsApiService.fetchNews(query, language);
    }
}
