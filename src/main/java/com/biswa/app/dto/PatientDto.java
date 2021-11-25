package com.biswa.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

	private int id;
	private String name;
	private Date enrollDate;
	private String wordNo;
	private String bedNo;
	private String doctorName;
	private DoctorDto doctor;
}
