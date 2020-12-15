package com.costacarol.cloudnative.tema7.github;

import com.costacarol.cloudnative.tema7.github.service.CounterRepositoriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CountGithubControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CounterRepositoriesService counterRepositoriesService;

	@Test
	void shouldReturnSuccess() throws Exception {
			when(counterRepositoriesService.countNumberOfRepositories("costacarol")).thenReturn(1);
			this.mockMvc.perform(MockMvcRequestBuilders.get("/count/{userName}", "costacarol"))
					.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is(200));
		}

	@Test
	void shouldReturnNotFound() throws Exception {
		when(counterRepositoriesService.countNumberOfRepositories("costacarol")).thenThrow(HttpClientErrorException.class);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/count/{userName}", "costacarol"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is(404));
	}
}