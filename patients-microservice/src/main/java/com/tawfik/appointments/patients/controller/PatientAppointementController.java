package com.tawfik.appointments.patients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawfik.appointments.patients.entity.PatientAppointment;
import com.tawfik.appointments.patients.service.PatientAppointmentService;

@RestController
@RequestMapping("/api/patient-appointements")
public class PatientAppointementController {
	
	@Autowired
	private PatientAppointmentService patientAppointmentService;
	
	
	@GetMapping("")
	public List<PatientAppointment> listAll(){
		return this.patientAppointmentService.findAll();
	}

}
