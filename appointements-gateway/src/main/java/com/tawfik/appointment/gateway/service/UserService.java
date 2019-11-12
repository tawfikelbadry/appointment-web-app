package com.tawfik.appointment.gateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.appointment.gateway.model.entity.User;
import com.tawfik.appointment.gateway.model.vm.DoctorRegisterVm;
import com.tawfik.appointment.gateway.model.vm.LoginVm;
import com.tawfik.appointment.gateway.model.vm.PatientRegisterVm;
import com.tawfik.appointment.gateway.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listAll() {
		return (List<User>) this.userRepository.findAll();
	}

	public User saveDoctor(DoctorRegisterVm doctorRegisterVm) {
		User existedUser = userRepository.findByUsername(doctorRegisterVm.getUsername()).orElse(null);

		if (existedUser == null) {
			User user = new User(doctorRegisterVm);
			this.userRepository.save(user);
			return user;
		}
		return null;
	}

	public User savePatient(PatientRegisterVm patientRegisterVm) {
		User existedUser = userRepository.findByUsername(patientRegisterVm.getUsername()).orElse(null);

		if (existedUser == null) {
			User user = new User(patientRegisterVm);
			this.userRepository.save(user);
			return user;
		}
		return null;
	}

	public User isAuthenticated(LoginVm loginVm) {
		return userRepository.findByUsernameAndPassword(loginVm.getUsername(),loginVm.getPassword()).orElse(null);
	}

}
