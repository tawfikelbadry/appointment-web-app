package com.tawfik.appointments.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.appointments.patients.model.entity.Patient;
import com.tawfik.appointments.patients.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> listAll(){
		return (List<Patient>) patientRepository.findAll();
	}
	
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

}
