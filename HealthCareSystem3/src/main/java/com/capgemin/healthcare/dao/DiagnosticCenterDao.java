package com.capgemin.healthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemin.healthcare.entity.DiagnosticCenter;

public interface DiagnosticCenterDao extends JpaRepository<DiagnosticCenter,Integer> {

}
