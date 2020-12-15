package com.costacarol.cloudnative.tema7.integration;

import com.costacarol.cloudnative.tema7.integration.service.IntegrationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootTest
public class IntegrationServiceTest {


    @Autowired
    private IntegrationService integrationService;


    @Test
    public void shouldReturnRepositoriesNumber(){
        Object total = integrationService.getNumberOfRepositoriesAndTweets("carolin75885385", "costacarol");
        Assertions.assertEquals("NumberOfTweetsAndRepositoriesResponse(twitter={numberOfTweets=2}, github={numberOfRepositories=1})", total.toString());
    }

    @Test
    public void shouldReturnException(){
        Exception exception = Assertions.assertThrows(HttpClientErrorException.class, () -> integrationService.getNumberOfRepositoriesAndTweets("carolin75885385NotFound", "costacarolNotFound"));
        Assertions.assertEquals("404 : [{"+"\"statusCode\""+":"+"404"+","+"\"errorResponseMsg\""+":"+"\"The requested page could not be found. Check the insert data and try again.\""+"}]", exception.getMessage());
    }

    @Test
    public void shouldReturnExceptionWithNullValue(){
        Exception exception = Assertions.assertThrows(HttpClientErrorException.class, () -> integrationService.getNumberOfRepositoriesAndTweets(null, null));
        Assertions.assertEquals("404 : [{"+"\"statusCode\""+":"+"404"+","+"\"errorResponseMsg\""+":"+"\"The requested page could not be found. Check the insert data and try again.\""+"}]", exception.getMessage());
    }
}
