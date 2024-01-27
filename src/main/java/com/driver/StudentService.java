package com.driver;

import java.util.List;

public class StudentService {
	
	private StudentRepository repository;

	public void addStudent(Student student) {
		repository.addStudent(student);
		
	}

	public void addTeacher(Teacher teacher) {
		repository.addTeacher(teacher);
		
	}

	public void addStudentTeacherPair(String student, String teacher) {
		// TODO Auto-generated method stub
		repository.addStudentTeacherPair(student, teacher);
		
	}

	public Student getStudentByName(String name) {
		
		return repository.getStudentByName(name);
	}

	public Teacher getTeacherByName(String name) {

		return repository.getTeacherByName(name);
	}

	public List<String> getStudentsByTeacherName(String teacher) {
		// TODO Auto-generated method stub
		return repository.getStudentsByTeacherName(teacher);
	}

	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		return repository.getAllStudents();
	}

	public void deleteTeacherByName(String teacher) {
		repository.deleteTeacherByName(teacher);
		
	}

	public void deleteAllTeachers() {
		// TODO Auto-generated method stub
		repository.deleteAllTeachers();
		
	}

	
	

}
