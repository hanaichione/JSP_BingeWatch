package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String param = request.getParameter("p");
		String mesg = null;
		HttpSession session = null;
		
		if (param.equals("create")) {
			session = request.getSession();
			if (session.isNew()) { // 서버 측에서 새로운 HttpSession 객체를 생성한 경우 true, 기존 세션 유지 false
				mesg = "새로운 세션 객체 생성";
			} else {
				mesg = "기존 세션 객체 리턴";
			}
		} else if (param.equals("delete")) {
			session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				mesg = "세션 객체 삭제 작업 완료";
			} else {
				mesg = "삭제할 세션 없음";
			}
		} else if (param.equals("add")) {
			session = request.getSession(true);
			session.setAttribute("mesg", "메시지입니다");
			mesg = "세션 객체에 데이터 등록 완료";
		} else if (param.equals("get")) {
			session = request.getSession(false);
			if (session != null) {
				String str = (String) session.getAttribute("mesg");
				mesg = str;
			} else {
				mesg = "데이터를 추출할 세션 객체 없음";
			}
		} else if (param.equals("remove")) {
			session = request.getSession(false);
			if (session != null) {
				session.removeAttribute("mesg");
				mesg = "세션 객체의 데이터 삭제 완료";
			} else {
				mesg = "데이터를 추출할 세션 객체 없음";
			}
		} else if (param.equals("replace")) {
			session = request.getSession();
			session.setAttribute("mesg", "새로운 메시지입니다");
			mesg = "세션 객체에 데이터 등록 완료";
		}
		out.print("처리 결과 : " + mesg);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
