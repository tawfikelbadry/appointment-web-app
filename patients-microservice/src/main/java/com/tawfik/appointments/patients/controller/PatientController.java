package com.tawfik.appointments.patients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawfik.appointments.patients.model.entity.Patient;
import com.tawfik.appointments.patients.model.response.BaseResponse;
import com.tawfik.appointments.patients.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/index")
	public String index() {
		return "Hello in Patient service";
	}
	
	@GetMapping("")
	public List<Patient> getAllPatients(){
		return patientService.listAll();
	}
	
	@PostMapping("/save")
	public BaseResponse savePatient(@RequestBody Patient patient ) {
		patientService.savePatient(patient);
		return new BaseResponse("patient saved successfully",true);
	}
	
	
	
}
