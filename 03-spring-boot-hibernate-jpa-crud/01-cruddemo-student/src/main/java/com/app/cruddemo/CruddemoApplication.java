package com.app.cruddemo;

import java.util.List;

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
			// Create a student.
			createStudent(studentDAO);

			// Read a student.
			// readStudent(studentDAO);

			// Query for students.
			// queryForStudents(studentDAO);

			// Query for students by last name.
			// queryForStudentsByLastName(studentDAO);

			// Update a student.
			// updateStudent(studentDAO);

			// Delete a student.
			// deleteStudent(studentDAO);

			// Delete all.
			// deleteAllStudents(studentDAO);
		};
	}

    private void createStudent(StudentDAO studentDAO) {
		// Create the student object.
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@code.com");

		// Save the student object.
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

    private void readStudent(StudentDAO studentDAO) {
		// Create a student object.
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Young", "Doe", "youngdoe@code.com");

		// Save the student object.
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		// Retrieve the student based on the id: primary key.
		System.out.println("Retrieving student with id: " + tempStudent.getId());
		Student retrievedStudent = studentDAO.findById(tempStudent.getId());

		// Display the student.
		System.out.println("Retrieved student: " + retrievedStudent);
	}

    private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students.
		List<Student> theStudents = studentDAO.findAll();
		
		// Display list of students.
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// Get a list of students.
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// Display list of students.
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

    private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key.
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Scooby".
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		// Update the student.
		studentDAO.update(myStudent);

		// Display the updated student.
		System.out.println("Updated student: " + myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

    private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}
}
