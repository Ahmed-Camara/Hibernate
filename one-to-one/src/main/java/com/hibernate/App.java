package com.hibernate;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.repository.InstructDetailRepository;
import com.hibernate.repository.InstructorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructDetailRepository instructorDetailRepository;

    public static void main( String[] args ){
        SpringApplication.run(com.hibernate.App.class,args);
    }
    @Override
    public void run(String... args) throws Exception {
        //saveInstructor();
       // deleteInstructor();
        //getInstructor();
        deleteInstructorDetail();
    }

    private void saveInstructor(){
        //create the objects
        Instructor tempInstructor = new Instructor("Ahmed","Camara","camara@gmail.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/AhmedCamara","Coding");

        //associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        //save the objects
        instructorRepository.save(tempInstructor);
    }

    private void deleteInstructor(){
        //get instructor by Id
        int theId = 1;
        Instructor instructor = null;
        Optional<Instructor> optionalInstructor = instructorRepository.findById(theId);
        //if instructor exists, then delete the instructors
        if (optionalInstructor.isPresent()){
            instructor = optionalInstructor.get();
            instructorRepository.delete(instructor);
            System.out.println("Instructor with id "+theId+" deleted");
        }
    }

    private void getInstructor(){
        int theId = 2;
        InstructorDetail instructorDetail = null;

        Optional<InstructorDetail> instructorDetailOptional = instructorDetailRepository.findById(theId);

        if (instructorDetailOptional.isPresent()){
            instructorDetail = instructorDetailOptional.get();
            System.out.println("  "+instructorDetail);
        }
    }

    private void deleteInstructorDetail(){
        //get instructorDetail by Id
        int theId = 3;
        InstructorDetail instructorDetail = null;
        Optional<InstructorDetail> optionalInstructorDetail = instructorDetailRepository.findById(theId);
        //if instructorDetail exists, then delete the instructors
        if (optionalInstructorDetail.isPresent()){
            instructorDetail = optionalInstructorDetail.get();
            instructorDetail.getInstructor().setInstructorDetail(null);
            instructorDetailRepository.delete(instructorDetail);
            System.out.println("InstructorDetail with id "+theId+" deleted");
        }
    }
}
