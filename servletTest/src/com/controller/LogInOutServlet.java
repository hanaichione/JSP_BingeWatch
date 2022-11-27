package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpsConfigurator;

/**
 * Servlet implementation class LogInOutServlet
 */
@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 작업을 완료했습니다.");
		} else {
			out.print("현재 로그인 상태가 아닙니다.");
		}
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		if (id.isEmpty() || pw.isEmpty()) {
			out.print("ID 또는 비밀번호를 입력해주세요.");
			return;
		}
		
		HttpSession session = request.getSession();
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("로그인을 완료했습니다.");
		} else {
			out.print("현재 로그인 상태입니다.");
		}
	}

}
