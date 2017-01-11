package com.nguyenthanhnam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nguyenthanhnam.connection.MyConnection;
import com.nguyenthanhnam.entity.Employee;

public class EmployeeM extends MyConnection {
	Connection con = null;
	private int noOfRecord;

	public List<Employee> viewAllEmployees(int startRecord, int limitRecord) {
		Statement stm = null;
		String sql = "select  * from employee limit " + startRecord + ", "
				+ limitRecord;
		List<Employee> listPeople = new ArrayList<Employee>();
		Employee employee = null;

		try {
			con = getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				Float salary = rs.getFloat("salary");
				String dept_name = rs.getString("dept_name");
				employee = new Employee(emp_id, emp_name, salary, dept_name);
				listPeople.add(employee);
			}
			rs.close();
			rs = stm.executeQuery("SELECT COUNT(*) FROM employee");
			if (rs.next()) {
				this.noOfRecord = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return listPeople;
	}

	public int getNoOfRecords() {
		return noOfRecord;
	}

	public void edit(String maNhanVien, String tenNhanVien, Float luong,String chucvu) {
		PreparedStatement pst = null;
		String sql = "Update employee Set emp_name=?,salary=?,dept_name=? where emp_id=?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, tenNhanVien);
			pst.setFloat(2, luong);
			pst.setString(3, chucvu);
			pst.setString(4, maNhanVien);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void delete(String maNhanVien) {
		String sql = "Delete from employee where emp_id=? ";
		PreparedStatement pst = null;
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, maNhanVien);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Employee> searchEmployee(int maNhanVien, int startRecord,int limitRecord) {
		List<Employee> listPeople = new ArrayList<Employee>();
		Employee employee = null;
		String sql = "select * from employee where emp_id='" + maNhanVien + "'";
		PreparedStatement pst = null;
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				Float salary = rs.getFloat("salary");
				String dept_name = rs.getString("dept_name");
				employee = new Employee(emp_id, emp_name, salary, dept_name);
				listPeople.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listPeople;
	}

	public void insert(String tenNhanVien, float luong, String chucVu) {
		String sql = "Insert into employee(emp_name,salary,dept_name) values (?,?,?)";
		PreparedStatement pst = null;
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, tenNhanVien);
			pst.setFloat(2, luong);
			pst.setString(3, chucVu);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
