package com.collageresult.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collageresult.entity.Result;
import com.collageresult.repository.ResultRepository;
@Repository
public class ResultDao {
	@Autowired
	ResultRepository rr;

	public String setit(List<Result> res) {
		
		rr.saveAll(res);
		return "saved successfully and added";
	}

	public List<Result> gettopper(int one) {
		
		return rr.gettopper(one);
	}

	public List<Result> gettop3(int a) {
		
		return rr.gettop3(a);
	}

	public List<Result> getrange(int a, int b) {
		
		return rr.getrange(a,b);
	}

	public List<Result> getAll() {
		
		return rr.findAll();
	}

}
