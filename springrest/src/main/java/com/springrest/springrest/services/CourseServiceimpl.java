package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService{
	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;
	public CourseServiceimpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Course", "basics of java"));
//		list.add(new Course(140, "Spring boot", "Creating restapi"));
		// TODO Auto-generated constructor stub
	}
		
	
	
	public List<Course> getCourses(){
     	return courseDao.findAll();
	}
	
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		
		return course;
	}
//	public Course addCourse(Course course) {
////		list.add(course);
//		courseDao.save(course);
//		count = count + 1;
//		System.out.print(count);
//		return course;
//	}

}
