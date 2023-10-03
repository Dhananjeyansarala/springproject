package com.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.entity.AppolloHospital;

public interface AppolloRepository extends JpaRepository<AppolloHospital, Integer> {
	@Query(value="select * from hospital where age = (select max(age) from hospital)",nativeQuery = true)
	AppolloHospital getMaxAge();
	@Query(value="select max(age) from hospital",nativeQuery=true)
	int maximum();
	@Query(value="select * from hospital where tablet like ?",nativeQuery = true)
	public List<AppolloHospital> gettablet(String tablet);
	@Query(value="select * from hospital where age > ?",nativeQuery = true)
	public List<AppolloHospital> getage(int age);
	@Query(value="select * from hospital where age > ? and age < ?",nativeQuery = true)
	List<AppolloHospital> getagerange(int age1, int age2);
	@Query(value="select min(age) from hospital",nativeQuery=true)
	public Integer getminimum();
	
}
