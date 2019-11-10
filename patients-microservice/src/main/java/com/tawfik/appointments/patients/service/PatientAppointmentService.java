package com.tawfik.appointments.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.appointments.patients.entity.PatientAppointment;
import com.tawfik.appointments.patients.repository.PatientAppointementRepository;

@Service
public class PatientAppointmentService {

	@Autowired
	private PatientAppointementRepository patientAppointementRepository;
	
	public List<PatientAppointment> findAll(){
		return (List<PatientAppointment>) patientAppointementRepository.findAll();
	}
	
}
