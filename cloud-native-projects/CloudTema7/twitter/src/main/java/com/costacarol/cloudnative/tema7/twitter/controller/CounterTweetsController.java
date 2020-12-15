package com.costacarol.cloudnative.tema7.twitter.controller;


import com.costacarol.cloudnative.tema7.twitter.service.CounterTweetsService;
import com.costacarol.cloudnative.tema7.twitter.model.NumberOfTweetsResponse;
import com.costacarol.cloudnative.tema7.twitter.model.TwitterErrorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import twitter4j.TwitterException;

@RestController
@AllArgsConstructor
@RequestMapping("/count")
public class CounterTweetsController {

    private CounterTweetsService counterTweetsService;

    @GetMapping("/{userName}")
    public ResponseEntity listNumberOfTweets(@PathVariable("userName") String userName){
        try{
            return new ResponseEntity<>(new NumberOfTweetsResponse(counterTweetsService.getNumberOfTweets(userName)), HttpStatus.OK);
        } catch (TwitterException | ResponseStatusException e){
            TwitterErrorResponse twitterErrorResponse = new TwitterErrorResponse();
            twitterErrorResponse.setStatusCode(404);
            return new ResponseEntity<>(twitterErrorResponse, HttpStatus.NOT_FOUND);
        }
    }
}

