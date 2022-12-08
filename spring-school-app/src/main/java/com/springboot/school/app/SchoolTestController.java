package com.springboot.school.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolTestController {
	//GET
	//localhost:8080/school
	
	school[] schools = {};
	
	@GetMapping("/test")
	public String serverRunning() {
		return "Server is running!";
	}
	
	@GetMapping("/school")
	public school[] getSchools() {
		return this.schools;
	}
	
	@PostMapping("/school")
	public school[] addSchool(@RequestBody school request) {
		//Convert array to ArrayList
		List<school> arrlist = new ArrayList<school>(Arrays.asList(this.schools));
        // Add the new element
        arrlist.add(request);
        // Convert the ArrayList to array
        this.schools = arrlist.toArray(this.schools);

        return this.schools;
	}
}


class school {
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}