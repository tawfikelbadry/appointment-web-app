package com.tawfik.appointments.patients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawfik.appointments.patients.entity.Patient;
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
	
	
	
}
