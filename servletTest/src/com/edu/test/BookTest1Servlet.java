package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bookReg")
public class BookTest1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookTest1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		
		Book book = new Book(title, author, publisher);
		
		request.setAttribute("book", book);
		
		RequestDispatcher rd = request.getRequestDispatcher("bookOutput"); 
		// 현재 웹 애플리케이션 내에서만 가능
		// 상대, 절대 경로 모두 가능
		rd.forward(request, response);
		
		out.close();
	}

}
