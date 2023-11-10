package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("select s from Student s where s.sudentName LIKE %?1%")
	public List<Student> findByName(String sudentName);
	
	
//	@Transactional
//	@Modifying
//	@Query("delete Student s set s.studentName =:studentName")
//	public String deleteByName(@Param("studentName") String studentName);

	@Transactional
	@Modifying
	@Query("update Student s set s.studentPassword =:studentPassword where s.studentId =:studentId")
	public void updateById(@Param("studentId") int id, @Param("studentPassword") String password);

	@Transactional
	@Modifying
	@Query("update Student s set s.studentPassword =:studentPassword where s.sudentName =:sudentName")
	public void updateByName(@Param("sudentName") String sudentName, @Param("studentPassword") String studentPassword);

	@Transactional
	@Modifying
	@Query("update Student s set s.studentPassword =:password")
	public void updateAll(@Param("password") String password);

//	@Query("update Student s set s.studentPassword=?2 where s.studentName LIKE ?1")
//	public Student updateByName(String studentName, String studentPassword);

	

//	@Query("update Student s set s.studentPassword=?2 where s.studentName LIKE ?1")
//	public Student updateAll(String studentName, String studentPassword);
}
