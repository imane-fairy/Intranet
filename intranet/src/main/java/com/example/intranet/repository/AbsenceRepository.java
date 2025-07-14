package com.example.intranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intranet.model.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
