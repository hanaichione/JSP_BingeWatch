package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/info")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	// 1. 응답헤더 설정
		PrintWriter out = response.getWriter();	// 2. 응답할 html 코드 작업
		out.print("<html><body>");	// 3. 응답할 html 코드 작업
		
		/*String my = "<table border='1'>";
		   my += "<tr>";
		   my += "<td>이름</td>";
		   my += "<td>나이</td>";
		   my += "<td>주소</td>";
		   my += "<tr>";
		   my += "<tr>";
		   my += "<td>홍길동</td>";
		   my += "<td>20</td>";
		   my += "<td>서울</td>";
		   my += "<tr>";
		   my += "</table>";
		   out.print(my);*/
		
		out.print("<table border='1'>");
		out.print("<tr><td>이름</td><td>나이</td><td>주소</td></tr>");
		out.print("<tr><td>홍길동</td><td>20</td><td>서울</td></tr>");
		out.print("</table>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
