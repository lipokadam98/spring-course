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
			/*
			findInstructorById(appDAO);
			deleteInstructorById(appDAO);
			findInstructorDetailById(appDAO);*/
			deleteInstructorDetailById(appDAO);
			createInstructor(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(3);
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);
		System.out.println("Instructor detail: "+ instructorDetail);

		if(instructorDetail != null){
			Instructor instructor = instructorDetail.getInstructor();

			System.out.println("Instructor: "+ instructor);
		}
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("John", "Doe", "john@doe.com");

		// add instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com", "Loves to code");
		tempInstructor.setInstructorDetail(instructorDetail);
		appDAO.save(tempInstructor);
	}

	private void findInstructorById(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("tempInstructor detail: "+ tempInstructor.getInstructorDetail());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted instructor id: "+ theId);
	}
}
