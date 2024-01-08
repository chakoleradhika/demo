package com.ty.handleexceptionboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student stud)
	{
		String studName=stud.getName();
		studName= studName +" : "+studName.length();
		
		//setting the updated student name to the student object
		stud.setName(studName);
		
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		responseStructure.setStatuscode(200);
		responseStructure.setMessage("success");
		responseStructure.setData(stud);
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
	}

}
