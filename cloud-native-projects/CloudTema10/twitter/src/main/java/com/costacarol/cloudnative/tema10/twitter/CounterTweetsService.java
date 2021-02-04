package com.costacarol.cloudnative.tema10.twitter;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


@Service
@AllArgsConstructor
public class CounterTweetsService {

    private static final Logger logger = LoggerFactory.getLogger(CounterTweetsService.class);

    @HystrixCommand(fallbackMethod = "getNumberOfTweetsFallBack")
    public int getNumberOfTweets(String userName) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter.showUser(userName).getStatusesCount();
    }

    public int getNumberOfTweetsFallBack(String userName) {
        logger.info("An unexpected error occurred. Please, try again in a few minutes.");
        return -1;
    }
}
