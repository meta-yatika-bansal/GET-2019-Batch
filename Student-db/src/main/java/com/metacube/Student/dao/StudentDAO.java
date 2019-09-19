/*
 * DAO using Hibernate Template
 */
package com.metacube.Student.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.metacube.Student.model.Student;

public class StudentDAO {

	HibernateTemplate template;

	public StudentDAO() {
		super();
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * Adds Student
	 * @param s to be added
	 * @return no of rows
	 */
	public int add(Student s){
		return (int) template.save(s);
	}

	/**
	 * Gets All the Students
	 * @return list of students
	 */
	public List<Student> getAll(){
		return template.loadAll(Student.class);
	}
}
