package com.tawfik.appointments.doctors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.appointments.doctors.model.entity.Appointment;
import com.tawfik.appointments.doctors.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public List<Appointment> listAll() {
		return (List<Appointment>) this.appointmentRepository.findAll();
	}

	public List<Appointment> listAvaialableAppointements() {
		return appointmentRepository.findByAvailable(true);
	}

	public boolean isAvailable(long appointementId) {
		Appointment appointment = this.appointmentRepository.findByIdAndAvailable(appointementId, true).orElse(null);
		return (null != appointment);
	}

	public boolean markAsUnavialble(long appointmentId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
		if (null != appointment) {
			appointment.setAvailable(false);
			appointmentRepository.save(appointment);
			return true;
		}
		return false;
	}
}
