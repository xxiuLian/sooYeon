package com.mvc.controller;

import com.mvc.model.vo.Member;

public class MemberController {
	
	private Member mem = new Member("admin", "1234", "홍길동", "951022-1562334", 163.0);
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	

	public int login(String id, String pwd) {
		if(mem.getMemberId().equals(id) && mem.getMemberPwd().equals(pwd)) {
			return 1; //-->id, pw일치해야 로그인 성공 --> 1리턴
		}else
		return 0;//-->하나라도 만족하지 않으면 로그인 실패 --> 0리턴
	}


	public Member readInfo() {

		return mem;
	}


	public int readAge() {

		String yearStr = mem.getCitizenNo().substring(0, 2);
		int year = Integer.parseInt(yearStr); // "90"문자열 --> 90정수
		
		int age = 0; //나이 받을 변수 초기화
		
		//나이 구하는 방법
		//현재년도 - (1900 + year) + 1;
		//2022 - (1900 + year) + 1;
		
		if(year > 23) { //1900년대생
			age = 2022 - (1900 + year) + 1;
		}else {
			age = 2022 - (2000 + year) + 1;
		}
		
		return age;
	}


	public void updateHeight(double uHeight) {
		mem.setHeight(uHeight);
		
	}

	
	
}
