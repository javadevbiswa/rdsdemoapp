package com.biswa.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "or_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	@OneToMany(mappedBy = "department")
	private List<Doctor> doctors;

	public Department(String name, String address, List<Doctor> doctors) {
		super();
		this.name = name;
		this.address = address;
		this.doctors = doctors;
	}

}
