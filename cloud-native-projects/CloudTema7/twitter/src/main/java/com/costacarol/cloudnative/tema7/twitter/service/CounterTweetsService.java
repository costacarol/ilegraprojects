package com.costacarol.cloudnative.tema7.twitter.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


@Service
@AllArgsConstructor
public class CounterTweetsService {

    private RestTemplate restTemplate;

    public int getNumberOfTweets(String userName) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter.showUser(userName).getStatusesCount();
    }
}
