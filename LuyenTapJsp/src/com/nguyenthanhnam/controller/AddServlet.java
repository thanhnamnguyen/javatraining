package com.nguyenthanhnam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nguyenthanhnam.model.EmployeeDao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //String maNhanVien=request.getParameter("manhanvien");
       String tenNhanVien=request.getParameter("tennhanvien");
       float luong=Float.parseFloat(request.getParameter("luong"));
       String chucVu=request.getParameter("chucvu");
       EmployeeDao dao=new EmployeeDao();
       dao.insert(tenNhanVien, luong, chucVu);
//       RequestDispatcher view=request.getRequestDispatcher("WEB-INF/index.jsp");
//       view.forward(request, response);
       response.sendRedirect("SelectServlet");
	}

}
