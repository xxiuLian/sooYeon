package com.mvc.view;

import java.util.Scanner;

import com.mvc.controller.MemberController;

public class MemberView {
	//mvc 패턴 중 view 패키지 : 사용자가 보게될 화면을 담당하는 부분
	//따라서 사용자가 보게되는 출력문 (print구문)은 반드시 view 패키지 안에만 작성!! 그 외는 놉!
	//뿐만아니라 사용자가 키보드로 입력하는 부분(scanner사용)도 view 패키지 안에만 작성!! 그 외는 놉!
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberView() {
		// TODO Auto-generated constructor stub
	}
	
	public void mainMenu() {
		
		System.out.println("아이디 입력하시오 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력하시오 : ");
		String pwd = sc.nextLine();
		
		int result = mc.login(id, pwd);
		
		if(result == 1) {//1이면 로그인 성공
			
			while(true) {
				System.out.println("===회원 프로그램===");
				System.out.println("1. 내 정보 보기");
				System.out.println("2. 내 나이 조회하기");
				System.out.println("3. 키 수정하기");
				System.out.println("9. 프로그램 종료하기");
			
				int num = sc.nextInt();
				sc.nextLine();
				
				switch(num) {
				
				case 1:
					System.out.println(mc.readInfo().information());
					break;
				case 2:
					System.out.println(mc.readAge());
					break;
				case 3:
					updateHeight();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("메뉴를 다시 선택해주세요");
					break;
				}
			}//while

			
		}else {
			System.out.println("로그인 실패");
		}
		
		
	}

	private void updateHeight() {
		System.out.println("수정할 키를 입력해주세요 : ");
		double uHeight = sc.nextDouble();
		
		mc.updateHeight(uHeight);
		
	}
	
}
