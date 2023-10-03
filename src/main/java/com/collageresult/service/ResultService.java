package com.collageresult.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.collageresult.dao.ResultDao;
import com.collageresult.entity.MarkDetail;
import com.collageresult.entity.Result;
import com.collageresult.entity.StudDetail;

import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;



@Service
public class ResultService {
	@Autowired
	RestTemplate rt;
   @Autowired
   ResultDao rd;

	public String setit() {
		String url1="http://localhost:8081/getAll";
		String url2="http://localhost:8082/getAll";
		ResponseEntity<List<StudDetail>> response1=rt.exchange(url1,HttpMethod.GET,null,new ParameterizedTypeReference
				<List<StudDetail>>() {});
		List<StudDetail> collect1=response1.getBody();
		ResponseEntity<List<MarkDetail>> response2=rt.exchange(url2,HttpMethod.GET,null,new ParameterizedTypeReference
				<List<MarkDetail>>() {});
		List<MarkDetail> collect2=response2.getBody();
	
		
		List<Result> res=new LinkedList<>();
		for(StudDetail s:collect1) {
			Result r=new Result();
			r.setName(s.getName());
			r.setRollNo(s.getRollNo());
			int attendance=s.getAttendance();
			int totalMarks=0;
			int studid=s.getId();
			for(MarkDetail cm: collect2) {
				int markid=cm.getId();
				if(studid==markid) {
					totalMarks=cm.getSem1Total()+cm.getSem2Total();
				}
			}
			if(attendance>90&&attendance<=95) {
				totalMarks=totalMarks+5;
			}
			r.setTotalMarks(totalMarks/2);
			r.setPercentage(totalMarks/2);
			res.add(r);	
		}
		return rd.setit(res);
		
	}

	public int gettopper() {
		
		return 0;
	}

	public List<Result> gettopper(int one) {
		
		return rd.gettopper(one);
	}

	public List<Result> gettop3(int a) {
		
		return rd.gettop3(a);
	}

	public List<Result> getrange(int a, int b) {
		
		return rd.getrange(a,b);
	}

	
	public List<Result> getAll() {
		
		return rd.getAll();
	}

	public Result gettop(int top) {
		List<Result> x=rd.getAll();
		Result y=x.stream().sorted(Comparator.comparing(Result::getTotalMarks).reversed()).skip(0).findFirst().get();
		
		return y;
	}

	public List<Result> get3toplist(int c) {
		List<Result> a=rd.getAll();
		
		List<Result> b=a.stream().sorted(Comparator.comparing(Result::getTotalMarks).reversed()).limit(3).collect(Collectors.toList());
		return b;
	}

	public List<Result> range(int d, int e) {
		List<Result> g=rd.getAll();
		List<Result> y=g.stream().filter((x)->x.getPercentage()>70&&x.getPercentage()<93).collect(Collectors.toList());
		return y;
	}

}
