package com.rs.app.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@RefreshScope
//@Component
@Configuration
public class Config implements Serializable {
	private static final long serialVersionUID = 2008688900095122440L;
	@Value("${message: No message available}")
	private String message;
	@Value("${author: No Author}")
	private String author;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Config [message=" + message + ", author=" + author + "]";
	}
}
