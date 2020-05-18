package com.capgemin.healthcare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemin.healthcare.entity.Users;

public interface UsersDao extends JpaRepository<Users,Integer> {

}
