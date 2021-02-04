package com.costacarol.cloudnative.tema10.integration;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class IntegrationService {

    private static final Logger logger = LoggerFactory.getLogger(IntegrationService.class);

    private RestTemplate restTemplate;
    private final String URL_TWITTER = "http://localhost:8082/count/";
    private final String URL_GITHUB = "http://localhost:8081/count/";

    @HystrixCommand(fallbackMethod = "getNumberOfRepositoriesAndTweetsFallBack")
    public Object getNumberOfRepositoriesAndTweets(String userTwitter, String userGithub) throws HttpClientErrorException {
        Object numberOfTweets = restTemplate.getForEntity(URL_TWITTER + userTwitter, Object.class).getBody();
        Object numberOfRepositories = restTemplate.getForEntity(URL_GITHUB + userGithub, Object.class).getBody();
        return new NumberOfTweetsAndRepositoriesResponse(numberOfTweets, numberOfRepositories);
    }

    public Object getNumberOfRepositoriesAndTweetsFallBack(String userTwitter, String userGithub) throws HttpClientErrorException{
        logger.info("An unexpected error occurred. Please, try again in a few minutes.");
        return new IntegrationFallBackResponse();
    }

}
