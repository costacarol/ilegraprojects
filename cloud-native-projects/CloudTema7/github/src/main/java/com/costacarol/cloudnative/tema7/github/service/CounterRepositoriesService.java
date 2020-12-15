package com.costacarol.cloudnative.tema7.github.service;

import com.costacarol.cloudnative.tema7.github.model.UserGithub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CounterRepositoriesService {

    @Autowired
    RestTemplate restTemplate;

    public int countNumberOfRepositories(String userName) throws HttpClientErrorException {
        UserGithub userGithub = restTemplate.getForObject("https://api.github.com/users/" + userName, UserGithub.class);
        if (userName != null) {
            return userGithub.getPublic_repos();
        } else
            throw new IllegalArgumentException("The requested page could not be found. Check the insert data and try again.");
    }
}
