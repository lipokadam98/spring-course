package com.example.cruddemo;

import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.DAO.AppDAO;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			findCoursesForInstructor(appDAO);
		};
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor: "+ tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("Instructor with courses: "+ tempInstructor);

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor: "+ tempInstructor);
		System.out.println("Instructor courses: "+ tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("John", "Doe", "john@doe.com");

		// add instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com", "Loves to code");
		tempInstructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("Piano - The Complete Beginners Course");
		tempInstructor.add(course1);
		tempInstructor.add(course2);
		appDAO.save(tempInstructor);

		System.out.println("Instructor saved with courses: "+ tempInstructor);
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

	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted instructor id: "+ theId);
	}
}
