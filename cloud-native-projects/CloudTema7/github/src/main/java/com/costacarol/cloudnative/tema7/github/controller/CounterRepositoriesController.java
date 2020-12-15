package com.costacarol.cloudnative.tema7.github.controller;

import com.costacarol.cloudnative.tema7.github.model.GithubErrorResponse;
import com.costacarol.cloudnative.tema7.github.model.UserGithubRepositoriesResponse;
import com.costacarol.cloudnative.tema7.github.service.CounterRepositoriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;


@RestController
@RequestMapping("/count")
@AllArgsConstructor
public class CounterRepositoriesController {

    private CounterRepositoriesService counterRepositoriesService;

    @GetMapping("/{userName}")
    public ResponseEntity<Object> countNumberOfRepositoriesController(@PathVariable("userName") String userName) {
        try {
            return new ResponseEntity<>(new UserGithubRepositoriesResponse(counterRepositoriesService.countNumberOfRepositories(userName)), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            GithubErrorResponse gitHubErrorResponse = new GithubErrorResponse();
            gitHubErrorResponse.setStatusCode(404);
            return new ResponseEntity<>(gitHubErrorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
