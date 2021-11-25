package com.biswa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biswa.app.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
