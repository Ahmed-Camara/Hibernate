package com.hibernate.repository;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
