package com.tawfik.appointments.doctors.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tawfik.appointments.doctors.model.entity.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

	List<Appointment> findByAvailable(boolean available);

	Optional<Appointment> findByIdAndAvailable(long appointementId, boolean available);

}
