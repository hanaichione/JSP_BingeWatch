package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookOutput")
public class BookTest2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookTest2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Book book = (Book) request.getAttribute("book");
		
		out.print("<h3>책제목 : "+book.getTitle()+"</h3>");
		out.print("<h3>책저자 : "+book.getAuthor()+"</h3>");
		out.print("<h3>출판사 : "+book.getPublisher()+"</h3>");
		
		out.close();
	}

}
