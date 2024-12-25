package com.sathya.springboot.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString

public class Employee {
	int empid;
	String empname;
	double empsalary;
	public static void main(String[]args) {
		Employee employee=Employee.builder()
				.empid(111)
				.empname("masala")
				.empsalary(1666.8)
				.build();
		System.out.println(employee);
	}

}
