package com.rs.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * When SpringBean is annotated with @RefreshScope it should not
 * replaced by new object unless you have configuration properties in your bean
 */
@Configuration
@EnableWebMvc
//@RefreshScope
public class WebMvcConfig {
	private static final Logger LOG = LoggerFactory.getLogger(WebMvcConfig.class);

	@Bean(name = "defaultRestTemplate")
	public RestTemplate restTemplate() {
		LOG.debug("WebMvcConfig#restTemplate()");
		return new RestTemplate();
	}
}
