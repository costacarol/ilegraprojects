package com.costacarol.cloudnative.tema10.twitter;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/count")
@AllArgsConstructor
public class CounterTweetsController {

    private CounterTweetsService counterTweetsService;

    @GetMapping("/{userName}")
    public ResponseEntity<Object> listNumberOfTweets(@PathVariable("userName") String userName) {

        try {
            int tweets = counterTweetsService.getNumberOfTweets(userName);
            if (tweets >= 0) {
                return new ResponseEntity<>(new NumberOfTweetsResponse(tweets), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new TwitterFallBackResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (TwitterException | HttpClientErrorException e) {
            TwitterErrorResponse twitterErrorResponse = new TwitterErrorResponse();
            twitterErrorResponse.setStatusCode(404);
            return new ResponseEntity<>(twitterErrorResponse, HttpStatus.NOT_FOUND);
        }
    }
}

