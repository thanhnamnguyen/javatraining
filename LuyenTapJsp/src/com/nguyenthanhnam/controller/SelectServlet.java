package com.nguyenthanhnam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nguyenthanhnam.pargination.Pargination;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Pargination pargin = new Pargination();
		int page = 1;
		int recordsPerPage = 3;
		String keySearch = request.getParameter("search");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("employeeList",pargin.listRecord(keySearch, page, recordsPerPage));
		request.setAttribute("noOfPages", pargin.noOfPage(recordsPerPage));
		request.setAttribute("currentPage", pargin.currentPage(page));
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/index.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	}

}
