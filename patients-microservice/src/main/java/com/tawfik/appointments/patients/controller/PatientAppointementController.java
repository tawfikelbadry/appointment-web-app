package com.tawfik.appointments.patients.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tawfik.appointments.patients.constants.Constants;
import com.tawfik.appointments.patients.model.entity.PatientAppointment;
import com.tawfik.appointments.patients.model.response.BaseResponse;
import com.tawfik.appointments.patients.service.PatientAppointmentService;

@RestController
@RequestMapping("/api/patient-appointements")
public class PatientAppointementController {

	@Autowired
	private PatientAppointmentService patientAppointmentService;

	@GetMapping("")
	public List<PatientAppointment> listAll() {
		return this.patientAppointmentService.findAll();
	}

	@PostMapping("/{patientId}/appointment/{appointementId}")
	public BaseResponse reserveAppointment(@PathVariable("patientId") long patientId,
			@PathVariable("appointementId") long appointementId) {

		Map<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("appointmentId", appointementId);

		BaseResponse response = new RestTemplate()
				.getForEntity(Constants.DOCTOR_IS_APPOINTMENT_AVAILABLE_URL, BaseResponse.class, uriVariables)
				.getBody();

		if (!response.isSuccess()) {
			return response;
		}

		String message = "appointment reserved successfully";
		boolean success = patientAppointmentService.reserveAppointment(patientId, appointementId);
		if (!success) {
			message = String.format("patient with id %s not exist", patientId);
		} else {
			 new RestTemplate().postForEntity(Constants.DOCTOR_MARK_APPOINTMENT_UNAVAILABLE_URL, null, BaseResponse.class,
							uriVariables).getBody();
		}

		return new BaseResponse(message, success);
	}

}
