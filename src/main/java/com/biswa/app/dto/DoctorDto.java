package com.biswa.app.dto;

import java.util.Set;

import com.biswa.app.entity.Department;
import com.biswa.app.entity.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

	private int id;
	private String name;
	private String designation;
	private Department department;
	private Set<Patient> patients;
}
