package com.crudoperations;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.crudoperations.entities.Student;
import com.crudoperations.repository.StudentRepository;

@SpringBootTest
class CruddemoApplicationTests {
	@Autowired
	private StudentRepository studentRepo;
	@Test
	void saveOneStudent() {
		
		Student s=new Student();
	
		s.setName("Ram");
		s.setCourse("developer");
		s.setFee(30000);
		studentRepo.save(s);
	}	
	@Test
	void deleteOneStudent() {
		studentRepo.deleteById(2L);
	}
	
	@Test
	void findOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getFee());
		System.out.println(student.getCourse());
	
	}
	@Test
	void findOneStudentByName() {
		Student student = studentRepo.findByName("stallin");
		System.out.println(student.getId());
		System.out.println(student.getFee());
		
		
	}
	@Test
	void findOneStudentByFee() {
		Student student = studentRepo.findByFee(10000);
		System.out.println(student.getId());
		System.out.println(student.getFee());
		
		
	}
	
	@Test
	void updateOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		student.setCourse("testing");
		
		studentRepo.save(student);
	}
	
	@Test
	void getAllStudent() {
		Iterable<Student> findAll = studentRepo.findAll();
		
		System.out.println(findAll);
		
		for (Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}
	}

}
