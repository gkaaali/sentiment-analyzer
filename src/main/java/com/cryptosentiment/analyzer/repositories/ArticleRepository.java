package com.cryptosentiment.analyzer.repositories;

import com.cryptosentiment.analyzer.models.ArticleSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleSentiment, Long> {
}
