package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.entity.AppolloHospital;
import com.hospital.repository.AppolloRepository;
import com.hospital.service.AppolloService;

import customExceptionss.AgeCheckException;
import customExceptionss.IdNotFoundException;
import customExceptionss.TabletNotFoundException;


@RestController
public class AppolloController {
	@Autowired
	AppolloService as;
	@Autowired
	AppolloRepository repo;
	@PostMapping("/set")
	public String set(@RequestBody AppolloHospital app) throws AgeCheckException {
		return as.set(app);
	}
	@PostMapping("/setAll")
	public String collectdetails(@RequestBody List<AppolloHospital> app) {
		return as.collectdetails(app);
	}
	@GetMapping("/getAllAc")
	public List<AppolloHospital> getAllAc() {
		return as.getAllAc(); 
	}
	@GetMapping("/getbyid/{app}")
	public AppolloHospital getbyid(@PathVariable int app) throws IdNotFoundException {
		
		return as.getbyid(app);
	}
	@DeleteMapping("/delete/{app}")
	public String deleteAc(@PathVariable int app ) {
		return as.deleteAc(app);
	}
	@PatchMapping("/updatebyid/{id}/{tablet}")
	public String update(@PathVariable int id, @PathVariable String tablet) {
		return as.update(id,tablet);
	}
//	@PutMapping(value="/update/{id}")
//	public String update(@PathVariable int id,@RequestBody AppolloHospital ui) {
//		return as.update(id,ui);
//	}
	@GetMapping("/getMaxAge")// object maximum
	public AppolloHospital getMaxAge() {
		return as.getMaxAge();
	}@GetMapping("/maximum")
	public int maximum() {//int maximum
		return as.maximum();
	}
	@GetMapping("/getlist")
	public List<AppolloHospital> getlist() {
		return as.getlist();
				
	}
	@GetMapping("/getminage")
	public AppolloHospital getminage() {//object minimum
		return as.getminage();
	}
	@GetMapping("/secmax")
	public AppolloHospital getsecmax() {
		return as.getsecmax();
	}
	@GetMapping("/morethan80")
	public List<AppolloHospital> moreweight() {
		return as.moreweight();
	}
	@GetMapping("/getlastletter")
	public List<Character> getlast() {
		return as.getlast();
	}
	@GetMapping("/getanytablet/{tablet}")
	public List<AppolloHospital> gettablet(@PathVariable String tablet) throws TabletNotFoundException {
		return as.gettablet(tablet);
	}
	@GetMapping("/getage/{age}")
	public List<AppolloHospital> getage(@PathVariable int age) {
		return as.getage(age);
	}
	@GetMapping("/getbyage/{age1}/{age2}")
	public List<AppolloHospital> getagerange(@PathVariable int age1 ,@PathVariable int age2) {
		return as.getagerange(age1,age2);
	}
	
	@GetMapping("/getminiage")
	public Integer getminimumage() {
		return repo.getminimum();
	}
		
}
