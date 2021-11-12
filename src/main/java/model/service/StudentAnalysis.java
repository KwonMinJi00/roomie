package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Student;
import model.dao.StudentDAO;

// an example business class
public class StudentAnalysis {
	private StudentDAO dao;
	
	public StudentAnalysis() {}
	
	public StudentAnalysis(StudentDAO dao) {
		super();
		this.dao = dao;
	}

	// an example business method
	public List<Student> recommendFriends(String userId) throws Exception {
		Student thisuser = dao.findStudent(userId);
		if (thisuser == null) {
			throw new Exception("invalid user ID!");
		}
		int m1 = userId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisuser.getEmail().substring(m1);
		
		List<Student> friends = new ArrayList<Student>();
		
//		List<Student> studentList = dao.findStudentList(1, 10000);
//		Iterator<Student> studentIter = studentList.iterator();
//		while (studentIter.hasNext()) {
//			Student student = (Student)studentIter.next();
//
//			if (student.getEmail().equals(userId)) continue;
//			int m2 = student.getEmail().indexOf('@');
//			if (m2 == -1) continue;
//			String mserver2 = student.getEmail().substring(m2);
//
//			if (mserver1.equals(mserver2))
//				friends.add(student);
//		}
		return friends;
	}

}
