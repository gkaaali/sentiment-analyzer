package com.cryptosentiment.analyzer.controllers;

import com.cryptosentiment.analyzer.models.ArticleSentiment;
import com.cryptosentiment.analyzer.services.SentimentAnalysisService;
import com.cryptosentiment.analyzer.services.SentimentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sentiments")
public class SentimentController {

    private final SentimentService sentimentService;
    private final SentimentAnalysisService sentimentAnalysisService;

    public SentimentController(SentimentService sentimentService, SentimentAnalysisService sentimentAnalysisService) {
        this.sentimentService = sentimentService;
        this.sentimentAnalysisService = sentimentAnalysisService;
    }

    @GetMapping
    public List<ArticleSentiment> getAllSentiments() {
        return sentimentService.getAllSentiments();
    }

    @PostMapping
    public ArticleSentiment saveSentiment(@RequestBody ArticleSentiment sentiment) {
        return sentimentService.saveSentiment(sentiment);
    }

    @PostMapping("/analyze")
    public ArticleSentiment analyzeAndSaveSentiment(@RequestBody ArticleSentiment sentiment) {
        String sentimentType = sentimentAnalysisService.analyzeSentiment(sentiment.getContent(), "en");
        sentiment.setSentimentType(sentimentType);
        sentiment.setSentimentScore(calculateScore(sentimentType));
        return sentimentService.saveSentiment(sentiment);
    }

    private double calculateScore(String sentimentType) {
        switch (sentimentType) {
            case "POSITIVE": return 0.85;
            case "NEGATIVE": return -0.85;
            case "NEUTRAL": return 0.0;
            default: return 0.0;
        }
    }
}
