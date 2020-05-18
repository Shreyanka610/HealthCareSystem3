package com.capgemin.healthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemin.healthcare.entity.Test;

public interface TestDao extends JpaRepository<Test, Integer>{

}
