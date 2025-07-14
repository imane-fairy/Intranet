package com.example.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intranet.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
