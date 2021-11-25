package com.biswa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.app.dto.PatientDto;
import com.biswa.app.service.PatientService;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<PatientDto>> getAllPatients() {

		return new ResponseEntity<List<PatientDto>>(patientService.findAllPatients(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PatientDto> getPatientById(@PathVariable(value = "id") Integer id) {

		return new ResponseEntity<PatientDto>(patientService.findPatientById(id), HttpStatus.OK);
	}
}
