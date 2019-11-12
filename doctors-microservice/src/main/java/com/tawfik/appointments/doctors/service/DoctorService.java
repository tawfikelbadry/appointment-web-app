package com.tawfik.appointments.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.appointments.doctors.model.entity.Doctor;
import com.tawfik.appointments.doctors.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	public List<Doctor> listAll(){
		return (List<Doctor>) this.doctorRepository.findAll();
	}
	
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
}
