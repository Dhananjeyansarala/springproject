package com.hospital.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.dao.AppolloDao;
import com.hospital.entity.AppolloHospital;

import customExceptionss.AgeCheckException;
import customExceptionss.IdNotFoundException;
import customExceptionss.TabletNotFoundException;


@Service
public class AppolloService {
	@Autowired
	AppolloDao ad;

	public String set(AppolloHospital app) throws  AgeCheckException{
		try {
		if(app.getAge()<18) {
			throw new AgeCheckException("Age is less than 18");
		}else {
		return ad.set(app);
		}
		}catch(AgeCheckException e) {
			return "Invalid age";
		}
	}

	public String collectdetails(List<AppolloHospital> app) {
		return ad.collectdetails(app);
	}
	public List<AppolloHospital> getAllAc() {
		
		return ad.getAllAc();
	}

	public AppolloHospital getbyid(int app) throws IdNotFoundException {
		
		return ad.getbyid(app);
	}

	public String deleteAc(int app) {
		
		return ad.deleteAc(app);
	}

	public String update(int id, String tablet) {
		
		return ad.update(id,tablet);
	}

//	public String update(int id, AppolloHospital ui) {
//		AppolloHospital y=getbyid(id);
//		y.setPatientName(ui.getPatientName());
//		y.setAge(ui.getAge());
//		y.setWeight(ui.getWeight());
//		y.setTablet(ui.getTablet());
//		set(y);
//		return "updated";
//	}
	public AppolloHospital getMaxAge() {
			return ad.getMaxAge();
		}

	public int maximum() {
		
		return ad.maximum();
	}

	public List<AppolloHospital> getlist() {
		List<AppolloHospital> x=ad.getAllAc();
		List<AppolloHospital> y=x.stream().filter((z)->z.getPatientName().equals("mani")).collect(Collectors.toList());
		
		return y;
	}

	public AppolloHospital getminage() {
		List<AppolloHospital> b=ad.getAllAc();
	AppolloHospital c=b.stream().min(Comparator.comparing(AppolloHospital::getAge)).get();
		
		return c;
	}

	public AppolloHospital getsecmax() {
		List<AppolloHospital> com=ad.getAllAc();
		List<AppolloHospital> max=com.stream().sorted(Comparator.comparing(AppolloHospital::getAge).reversed()).collect(Collectors.toList());
		return max.get(1);
	}

	public List<AppolloHospital> moreweight() {
		List<AppolloHospital> y=ad.getAllAc();
		List<AppolloHospital> z=y.stream().filter(x->x.getWeight()<=80&&x.getAge()<=120).collect(Collectors.toList());
		
		return z;
	}

	public List<Character> getlast() {
		List<AppolloHospital> z=ad.getAllAc();
		List<Character> y=z.stream().map(x->x.getPatientName().charAt(x.getPatientName().length()-1)).collect(Collectors.toList());
		
		return y ;
	}

	public List<AppolloHospital> gettablet(String tablet) throws TabletNotFoundException {
		List<AppolloHospital> x =  ad.gettablet(tablet);
		if(x.isEmpty()) {
			
			throw new TabletNotFoundException("Tablet Not Exists");
		}
		else {
			return x;
		}
		
	}

	public List<AppolloHospital> getage(int age) {
		
		return ad.getage(age);
	}

	public List<AppolloHospital> getagerange(int age1, int age2) {
		
		return ad.getagerange(age1,age2);
	}

//	public Integer getminimumage() {
//		
//		return ad.getminimumage();
//	}

	
}
