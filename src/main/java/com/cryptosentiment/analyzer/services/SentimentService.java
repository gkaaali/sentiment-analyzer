package com.cryptosentiment.analyzer.services;

import com.cryptosentiment.analyzer.repositories.ArticleRepository;
import com.cryptosentiment.analyzer.models.ArticleSentiment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private final ArticleRepository articleRepository;

    public SentimentService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleSentiment> getAllSentiments() {
        return articleRepository.findAll();
    }

    public ArticleSentiment saveSentiment(ArticleSentiment sentiment) {
        return articleRepository.save(sentiment);
    }
}
