package com.sample.di.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo4App {

	public static void main(String[] args) {
		String resource = "classpath:/com/sample/di/demo4/demo4.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		EventNoticeService event = ctx.getBean("eventnotice", EventNoticeService.class);
		OrderService order = ctx.getBean("order", OrderService.class);
		
		event.notice("홈페이지가 오픈했습니다.");
		order.sendOrderStatus();
	}
}
