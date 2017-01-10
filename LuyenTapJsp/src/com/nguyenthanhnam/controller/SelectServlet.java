package com.nguyenthanhnam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nguyenthanhnam.model.Employee;
import com.nguyenthanhnam.model.EmployeeDao;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Employee> list;
		EmployeeDao dao = new EmployeeDao();
		int page = 1;
		int recordsPerPage = 3;
        String keySearch =request.getParameter("search");
        System.out.println(keySearch);
        if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(keySearch!=null){
			list = dao
					.searchEmployee(Integer.parseInt(keySearch),(page - 1) * recordsPerPage, recordsPerPage);
		}else{
			list = dao
					.viewAllEmployees((page - 1) * recordsPerPage, recordsPerPage);
		}
		
		int noOfRecords = dao.getNoOfRecords();
		int noOfPages = noOfRecords / recordsPerPage;
		if(noOfRecords%recordsPerPage!=0){
			noOfPages+=1;
		}
		request.setAttribute("employeeList", list);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/index.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
