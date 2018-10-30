package com.rs.app.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rs.app.model.Config;

@RestController
@RequestMapping("/rest")
@RefreshScope
public class SampleController {
	private static final Logger LOG = LoggerFactory.getLogger(SampleController.class);
	@Autowired
	@Qualifier("defaultRestTemplate")
	private RestTemplate restTemplate;
	@Autowired
	private Config config;

	public SampleController() {
		// If you enable @RefreshScope the spring container refreshes the object
		// maintained by it means it will creates new objects and put it in the scope.
		LOG.debug("SampleController: 0-param constr");
		LOG.debug("Class: " + this.getClass());
	}

	@PostConstruct
	public void init() {
		LOG.debug("RestTemplate hashCode: {}", restTemplate.hashCode());
	}

//	@GetMapping("/message")
//	public String message(@Value("${message: No message available}") String message) {
//		System.out.println("HashCode: " + this.hashCode());
//		System.out.println("RestTemplate hashCode: " + restTemplate.hashCode());
//		LOG.debug("Class: " + this.getClass());
//		return message;
//	}

	@GetMapping("/message")
	public Config message() {
		System.out.println("HashCode of SampleController: " + this.hashCode());
		System.out.println("RestTemplate hashCode: " + restTemplate.hashCode());
		System.out.println("hashCode of Config: " + config.hashCode() + " Config class: " + config.getClass());
		LOG.debug("Class: " + this.getClass());
		System.out.println("Config: " + config);
		Config config = new Config();
		BeanUtils.copyProperties(this.config, config);
		return config;
	}
}
