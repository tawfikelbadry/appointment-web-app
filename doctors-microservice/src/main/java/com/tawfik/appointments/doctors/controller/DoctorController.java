package com.tawfik.appointments.doctors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawfik.appointments.doctors.entity.Doctor;
import com.tawfik.appointments.doctors.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("")
	public List<Doctor> listAll(){
		return doctorService.listAll();
	}
	

}
