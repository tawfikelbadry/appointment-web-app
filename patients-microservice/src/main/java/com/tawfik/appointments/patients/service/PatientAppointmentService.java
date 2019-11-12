package com.tawfik.appointments.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.appointments.patients.model.entity.Patient;
import com.tawfik.appointments.patients.model.entity.PatientAppointment;
import com.tawfik.appointments.patients.model.enums.ReserveAppointmentReturn;
import com.tawfik.appointments.patients.repository.PatientAppointementRepository;
import com.tawfik.appointments.patients.repository.PatientRepository;

@Service
public class PatientAppointmentService {

	@Autowired
	private PatientAppointementRepository patientAppointementRepository;

	@Autowired
	private PatientRepository patientRepository;

	public List<PatientAppointment> findAll() {
		return (List<PatientAppointment>) patientAppointementRepository.findAll();
	}

	public boolean reserveAppointment(long patientId, long appointementId) {
		Patient patient = patientRepository.findById(patientId).orElse(null);
		if (null == patient) {
			return false;
		}
		PatientAppointment patientAppointment = new PatientAppointment();
		patientAppointment.setAppointmentId(appointementId);
		patientAppointment.setPatient(patient);
		patientAppointementRepository.save(patientAppointment);
		return true;
	}

}
