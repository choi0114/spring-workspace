package com.sample.di.demo5;

public class PointDummyDao implements PointDao {

	public void updatePoint(String id, int point) {
		// TODO Auto-generated method stub
		System.out.println("[" + id + "]님의 포인트가 " + point + "점으로 변경되었습니다.");
	}
}
