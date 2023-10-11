package org.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.mapping.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
}
