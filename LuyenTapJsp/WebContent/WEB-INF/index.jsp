<%@page import="com.nguyenthanhnam.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/controller.js"></script>
</head>
<body>
<body>
	<h3>Quan Ly Nhan Vien</h3>
	<div class="process">
		<form action="AddServlet" method="post" id="frominfo">
			<div class="row">
				<div class="col-name">Mã Nhân Viên:</div>
				<div class="col-content">
					<input type="text" id="manhanvien" class="info" name="manhanvien"  readonly="readonly"/>
				</div>
			</div>
			<div class="row">
				<div class="col-name">Tên Nhân Viên:</div>
				<div class="col-content">
					<input type="text" id="tennhanvien" class="info" name="tennhanvien" />
				</div>
			</div>
			<div class="row">
				<div class="col-name">Lương:</div>
				<div class="col-content">
					<input type="text" id="luong" class="info" name="luong" />
				</div>
			</div>
			<div class="row">
				<div class="col-name">Chức Vụ</div>
				<div class="col-content">
					<input type="text" id="chucvu" class="info" name="chucvu" />
				</div>
			</div>

			<div class="bt">
				<input type="submit" id="them" class="mybt" value="Thêm Mới" /> <input
					type="submit" id="cancel" class="mybt" value="Bỏ Qua" />
			</div>
		</form>
	</div>
	<div class="display">
		<table id="tb">
			<tr>
				<td>Mã Nhân Viên</td>
				<td>Tên Nhân Viên</td>
				<td>Lương</td>
				<td>Chức Vụ</td>
				<td>Hành Động</td>
			<tr>
				<c:forEach var="employee" items="${employeeList}">
					<tr>

						<td class="item1">${employee.employeeId}</td>
						<td class="item2">${employee.employeeName}</td>
						<td class="item3">${employee.salary}</td>
						<td class="item4">${employee.deptName}</td>
						<td><a href="#" class="edit" onclick="editItem(this);">Edit</a>
							| <a href="delete?info=${employee.employeeId}">Delete</a></td>
					</tr>
				</c:forEach>
		</table>
		<div class="row-par">
			<div class="col-par">
				<c:if test="${currentPage!=1 && currentPage>0}">
					<a href="employee?page=${currentPage-1}">Previous</a>
				</c:if>
			</div>
			<div class="col-par">
				<c:forEach begin="1" end="${noOfPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
			                         ${i}
			                   </c:when>
						<c:otherwise>
							<a href="employee?page=${i}"> ${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<div class="col-par">
				<c:if test="${currentPage lt noOfPages }">
					<a href="employee?page=${currentPage+1}">Next</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</body>
</html>