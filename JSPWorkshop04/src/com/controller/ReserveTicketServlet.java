package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReserveTicketServlet
 */
@WebServlet("/Reserve")
public class ReserveTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReserveTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String birth = request.getParameter("birth");
		int ticketBefore = Integer.parseInt(request.getParameter("ticket"));
		int ticket = 0;
		int age = 2022 - Integer.parseInt(birth.substring(0, 4)) + 1;
		String grade = "";
		
		// 나이에 따른 등급, 할인 가격 계산
		if (age < 19) {
			grade = "미성년자";
			ticket = (int) (ticketBefore * 0.6);
		} else if (age >= 19 && age < 60) {
			grade = "성인";
			ticket = (int) (ticketBefore * 0.9);
		} else {
			grade = "경로우대";
			ticket = (int) (ticketBefore * 0.5);
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("입력한 생년월일 : " + birth + ", 선택한 티켓 : " + ticketBefore + "<br>");
		out.print("나이 : " + age + "세, 등급 : " + grade + ", 할인 적용 금액 : " + ticket + "원");
		out.print("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
