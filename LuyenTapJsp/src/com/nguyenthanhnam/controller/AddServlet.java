package com.nguyenthanhnam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nguyenthanhnam.model.EmployeeM;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String tenNhanVien = request.getParameter("tennhanvien");
		float luong = Float.parseFloat(request.getParameter("luong"));
		String chucVu = request.getParameter("chucvu");
		EmployeeM dao = new EmployeeM();
		dao.insert(tenNhanVien, luong, chucVu);
		response.sendRedirect("SelectServlet");
	}

}
