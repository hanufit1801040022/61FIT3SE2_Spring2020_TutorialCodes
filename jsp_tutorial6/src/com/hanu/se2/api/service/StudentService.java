package com.hanu.se2.api.service;

import java.util.LinkedList;
import java.util.List;

import com.hanu.se2.api.model.Student;

public class StudentService {

	public List<Student> getAll() {
		List<Student> students = new LinkedList<>();
		students.add(new Student(1, "quynh", "0123456789"));
		students.add(new Student(1, "binh", "0123456789"));
		return students;
	}
	
}
