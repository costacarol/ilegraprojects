package com.costacarol.cloudnative.tema7.integration.controller;


import com.costacarol.cloudnative.tema7.integration.model.IntegrationErrorResponse;
import com.costacarol.cloudnative.tema7.integration.service.IntegrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class IntegrationController {

    private IntegrationService integrationService;


    @GetMapping("/twitter/{userTwitter}/github/{userGithub}")
    public ResponseEntity<Object> counterGithubAndTwitter(@PathVariable("userTwitter") String userTwitter,
                                                          @PathVariable("userGithub") String userGithub){
        try{
            return new ResponseEntity<>(integrationService.getNumberOfRepositoriesAndTweets(userTwitter, userGithub), HttpStatus.OK);
        } catch (ResponseStatusException e){
            IntegrationErrorResponse integrationErrorResponse = new IntegrationErrorResponse();
            integrationErrorResponse.setStatusErrorCode(404);
            return new ResponseEntity<>(integrationErrorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
