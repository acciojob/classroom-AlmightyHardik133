package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
	
	private List<Student> listStudents = new ArrayList<>();
	private List<Teacher> listTeachers = new ArrayList<>();
	
	private Map<Teacher, List<Student>> teacherStudents = new HashMap<>();
	
	public void addStudent(Student student) {
		listStudents.add(student);
	}

	public void addTeacher(Teacher teacher) {
		listTeachers.add(teacher);
		
	}

	public Student getStudentByName(String name) {
		for(Student student : listStudents) {
			if(student.getName().equals(name)) {
				return student;
			}
		}
		return new Student();
	}

	public Teacher getTeacherByName(String name) {
		for(Teacher teacher : listTeachers) {
			if(teacher.getName().equals(name)) {
				return teacher;
			}
		}
		return new Teacher();
	}
	
	public List<String> getStudentsByTeacherName(String teacher) {
		List<String> getAllStudents = new ArrayList<String>();
		
		List<Student> students = new ArrayList<>();
		Teacher teach = getTeacherByName(teacher);
		students = teacherStudents.getOrDefault(teach, new ArrayList<Student>());
		
		for(Student stud : students) {
			getAllStudents.add(stud.getName());
		}
		
		return getAllStudents;
	}

	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		List<String> allStudents = new ArrayList<>();
		allStudents = listStudents.stream().map(Student::getName).toList();
		return allStudents;
	}

	public void deleteTeacherByName(String teacher) {
		// TODO Auto-generated method stub
		Teacher teach = getTeacherByName(teacher);
		List<Student> students = teacherStudents.getOrDefault(teach, new ArrayList<Student>());
		
		for(Student stud : students) {
			listStudents.remove(stud);
		}
		teacherStudents.remove(teach);
		listTeachers.remove(teach);
		
		
	}

	public void deleteAllTeachers() {
		for(Teacher teacher : listTeachers) {
			deleteTeacherByName(teacher.getName());
		}
		listTeachers.clear();
		teacherStudents.clear();
		
	}

	public void addStudentTeacherPair(String student, String teacher) {
		Teacher teach = getTeacherByName(teacher);
		Student stud = getStudentByName(student);
		
		List<Student> studentList = teacherStudents.getOrDefault(teach, new ArrayList<>());
		
		studentList.add(stud);
		
		teacherStudents.put(teach, studentList);
		
	}
	
	
	
	
}
