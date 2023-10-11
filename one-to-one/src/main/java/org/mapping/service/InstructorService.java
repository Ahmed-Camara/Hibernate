package org.mapping.service;

import org.mapping.entity.Instructor;
import org.mapping.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;


    public void saveInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public Instructor getInstructor(Integer id){

        return instructorRepository.findById(id).get();
    }
}
