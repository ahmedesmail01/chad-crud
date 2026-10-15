package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
        return runner -> {
            System.out.println("Hello smsm!");

//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudend(studentDAO);
//            getAllStudents(studentDAO);
            updateStudent(studentDAO);

        };
    }

    private void updateStudent(StudentDAO studentDAO) {
//        find student
        Student myStudent = studentDAO.findById(1);
//        update the student
        myStudent.setLastName("Nasr");
        studentDAO.update(myStudent);
//        sout the new updated
        System.out.println("Updated student " + myStudent);
    }

    private void getAllStudents(StudentDAO studentDAO) {

        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudend(StudentDAO studentDAO) {
        Student theStudent = studentDAO.findById(1);
        System.out.println(theStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("Mohamed", "Nasr", "mohamed@gmail.com");
        Student tempStudent2 = new Student("sama", "samir", "sama@gmail.com");
        Student tempStudent3 = new Student("Azza", "Magdy", "Azza@gmail.com");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        System.out.println("Created students azza , sama and mohamed ");


    }

    private void createStudent(StudentDAO studentDAO) {
        //            create student
        Student tempStudent = new Student("Ahmed", "Esmail", "Ahmedesmailofficial01@gmail.com");

        //            save to database
        studentDAO.save(tempStudent);

        //            show its id
        System.out.println("Created student with ID: " + tempStudent.getId());
    }

    ;
}
