package com.costacarol.cloudnative.tema10.github;

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
            int repo = counterRepositoriesService.countNumberOfRepositories(userName);
            if (repo >= 0) {
                return new ResponseEntity<>(new UserGithubRepositoriesResponse(repo), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new GithubFallBackResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (HttpClientErrorException e) {
            GithubErrorResponse gitHubErrorResponse = new GithubErrorResponse();
            gitHubErrorResponse.setStatusCode(404);
            return new ResponseEntity<>(gitHubErrorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
