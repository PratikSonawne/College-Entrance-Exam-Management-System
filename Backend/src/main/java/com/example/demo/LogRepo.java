package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Log, Integer>{

	int countByUserIdAndTestId(int userid, int testid);
	int countByUserIdAndTestIdAndVerify(int userid, int testid, int verify);
	
	List<Log> findByUserIdAndTestId(int userid, int testid);
	List<Log> findBySubmitAndVerify(int submit,int verify);

}
