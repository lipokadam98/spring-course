package com.example.cruddemo;

import com.example.cruddemo.entity.DAO.AppDAO;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("John", "Doe", "john@doe.com");

		// add instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com", "Loves to code");
		tempInstructor.setInstructorDetail(instructorDetail);
		appDAO.save(tempInstructor);
	}
}
