package com.cryptosentiment.analyzer.models;

import lombok.Data;

import java.util.List;

@Data
public class NewsApiResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;

    @Data
    public static class Article {
        private String author;
        private String title;
        private String description;
        private String url;
        private String publishedAt;
        private Source source;

        @Data
        public static class Source {
            private String id;
            private String name;
        }
    }
}
