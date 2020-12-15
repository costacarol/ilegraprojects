package com.costacarol.cloudnative.tema7.integration.service;

import com.costacarol.cloudnative.tema7.integration.model.NumberOfTweetsAndRepositoriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class IntegrationService {

    private RestTemplate restTemplate;
    private final String URL_TWITTER = "http://localhost:8082/count/";
    private final String URL_GITHUB = "http://localhost:8081/count/";

    public Object getNumberOfRepositoriesAndTweets(String userTwitter, String userGithub) throws HttpClientErrorException {
        Object numberOfTweets = restTemplate.getForEntity(URL_TWITTER + userTwitter, Object.class).getBody();
        Object numberOfRepositories = restTemplate.getForEntity(URL_GITHUB + userGithub, Object.class).getBody();
        return new NumberOfTweetsAndRepositoriesResponse(numberOfTweets, numberOfRepositories);
    }
}
