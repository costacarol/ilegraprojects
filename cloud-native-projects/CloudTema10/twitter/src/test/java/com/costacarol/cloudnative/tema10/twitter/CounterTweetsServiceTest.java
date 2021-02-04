package com.costacarol.cloudnative.tema10.twitter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import twitter4j.TwitterException;

@SpringBootTest
public class CounterTweetsServiceTest {


    @Autowired
    private CounterTweetsService counterTweetsService;


    @Test
    public void shouldReturnTweetsNumber() throws Exception{
        int total = counterTweetsService.getNumberOfTweets("carolin75885385");
        Assertions.assertEquals(2, total);
    }

    @Test
    public void shouldReturnException(){
        Exception exception = Assertions.assertThrows(TwitterException.class, () -> counterTweetsService.getNumberOfTweets("carolin75885385NotFound"));
        Assertions.assertEquals( "404:The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.\n" +
                "message - User not found.\n" +
                "code - 50\n", exception.getMessage());
    }

    @Test
    public void shouldReturnExceptionWithEmptyValue() {
        Exception exception = Assertions.assertThrows(TwitterException.class, () -> counterTweetsService.getNumberOfTweets(""));
        Assertions.assertEquals("404:The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.\n" +
                "message - User not found.\n" +
                "code - 50\n", exception.getMessage());
    }

    @Test
    public void shouldReturnExceptionWithNullValue() {
        Exception exception = Assertions.assertThrows(TwitterException.class, () -> counterTweetsService.getNumberOfTweets("null"));
        Assertions.assertEquals("403:The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).\n" +
                "message - User has been suspended.\n" +
                "code - 63\n", exception.getMessage());
    }
}
