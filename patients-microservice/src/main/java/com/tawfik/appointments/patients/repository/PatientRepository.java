package com.tawfik.appointments.patients.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tawfik.appointments.patients.model.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
