package com.biswa.app.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswa.app.dto.PatientDto;
import com.biswa.app.entity.Department;
import com.biswa.app.entity.Doctor;
import com.biswa.app.entity.Patient;
import com.biswa.app.repository.DepartmentRepository;
import com.biswa.app.repository.DoctorRepository;
import com.biswa.app.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private ModelMapper modelMapper;

	@PostConstruct
	public void init() {

		List<Department> departments = Arrays.asList(new Department("common cold", "C-Block,appolo", null),
				new Department("Fever", "D-Block,appolo", null), new Department("Diareha", "B-Block,appolo", null));

		List<Department> savedDepartments = departmentRepository.saveAll(departments);

		List<Doctor> doctors = Arrays.asList(
				new Doctor("Dr. Sidharth", "Cold Specialist", savedDepartments.get(0), null),
				new Doctor("Dr. Ram", "ENT Specialist", savedDepartments.get(0), null),
				new Doctor("Dr. Rani", "Covid19 fever ", savedDepartments.get(1), null),
				new Doctor("Dr. Leesa", "gynology", savedDepartments.get(2), null),
				new Doctor("Dr. Albert", "Fever", savedDepartments.get(1), null),
				new Doctor("Dr. Bob", "Cold Specialist", savedDepartments.get(0), null),
				new Doctor("Dr. Joe", "Diarhea Specialist", savedDepartments.get(2), null));

		List<Doctor> savedDoctors = doctorRepository.saveAll(doctors);

		List<Patient> patients = Arrays.asList(
				new Patient("Mr Rajneekanth B", new Date(), "c", "189", savedDoctors.get(0)),
				new Patient("Mr Radheshyam ", new Date(), "b", "221", savedDoctors.get(1)),
				new Patient("Mr Raja", new Date(), "d", "220", savedDoctors.get(2)),
				new Patient("Mrs pujarani", new Date(), "c", "78", savedDoctors.get(4)),
				new Patient("Mr Bapi", new Date(), "a", "133", savedDoctors.get(6)),
				new Patient("Mr Gajendra", new Date(), "d", "101", savedDoctors.get(3)),
				new Patient("Mr Manoj", new Date(), "g", "56", savedDoctors.get(5)),
				new Patient("Mrs Kabita", new Date(), "h", "73", savedDoctors.get(6)),
				new Patient("Mr Fakir Mohan", new Date(), "k", "99", savedDoctors.get(3)),
				new Patient("Mrs Irambali", new Date(), "c", "3", savedDoctors.get(2)),
				new Patient("Mr Sunil Kumar", new Date(), "c", "119", savedDoctors.get(1)));
	}

	public List<PatientDto> findAllPatients() {
		return patientRepository.findAll().stream().map(e -> convertToDto(e)).collect(Collectors.toList());
	}

	public PatientDto findPatientById(int id) {
		return convertToDto(patientRepository.findById(id).get());
	}

	private PatientDto convertToDto(Patient e) {
		return modelMapper.map(e, PatientDto.class);
	}

}
