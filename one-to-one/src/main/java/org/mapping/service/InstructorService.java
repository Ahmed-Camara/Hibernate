package org.mapping.service;

import org.mapping.entity.Instructor;
import org.mapping.entity.InstructorDetail;
import org.mapping.repository.InstructorDetailRepository;
import org.mapping.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorDetailRepository instructorDetailRepository;


    public void saveInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public Instructor getInstructor(Integer id){

        return instructorRepository.findById(id).get();
    }

    public InstructorDetail getInstructorDetail(Integer id){

        return instructorDetailRepository.findById(id).get();
    }

    public void deleteInstructor(Integer id){
        Instructor instructor = instructorRepository.findById(id).get();

        if(instructor != null){

            System.out.println("Start deleting...........");
            instructorRepository.deleteById(id);
            System.out.println("Deleted successfully !!!");

        }else{

            System.out.println("Not found");
        }
    }

    public void deleteInstructorDetail(Integer id){
        InstructorDetail instructorDetail = instructorDetailRepository.findById(id).get();
        instructorDetail.getInstructor().setInstructorDetail(null);
        if(instructorDetail != null){
            System.out.println("Start deleting Details...........");
            instructorDetailRepository.delete(instructorDetail);
            System.out.println("Deleted successfully !!!");

        }else{

            System.out.println("Not found");
        }
    }
}
