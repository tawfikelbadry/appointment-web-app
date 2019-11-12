package com.tawfik.appointment.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tawfik.appointment.gateway.constants.Constants;
import com.tawfik.appointment.gateway.model.entity.User;
import com.tawfik.appointment.gateway.model.response.BaseResponse;
import com.tawfik.appointment.gateway.model.response.LoginResponse;
import com.tawfik.appointment.gateway.model.vm.DoctorRegisterVm;
import com.tawfik.appointment.gateway.model.vm.DoctorVm;
import com.tawfik.appointment.gateway.model.vm.LoginVm;
import com.tawfik.appointment.gateway.model.vm.PatientRegisterVm;
import com.tawfik.appointment.gateway.model.vm.PatientVm;
import com.tawfik.appointment.gateway.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserrController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public List<User> listAll() {
		return userService.listAll();
	}

	@PostMapping("/register-doctor")
	public BaseResponse registerDoctor(@RequestBody DoctorRegisterVm doctorRegisterVm) {
		User savedUser = userService.saveDoctor(doctorRegisterVm);

		if (savedUser == null) {
			return new BaseResponse("this username already exist", false);
		}
		DoctorVm doctorVm = new DoctorVm(doctorRegisterVm);
		doctorVm.setUserId(savedUser.getId());
		BaseResponse response = new RestTemplate()
				.postForEntity(Constants.DOCTORS_SAVE_DOCTOR_URL, doctorVm, BaseResponse.class).getBody();

		if (response.isSuccess()) {
			return new BaseResponse("Doctor registerd successfully", true);
		}
		return new BaseResponse("some error happend, Please try later", false);
	}

	@PostMapping("/register-patient")
	public BaseResponse registerPatient(@RequestBody PatientRegisterVm patientRegisterVm) {

		User savedUser = userService.savePatient(patientRegisterVm);
		if (savedUser == null) {
			return new BaseResponse("this username already exist", false);
		}

		PatientVm patientVm = new PatientVm(patientRegisterVm);
		patientVm.setUserId(savedUser.getId());
		BaseResponse response = new RestTemplate()
				.postForEntity(Constants.PATIENTS_SAVE_PATIENT_URL, patientVm, BaseResponse.class).getBody();

		if (response.isSuccess()) {
			return new BaseResponse("Patient registerd successfully", true);
		}
		return new BaseResponse("some error happend, Please try later", false);
	}

	// TODO need to handle the security authentication and authorization
	// this service just return if the user is registerd or not only and not handle
	// any security real concerns
	@PostMapping("/is-authenticate")
	public BaseResponse isAuthenticatedUser(@RequestBody LoginVm loginVm) {
		User loggedUser = userService.isAuthenticated(loginVm);
		LoginResponse loginResponse = new LoginResponse();
		if (loggedUser != null) {
			loginResponse.setMessage("user is authenticated");
			loginResponse.setSuccess(true);
			loginResponse.setType(loggedUser.getType());
		} else {
			loginResponse.setMessage("username or password is invalid");
			loginResponse.setSuccess(false);
			loginResponse.setType(Constants.NOT_AVAILABLE);
		}
		return loginResponse;
	}

}
