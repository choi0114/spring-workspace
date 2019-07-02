package com.sample.di.demo5;

public class UserDummyDao implements UserDao {

	public void insertUser(String name, String id, String password) {
		// TODO Auto-generated method stub
		System.out.println("이름 : " + name + ", 아이디 : " + id + ", 패스워드 : " + password + "가 등록되었습니다.");
	}
}
