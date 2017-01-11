package com.nguyenthanhnam.pargination;

import java.util.ArrayList;
import java.util.List;

import com.nguyenthanhnam.entity.Employee;
import com.nguyenthanhnam.model.EmployeeM;

public class Pargination {
	private EmployeeM employeeModel = new EmployeeM();

	// tinh so page
	public int noOfPage(int recordPrepage) {
		int record = employeeModel.getNoOfRecords();
		int page = record / recordPrepage;
		if (record % recordPrepage != 0) {
			page += 1;
		}
		return page;
	}

	// page hien tai
	public int currentPage(int page) {
		return page;
	}

	// danh sach cac ban ghi hien thi theo search hoac tât ca cac ban ghi
	public List<Employee> listRecord(String key, int page, int recordPerpage) {
		List<Employee> listRecord = new ArrayList<Employee>();
		int startPage = (currentPage(page) - 1) * recordPerpage;
		int endPage = recordPerpage;
		if (key != null) {
			listRecord = employeeModel.searchEmployee(Integer.parseInt(key),
					startPage, endPage);
		} else {
			listRecord = employeeModel.viewAllEmployees(startPage, endPage);
		}
		return listRecord;
	}
}
