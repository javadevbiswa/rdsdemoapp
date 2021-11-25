package com.biswa.app.dto;

import java.util.List;

import com.biswa.app.entity.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

	private int id;
	private String name;
	private String address;
	private List<Doctor> doctors;
}
