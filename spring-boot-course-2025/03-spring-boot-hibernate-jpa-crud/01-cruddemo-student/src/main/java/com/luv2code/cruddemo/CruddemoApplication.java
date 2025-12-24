package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            //createStudent(studentDAO);
            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        //create a student object
        System.out.println("Creating new student object...");
        var tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

        //save the student
        studentDAO.save(tempStudent);
        //display id of the saved student
        int id = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + id);

        //retrieve the student based on the id: primary key

        var foundStudent = studentDAO.findById(id);

        //display student
        System.out.println("Found the student " + foundStudent);

    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
