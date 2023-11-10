package com.example.demo.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Student {
	@Id
	private int studentId;
	private String sudentName;
	private String studentPassword;

	public int getstudentId() {
		return studentId;
	}

	public void setstudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getsudentName() {
		return sudentName;
	}

	public void setsudentName(String sudentName) {
		this.sudentName = sudentName;
	}

	public String getstudentPassword() {
		return studentPassword;
	}

	public void setstudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Override
	public String toString() {
		return "ProductEntity [studentId=" + studentId + ", sudentName=" + sudentName + ", studentPassword="
				+ studentPassword + "]";
	}

	

}
