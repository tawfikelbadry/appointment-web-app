package com.tawfik.appointments.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.appointments.doctors.entity.Appointment;
import com.tawfik.appointments.doctors.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	public List<Appointment> listAll(){
		return (List<Appointment>) this.appointmentRepository.findAll();
	}


	public List<Appointment> listAvaialableAppointements() {
		return appointmentRepository.findByAvailable(true);
	}
}
