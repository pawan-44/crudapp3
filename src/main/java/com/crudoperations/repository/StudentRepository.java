package com.crudoperations.repository;

import org.springframework.data.repository.CrudRepository;

import com.crudoperations.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	 Student findByName(String name);
	 Student findByFee(int fee);

}
