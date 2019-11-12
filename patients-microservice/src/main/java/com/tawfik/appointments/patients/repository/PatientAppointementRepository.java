package com.tawfik.appointments.patients.repository;

import org.springframework.data.repository.CrudRepository;

import com.tawfik.appointments.patients.model.entity.PatientAppointment;

public interface PatientAppointementRepository extends CrudRepository<PatientAppointment, Long>{

}
