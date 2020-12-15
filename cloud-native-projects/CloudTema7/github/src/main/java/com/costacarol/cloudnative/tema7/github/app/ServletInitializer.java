package com.costacarol.cloudnative.tema7.github.app;

import com.costacarol.cloudnative.tema7.github.GithubApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GithubApplication.class);
	}

}
