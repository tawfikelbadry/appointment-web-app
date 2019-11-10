package com.tawfik.appointments.doctors.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tawfik.appointments.doctors.entity.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long>{
	
	List<Appointment> findByAvailable(boolean available);

}
