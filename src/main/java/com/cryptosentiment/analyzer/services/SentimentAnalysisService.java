package com.cryptosentiment.analyzer.services;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.comprehend.ComprehendClient;
import software.amazon.awssdk.services.comprehend.model.DetectSentimentRequest;
import software.amazon.awssdk.services.comprehend.model.DetectSentimentResponse;

@Service
public class SentimentAnalysisService {

    private final ComprehendClient comprehendClient = ComprehendClient.create();

    public String analyzeSentiment(String text, String languageCode) {
        DetectSentimentRequest request = DetectSentimentRequest.builder()
                .text(text)
                .languageCode(languageCode)
                .build();

        DetectSentimentResponse response = comprehendClient.detectSentiment(request);
        return response.sentimentAsString();
    }
}
