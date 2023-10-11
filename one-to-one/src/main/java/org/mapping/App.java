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
        System.out.println( "Saving instructor along with his details" );
       // this.saveInstructor();
        System.out.println( "Done with saving instructor along with his details" );
        System.out.println( "****************************************" );

        Integer id = 3;
        System.out.println("Getting one instructor based on id");
        Instructor instructor = this.getInstructor(id);
        System.out.println(instructor);
        System.out.println( "Done Getting one instructor based on id" );
        System.out.println( "****************************************" );
    }

    public void saveInstructor(){
        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setId(103);
        instructorDetail.setHobby("Reading");
        instructorDetail.setYoutubeChannel("https://www.youtube.com/AlmamDiaby");

        Instructor instructor = new Instructor();
        instructor.setId(4);
        instructor.setEmail("almamdiaby@gmail.com");
        instructor.setFirst_name("Diaby");
        instructor.setLast_name("Almam");
        instructor.setInstructorDetail(instructorDetail);

        instructorService.saveInstructor(instructor);


        InstructorDetail instructorDetail1 = new InstructorDetail();
        instructorDetail1.setId(102);
        instructorDetail1.setHobby("Swimming");
        instructorDetail1.setYoutubeChannel("https://www.youtube.com/IsmailCamara");

        Instructor instructor1 = new Instructor();
        instructor1.setId(3);
        instructor1.setEmail("camaraismail@gmail.com");
        instructor1.setFirst_name("Camara");
        instructor1.setLast_name("Ismail");
        instructor1.setInstructorDetail(instructorDetail1);

        instructorService.saveInstructor(instructor1);
    }

    public Instructor getInstructor(Integer id){
        return instructorService.getInstructor(id);
    }
}