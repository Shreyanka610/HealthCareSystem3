package com.capgemin.healthcare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemin.healthcare.dao.DiagnosticCenterDao;
import com.capgemin.healthcare.dao.TestDao;
import com.capgemin.healthcare.dao.UsersDao;
import com.capgemin.healthcare.entity.DiagnosticCenter;
import com.capgemin.healthcare.entity.Test;
import com.capgemin.healthcare.entity.Users;


@SpringBootApplication
public class HealthCareSystem3Application implements CommandLineRunner
{
@Autowired
private UsersDao userDao;
@Autowired
private TestDao testDao;
@Autowired
private DiagnosticCenterDao DiagnosticCenterDao; 

	public static void main(String[] args)
	{
		SpringApplication.run(HealthCareSystem3Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Users user1 =new Users("1234","shreyanka","123456","user","emailid@com");
		Users user2 =new Users("8523","agarwal","123456","user","emailid@com");
		userDao.save(user1);
		userDao.save(user2);
		
		Test test1=new Test("JHANSI");
		Test test2=new Test("Sugar Test");
		testDao.save(test1);
		testDao.save(test2);
		
		DiagnosticCenter center1=new DiagnosticCenter("Agra");
		DiagnosticCenter center2=new DiagnosticCenter("Jhansi");
		DiagnosticCenterDao.save(center1);
		DiagnosticCenterDao.save(center2);
		

}
}
