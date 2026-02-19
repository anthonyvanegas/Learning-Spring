package com.app.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.cruddemo.dao.StudentDAO;
import com.app.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

    private void createStudent(StudentDAO studentDAO) {
		// Create the student object.
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@code.com");

		// TODO: Save the student object.
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// TODO: Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
