package Springbootmvc_employee.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	private int empid;
	private String empname;
	private double empsalary;
	private String empdept;
	private int empexp;
	

}
