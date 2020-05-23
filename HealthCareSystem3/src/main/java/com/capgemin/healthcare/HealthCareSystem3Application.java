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
		Users user1 =new Users("1234","shreyanka","9886622852","user","shreyanka@gmail.com");
		Users user2 =new Users("8523","Agarwal","9900118464","user","agarwal@gmail.com");
		userDao.save(user1);
		userDao.save(user2);
		
		Test test1=new Test("Kidney function test");
		Test test2=new Test("Liver function test");
		Test test3=new Test("Thyroid function test");
		Test test4=new Test("Pulmonary function test");
		Test test5=new Test("Ultrasonography");
		
		testDao.save(test1);
		testDao.save(test2);
		testDao.save(test3);
		testDao.save(test4);
		testDao.save(test5);
		
		DiagnosticCenter center1=new DiagnosticCenter("Apallo Diagnostic Center");
		DiagnosticCenter center2=new DiagnosticCenter("DR LAL PATHLABS");
		DiagnosticCenter center3=new DiagnosticCenter("THYROCARE Diagnostic Center");
		DiagnosticCenter center4=new DiagnosticCenter("MedPlus Diagnostic Center");
		DiagnosticCenter center5=new DiagnosticCenter("SAGAR Diagnostic Center");
		DiagnosticCenterDao.save(center1);
		DiagnosticCenterDao.save(center2);
		DiagnosticCenterDao.save(center3);
		DiagnosticCenterDao.save(center4);
		DiagnosticCenterDao.save(center5);
		

}
}
