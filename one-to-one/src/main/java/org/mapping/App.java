package org.mapping;

import lombok.extern.slf4j.Slf4j;
import org.mapping.entity.Instructor;
import org.mapping.entity.InstructorDetail;
import org.mapping.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner{
    @Autowired
    private  InstructorService instructorService;
    public static void main( String[] args ){
        SpringApplication.run(App.class,args);

    }
    @Override
    public void run(String... args) throws Exception {

        //1. Save in the database
        this.saveInstructor();

        //2. Retrieve from the database
        Integer id = 3;
        Instructor instructor = this.getInstructor(id);
        System.out.println(instructor);
    }

    public void saveInstructor(){
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setId(100);
        instructorDetail.setHobby("Learning");
        instructorDetail.setYoutubeChannel("https://www.youtube.com/AhmedCamara");

        Instructor instructor = new Instructor();
        instructor.setId(4);
        instructor.setEmail("camarahmed@gmail.com");
        instructor.setFirst_name("Camara");
        instructor.setLast_name("Ahmed");
        instructor.setInstructorDetail(instructorDetail);

        instructorService.saveInstructor(instructor);

    }

    public Instructor getInstructor(Integer id){
        return instructorService.getInstructor(id);
    }
}