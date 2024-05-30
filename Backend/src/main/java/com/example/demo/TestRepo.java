package com.example.demo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TestRepo extends JpaRepository<Test, Integer>{

	@Query("SELECT t FROM Test t WHERE :now BETWEEN t.start AND t.end")
    List<Test> findActiveTests(@Param("now") LocalDateTime now);
}
