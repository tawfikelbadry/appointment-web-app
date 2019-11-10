package com.tawfik.appointments.patients.repository;

import org.springframework.data.repository.CrudRepository;

import com.tawfik.appointments.patients.entity.PatientAppointment;

public interface PatientAppointementRepository extends CrudRepository<PatientAppointment, Long>{

}
