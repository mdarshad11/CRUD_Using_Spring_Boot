package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exceptionHandler.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.utility.ResponseStructure;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;

//	public ResponseEntity<Student> saveStudent(Student student) {
//		Student save = repository.save(student);
//		return new ResponseEntity<Student>(save, HttpStatus.CREATED);
//	}
//
//	public ResponseEntity<Student> fbid(int id) {
//		Optional<Student> s = repository.findById(id);
//		if (s.isEmpty()) {
//			return null;
//		} else {
//			Student student = s.get();
//			return new ResponseEntity<Student>(student, HttpStatus.FOUND);
//		}
//	}

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		Student save = repository.save(student);

		ResponseStructure<Student> res = new ResponseStructure<>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("Object save sucessfully");
		res.setT(save);

		return new ResponseEntity<ResponseStructure<Student>>(res, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> fbid(int id) {
		Optional<Student> s = repository.findById(id);
		if (s.isEmpty()) {
//			ResponseStructure<Student> res = new ResponseStructure<>();
//			res.setMessage("Student is not found");
//			res.setStatusCode(HttpStatus.NOT_FOUND.value());
//			res.setException(new StudentNotFoundException("Students with the " + id + "Not Found").getClass());
//
//			return new ResponseEntity<ResponseStructure<Student>>(res, HttpStatus.NOT_FOUND);
			
			throw new StudentNotFoundException("student not found");
		} 
		else {
			Student student = s.get();

			ResponseStructure<Student> res = new ResponseStructure<>();
			res.setStatusCode(HttpStatus.FOUND.value());
			res.setMessage("Object save sucessfully");
			res.setT(student);

			return new ResponseEntity<ResponseStructure<Student>>(res, HttpStatus.FOUND);
		}
	}

	// ===============================================================================

	public Student insert(Student s) {
		Student s1 = repository.save(s);
		s1.getstudentId();
		s1.getsudentName();
		s1.getstudentPassword();
		return s1;
	}

	public Iterable<Student> fetchALL() {
		Iterable<Student> findAll = repository.findAll();
		return findAll;
	}

	public List<Student> fetchByName(String name) {
		List<Student> findAll = repository.findByName(name);
		return findAll;
	}

	public Student fetchById(int id) {
		Optional<Student> sdetail = repository.findById(id);
		if (sdetail.get() == null)
			return null;
		else
			return sdetail.get();
	}

	// -------------------------{ update }-------------------------------
//	public Student updateById(int studentId, Student student) {
//		Optional<Student> optional = repository.findById(studentId);
//
//		if (optional.isEmpty()) {
//			return null;
//		} else {
//			student = optional.get();
//			student.setstudentId(studentId);
//			student.setstudentPassword(null);
//			repository.save(student);
//			return student;
//		}
//	}

	public String updateById(int studentId, String studentPassword) {
		repository.updateById(studentId, studentPassword);
		return "update password is " + studentPassword + " by id is " + studentId;
	}

	public String updateByName(String studentName, String studentPassword) {
		repository.updateByName(studentName, studentPassword);
		return "update password is " + studentPassword + " by Name is " + studentName;
	}

	public String updateAll(String studentPassword) {
		repository.updateAll(studentPassword);
		return "update all " + studentPassword;
	}

//	public Student updateByName(String studentName, String studentPassword) {
//		Student uid =repository.updateByName(studentName,studentPassword);
//		return uid;
//	}

	// -------------------------{ update }-------------------------------
	public String deleteById(int studentId) {
		repository.deleteById(studentId);
		return studentId + " id object is deleted";
	}

	public void deleteAll() {
		repository.deleteAll();
	}

//	public String deleteByName(String studentName) {
//		repository.deleteByName(studentName);
//		return " name of the deleted object is "+studentName;
//	}

//	public Student deleteAll(String studentName, String studentPassword) {
//		Student uid=repository.updateAll(studentName, studentPassword);
//		return uid;
//	}

	/*
	 * public List<Student> insertStudent() {
	 * 
	 * Student s = new Student(); s.setstudentId(107); s.setsudentName("aj");
	 * s.setstudentPassword("ars"); // Student s1 = new Student();
	 * s1.setstudentId(108); s1.setsudentName("bj"); s1.setstudentPassword("brs");
	 * // Student s3 = new Student(); s3.setstudentId(109); s3.setsudentName("cj");
	 * s3.setstudentPassword("crs");
	 * 
	 * //// repository.save(s); //// repository.save(s1); //// repository.save(s3);
	 * 
	 * List<Student> sLsit = new ArrayList<>(); sLsit.add(s); sLsit.add(s1);
	 * sLsit.add(s3);
	 * 
	 * Iterable<Student> saveAll = repository.saveAll(sLsit);
	 * 
	 * return (List<Student>) saveAll; }
	 */
}
