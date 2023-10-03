package com.hospital.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hospital.entity.AppolloHospital;
import com.hospital.repository.AppolloRepository;

import customExceptionss.IdNotFoundException;

@Repository
public class AppolloDao {
	@Autowired
	AppolloRepository ar;

	public String set(AppolloHospital app) {
		ar.save(app);
		return "Saved Success";
	}

	public String collectdetails(List<AppolloHospital> app) {
		ar.saveAll(app);
		return "procceded successfully";
	}

	public List<AppolloHospital> getAllAc() {
		return ar.findAll();
	}

	public AppolloHospital getbyid(int app) throws IdNotFoundException {

		return ar.findById(app).orElseThrow(() -> new IdNotFoundException("Invalid id "));
	}

	public String deleteAc(int app) {
		ar.deleteById(app);
		return "Sussessfully deleted";

	}

	public String update(int id, String tablet) {
		AppolloHospital x = ar.findById(id).get();
		x.setTablet(tablet);
		ar.save(x);
		return "updated Successfully";
	}

	public List<AppolloHospital> gettabletbyid(String tablet) {

		return null;
	}

	public AppolloHospital getMaxAge() {

		return ar.getMaxAge();
	}

	public int maximum() {

		return ar.maximum();
	}

	public List<AppolloHospital> getrange(int b, int c) {

		return null;
	}

	public List<AppolloHospital> gettablet(String tablet) {

		return ar.gettablet(tablet);

	}

	public List<AppolloHospital> getage(int age) {

		return ar.getage(age);
	}

	public List<AppolloHospital> getagerange(int age1, int age2) {

		return ar.getagerange(age1, age2);
	}
//	public Integer getminimumage() {
//		return getminimumage();
//	}

}
