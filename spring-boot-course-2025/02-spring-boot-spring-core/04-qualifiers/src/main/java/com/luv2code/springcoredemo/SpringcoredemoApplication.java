package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// If beans are in different packages than the main class, it needs to be told explicitly
@SpringBootApplication(scanBasePackages = {
        "com.luv2code.springcoredemo",
        "com.luv2code.util"
})
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
