package com.capgemin.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Test_table")
public class Test {
	@Id
	@Column(name = "test_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(sequenceName = "test_seq", initialValue = 1, allocationSize = 1, name = "test_seq")
	private Integer testId;

	@Column(name = "testName")
	private String testName;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public Test(String testName) {
		super();
		
		this.testName = testName;
		
	}

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tests [testId=" + testId + ", testName=" + testName + "]";
	}
}
