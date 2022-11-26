package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/product")
public class ProductRegistrationServlet extends HttpServlet {
	HashMap<String, Product> products = new HashMap<String, Product>();
	
	private static final long serialVersionUID = 1L;
       

    public ProductRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		String name = request.getParameter("productName");
		String id = request.getParameter("productId");
		int amount = Integer.parseInt(request.getParameter("productAmount"));
		
		Product temp = products.get(id);
		
		if(temp == null) {
			temp = new Product(name, id, amount);
			products.put(id, temp);
		} else {
			temp.setProductAmount(temp.getProductAmount()+amount);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>상품입력결과</title></head><body>");
		out.print("<b>상품입력결과</b>");
		out.println("<table border='1'>");
		out.println("<tr><th>상품명</th><th>상품아이디</th><th>수량</th></tr>");
		for (Product p : products.values()) {
			out.println("<tr>");
			out.println("<td>" + p.getProductName() + "</td><td>" + p.getProductId() + "</td><td>" + p.getProductAmount() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.print("<a href='productForm.html'>상품입력하기</a>");
		out.print("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
