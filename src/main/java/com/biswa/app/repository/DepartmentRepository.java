package com.biswa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biswa.app.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
