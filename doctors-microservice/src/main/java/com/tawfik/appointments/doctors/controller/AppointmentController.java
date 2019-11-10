package com.tawfik.appointments.doctors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawfik.appointments.doctors.entity.Appointment;
import com.tawfik.appointments.doctors.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("")
	public List<Appointment> listAll(){
		return this.appointmentService.listAll();
	}
	
	@GetMapping("/available")
	public List<Appointment> listAvailableAppointements(){
		return appointmentService.listAvaialableAppointements();
		
	}
	
}
