package com.edu.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SendRedirectTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("site");
		if (param.equals("naver")) {
			response.sendRedirect("http://www.naver.com");
		} else if (param.equals("daum")) {
			response.sendRedirect("http://www.daum.com");
		} else if (param.equals("zum")) {
			response.sendRedirect("http://www.zum.com");
		} else if (param.equals("google")) {
			response.sendRedirect("http://www.google.com");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
