package com.biswa.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "or_patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column(name = "enroll_dt")
	private Date enrollDate;
	@Column(name = "word_no")
	private String wordNo;
	@Column(name = "bed_no")
	private String bedNo;
	@ManyToOne
	@JoinColumn(name = "doctor_fk", nullable = false)
	private Doctor doctor;

	public Patient(String name, Date enrollDate, String wordNo, String bedNo, Doctor doctor) {
		super();
		this.name = name;
		this.enrollDate = enrollDate;
		this.wordNo = wordNo;
		this.bedNo = bedNo;
		this.doctor = doctor;
	}

}
