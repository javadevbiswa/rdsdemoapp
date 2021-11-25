package com.biswa.app.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "or_doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String designation;
	@ManyToOne
	@JoinColumn(name = "department_fk", nullable = false)
	private Department department;
	@OneToMany(mappedBy = "doctor")
	private Set<Patient> patients;

	public Doctor(String name, String designation, Department department, Set<Patient> patients) {
		super();
		this.name = name;
		this.designation = designation;
		this.department = department;
		this.patients = patients;
	}

}
