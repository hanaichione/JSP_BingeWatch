package com.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetScopeServlet")
public class SetScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SetScopeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request scope에 저장
		request.setAttribute("request", "리퀘스트");
		
		// session scope에 저장
		HttpSession session = request.getSession();
		session.setAttribute("session", "세션");
		
		// application scope에 저장
		ServletContext ctx = getServletContext();
		ctx.setAttribute("application", "애플리케이션");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
