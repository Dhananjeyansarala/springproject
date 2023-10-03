package com.collageresult.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collageresult.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{
	@Query(value="select * from result order by total_marks desc limit ? ",nativeQuery = true)
	List<Result> gettopper(int one);
	
@Query(value="select* from result order by total_marks desc limit ? ",nativeQuery = true)
	List<Result> gettop3(int a);
@Query(value="select * from result where percentage between ? and ? ",nativeQuery = true)
    List<Result> getrange(int a, int b);

}
