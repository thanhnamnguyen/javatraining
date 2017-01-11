package com.nguyenthanhnam.entity;

public class Employee {
	private int employeeId;
	private String employeeName;
	private float salary;
	private String deptName;

	public Employee() {
	}

	public Employee(int employeeId, String employeeName, float salary,
			String deptName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.deptName = deptName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
