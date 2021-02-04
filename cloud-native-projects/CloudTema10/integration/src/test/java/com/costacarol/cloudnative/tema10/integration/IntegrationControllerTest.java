package com.costacarol.cloudnative.tema10.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IntegrationService integrationService;

    @Test
    void shouldReturnSuccess() throws Exception {
        when(integrationService.getNumberOfRepositoriesAndTweets("carolin75885385","costacarol")).thenReturn(NumberOfTweetsAndRepositoriesResponse.class);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/twitter/{userTwitter}/github/{userGithub}", "carolin75885385", "costacarol"))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void shouldReturnNotFound() throws Exception {
        when(integrationService.getNumberOfRepositoriesAndTweets("carolin75885385NotFound","costacarolNotFound")).thenThrow(ResponseStatusException.class);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/twitter/{userTwitter}/github/{userGithub}", "carolin75885385NotFound", "costacarolNotFound"))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is(404));
    }
}
