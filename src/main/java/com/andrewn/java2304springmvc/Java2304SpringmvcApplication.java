package com.andrewn.java2304springmvc;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@SpringBootApplication
public class Java2304SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java2304SpringmvcApplication.class, args);
	}
}
