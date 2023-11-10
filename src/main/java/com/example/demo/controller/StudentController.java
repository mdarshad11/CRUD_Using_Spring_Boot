package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utility.ResponseStructure;

//@Controller
@RestController
//it is combination of @controller and @ResponseBody
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> save(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/show/{studentId}")
	public ResponseEntity<ResponseStructure<Student>> fbi(@PathVariable int studentId) {
//		ResponseEntity<ResponseStructure<Student>> fbid = service.fbid(studentId);
		return service.fbid(studentId);
	}

	// @ResponseBody
	@PostMapping("/demo")
	public Student demo(@RequestBody Student s) {
		Student s1 = service.insert(s);
		return s1;
	}

	// -------------------------{ Fetch }-------------------------------

	// @RequestMapping(value = "/fetch", method = RequestMethod.GET)
	// @ResponseBody
	@GetMapping("/fetch")
	public List<Student> fetchall() {
		List<Student> s1 = (List<Student>) service.fetchALL();
		return s1;
	}

	// @RequestMapping(value = "/fetchbyid/{studentid}", method = RequestMethod.GET)
	// @ResponseBody
	@GetMapping("/fetchbyid/{studentid}")
	public ResponseEntity<ResponseStructure<Student>> fetchById(@PathVariable int studentid) {
		return service.fbid(studentid);
	}

	// @RequestMapping(value = "/fetchbyname/{studentName}", method =
	// RequestMethod.GET)
	// @ResponseBody
	@GetMapping("/fetchbyname/{studentName}")
	public List<Student> fetchByName(@PathVariable String studentName) {
		List<Student> f = service.fetchByName(studentName);
		return f;
	}

	// -------------------------{ update }-------------------------------
	// @RequestMapping(value = "/updatebyid/{studentId}", method =
	// RequestMethod.GET)
	// @ResponseBody
	// @PutMapping("/update/{studentId}")
	// public Student updateById(@PathVariable int studentId, @RequestBody Student
	// student) {
	// Student f = service.updateById(studentId, student);
	// return f;
	// }

	@PutMapping("/updatebyid/{studentId}/{studentPassword}")
	public String updateById(@PathVariable int studentId, @PathVariable String studentPassword) {
		String f = service.updateById(studentId, studentPassword);
		return f;
	}

	// @RequestMapping(value = "/updatebyname/{studentName}/{studentPassword}",
	// method = RequestMethod.GET)
	// @ResponseBody
	// @PutMapping("/updatebyname/{studentName}/{studentPassword}")
	// public Student updateByName(@PathVariable String studentName,@PathVariable
	// String studentPassword) {
	// Student f = service.updateByName(studentName, studentPassword);
	// return f;
	// }

	@PutMapping("/updatebyname/{studentName}/{studentPassword}")
	public String updateById(@PathVariable String studentName, @PathVariable String studentPassword) {
		String f = service.updateByName(studentName, studentPassword);
		return f;
	}

	// @RequestMapping(value = "/updateall/{studentPassword}", method =
	// RequestMethod.GET)
	// @ResponseBody
	@PostMapping("/updateall/{studentPassword}")
	public String updateAll(@PathVariable String studentPassword) {
		String updateAll = service.updateAll(studentPassword);
		return updateAll;
	}

//	@RequestMapping(value = "/updateall/{studentName}/{studentPassword}", method = RequestMethod.GET)
	// @ResponseBody
	// public Student updateAll( @PathVariable String studentName,@PathVariable
	// String studentPassword) {
	// Student f = service.updateAll(studentName,studentPassword);
	// return f;
	// }

	// -------------------------{ Delete }-------------------------------

	// @RequestMapping(value = "/deletebyid/{studentId}", method =
	// RequestMethod.GET)
	// @ResponseBody
	@DeleteMapping("/deletebyid/{studentId}")
	public String deleteById(@PathVariable int studentId) {
		String f = service.deleteById(studentId);
		return f;
	}

	// @RequestMapping(value = "/deletebyname/{studentName}", method =
	// RequestMethod.GET)
	// @ResponseBody
	// @DeleteMapping("/deletebyname/{studentName}")
	// public String deleteByName(@PathVariable String studentName) {
	// String f = service.deleteByName(studentName);
	// return f;
	// }

	@RequestMapping(value = "/deleteall", method = RequestMethod.GET)
	@ResponseBody
	public void deleteAll() {
		service.deleteAll();
	}

	// @ResponseBody
	// @GetMapping("/print")
	// public List<Student> print() {
	// List<Student> s1 = service.insertStudent();
	// return s1;
	// }

//	JSON Format
//	 {
//	 "studentId": 109,
//	 "sudentName": "cj",
//	 "studentPassword": "crs"
//	 }

}
