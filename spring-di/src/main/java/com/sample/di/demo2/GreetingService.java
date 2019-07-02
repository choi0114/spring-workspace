package com.sample.di.demo2;

public class GreetingService {
	// 1. 내가 필요로 하는 걸 변수로 먼저 정의
	private KoreanGreeting ko;
	private EnglishGreeting eng;
	// 2. 그걸 전달 받을 수 있는 세터 정의
	public void setKo(KoreanGreeting ko) {
		this.ko = ko;
	}
	
	public void setEng(EnglishGreeting eng) {
		this.eng = eng;
	}
	
	public String hello(String name) {
		String message = ko.message(name);
		
		return message;
	}
	
	public String bye() {
		String message = eng.goodbye();
		
		return message;
	}
}
