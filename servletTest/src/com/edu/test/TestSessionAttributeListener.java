package com.edu.test;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestSessionAttributeListener implements HttpSessionAttributeListener {

	public TestSessionAttributeListener() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("세션 객체에 속성 추가");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("세션 객체에 추가된 속성 삭제");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("세션 객체에 추가된 속성 대체");
	}

}
