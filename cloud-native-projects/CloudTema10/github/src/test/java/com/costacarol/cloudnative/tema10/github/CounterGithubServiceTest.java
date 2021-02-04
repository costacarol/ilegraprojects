package com.costacarol.cloudnative.tema10.github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootTest
public class CounterGithubServiceTest {

    @Autowired
    private CounterRepositoriesService counterRepositoriesService;


    @Test
    public void shouldReturnRepositoriesNumber(){
        int total = counterRepositoriesService.countNumberOfRepositories("costacarol");
        Assertions.assertEquals(1, total);
    }

    @Test
    public void shouldReturnException(){
        Exception exception = Assertions.assertThrows(HttpClientErrorException.class, () -> counterRepositoriesService.countNumberOfRepositories("costacarollalalalalala"));
        Assertions.assertEquals("404 Not Found: [{"+"\"message\""+":"+"\"Not Found\""+","+"\"documentation_url\""+":"+"\"https://docs.github.com/rest/reference/users#get-a-user\""+"}]", exception.getMessage());
    }

    @Test
    public void shouldReturnExceptionWithEmptyValue(){
        Exception exception = Assertions.assertThrows(HttpClientErrorException.class, () -> counterRepositoriesService.countNumberOfRepositories(""));
        Assertions.assertEquals("404 Not Found: [{"+"\"message\""+":"+"\"Not Found\""+","+"\"documentation_url\""+":"+"\"https://docs.github.com/rest\""+"}]", exception.getMessage());
    }

    @Test
    public void shouldReturnExceptionWithNullValue(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> counterRepositoriesService.countNumberOfRepositories(null));
        Assertions.assertEquals("The requested page could not be found. Check the insert data and try again.", exception.getMessage());
    }
}
