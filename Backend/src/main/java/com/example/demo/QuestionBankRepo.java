package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionBankRepo extends JpaRepository<QuestionBank, Integer>{

	@Query(value = "SELECT q FROM QuestionBank q ORDER BY RAND() LIMIT 1")
    Optional<QuestionBank> findRandomQuestion();

}
