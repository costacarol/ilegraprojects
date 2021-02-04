package com.costacarol.cloudnative.tema10.github;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CounterRepositoriesService {

    private static final Logger logger = LoggerFactory.getLogger(CounterRepositoriesService.class);

    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "countNumberOfRepositoriesFallBack")
    public int countNumberOfRepositories(String userName) {
        if (userName != null) {
        UserGithub userGithub = restTemplate.getForObject("https://api.github.com/users/" + userName, UserGithub.class);
        return userGithub.getPublic_repos();
        } else
            throw new IllegalArgumentException("The requested page could not be found. Check the insert data and try again.");
    }

        public int countNumberOfRepositoriesFallBack (String userName) {
            logger.info("An unexpected error occurred. Please, try again in a few minutes.");
            return -1;
        }
    }

