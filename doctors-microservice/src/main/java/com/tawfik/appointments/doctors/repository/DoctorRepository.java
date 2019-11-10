package com.tawfik.appointments.doctors.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tawfik.appointments.doctors.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{

}
