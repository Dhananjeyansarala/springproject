package com.collageresult.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collageresult.entity.Result;
import com.collageresult.service.ResultService;

@RestController
public class ResultController {
	@Autowired
	ResultService rs;
	@PostMapping("/setit")
	public String setit() {
		return rs.setit();
	}
	@GetMapping("/getTopper/{one}")
	public List<Result> gettopper(@PathVariable int one) {
		return rs.gettopper(one);
	}
	@GetMapping("/getTop3/{a}")
	public List<Result> gettop3(@PathVariable int a) {
		return rs.gettop3(a);
	}
	@GetMapping("/getrange/{a}/{b}")
	public List<Result> getrange(@PathVariable int a,@PathVariable int b) {
		return rs.getrange(a,b);
	}
	//alternative method
	@GetMapping("/getAll")
	public List<Result> getAll() {
		return rs.getAll();
	}
	@GetMapping("/gettop/{top}")
	public Result gettop(@PathVariable int top) {
		return rs.gettop(top);
	}
	@GetMapping("/gettoplist/{c}")
	public List<Result> get3toplist(@PathVariable int c) {
		return rs.get3toplist(c);
		
	}@GetMapping("/range/{d}/{e}")
	public List<Result> range(@PathVariable int d,@PathVariable int e) {
		return rs.range(d, e);
	}

}
