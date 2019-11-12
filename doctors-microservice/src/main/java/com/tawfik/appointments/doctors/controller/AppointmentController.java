package com.tawfik.appointments.doctors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawfik.appointments.doctors.model.entity.Appointment;
import com.tawfik.appointments.doctors.model.response.BaseResponse;
import com.tawfik.appointments.doctors.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("")
	public List<Appointment> listAll() {
		return this.appointmentService.listAll();
	}

	@GetMapping("/available")
	public List<Appointment> listAvailableAppointements() {
		return appointmentService.listAvaialableAppointements();

	}

	@GetMapping("/{appointementId}/is-available")
	public BaseResponse isAppointmentAvailable(@PathVariable("appointementId") long appointementId) {
		boolean isAvailable = appointmentService.isAvailable(appointementId);
		String message = (isAvailable) ? "the appointment is available" : "sorry this appointment not available";
		return new BaseResponse(message, isAvailable);
	}

	@PostMapping("/{appointmentId}/mark-unavailable")
	public BaseResponse markAppointmentAsUnavailable(@PathVariable("appointmentId") long appointmentId) {
		boolean changed = appointmentService.markAsUnavialble(appointmentId);
		String message = changed ? "appointment updated successfully" : "appointment not update";
		return new BaseResponse(message, changed);
	}

}
