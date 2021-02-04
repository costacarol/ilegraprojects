package com.costacarol.cloudnative.tema10.twitter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import twitter4j.TwitterException;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CounterTweetsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CounterTweetsService counterTweetsService;

	@Test
	void shouldReturnSuccess() throws Exception {
		when(counterTweetsService.getNumberOfTweets("carolin75885385")).thenReturn(2);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/count/{userName}", "carolin75885385"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	void shouldReturnNotFound() throws Exception {
		when(counterTweetsService.getNumberOfTweets("carolin75885385NotFound")).thenThrow(TwitterException.class);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/count/{userName}", "carolin75885385NotFound"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is(404));
	}
}