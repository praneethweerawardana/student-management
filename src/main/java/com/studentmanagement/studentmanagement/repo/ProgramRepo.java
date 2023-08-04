package com.studentmanagement.studentmanagement.repo;

import com.studentmanagement.studentmanagement.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProgramRepo extends JpaRepository<Program,Long> {

}
