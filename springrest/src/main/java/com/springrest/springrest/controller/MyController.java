package com.springrest.springrest.controller;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;



@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
   @GetMapping("/home")
	public String home() {
		return "This is home";
	}
   
   
   //getting the courses
   
   @GetMapping("/course")
   @ManagedOperation

   public List<Course> getCourses(){
	   
	   return this.courseService.getCourses();

   }
   
   @PostMapping("/course")
   @ManagedOperation
   public Course addCourse(@RequestBody Course course) {

	   return this.courseService.addCourse(course);
   }
   
}

