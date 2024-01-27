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
		List<String> allStudentByTeacher = new ArrayList<>();
        Teacher teacher1 = getTeacherByName(teacher);
        List<Student> studentList = teacherStudents.getOrDefault(teacher1, new ArrayList<>());
        for (Student student : studentList) {
            allStudentByTeacher.add(student.getName());
        }
        return allStudentByTeacher;
	}

	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		List<String> allStudent = new ArrayList<>();
        for (Student student : listStudents) {
            allStudent.add(student.getName());
        }
        return allStudent;
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
