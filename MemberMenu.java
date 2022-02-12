package com.mvc.view;

import java.util.Scanner;

import com.mvc.controller.MemberController;
import com.mvc.model.Member;

public class MemberMenu {
	
	private MemberController mc = new MemberController();
	private Scanner sc = new Scanner(System.in);
	
	//1. 메인 메뉴
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("====== 회원 관리 메뉴 ======");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			
			switch(menu) {
			case 1: insertMember(); break; // 신규 회원 등록
			case 2: searchMember(); break; // 회원 정보 검색
			case 3: updateMember(); break; // 회원 정보 수정
			case 4: deleteMember(); break; // 회원 정보 삭제
			case 5: printAllMember(); break; // 회원 정보 전체 출력
			case 6: sortMember(); break;
			case 9: return; // 프로그램을 종료해야되기 때문에 이 mainMenu 메소드 자체를 빠져나가야됨
			default: System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
	}

//1. 신규 회원 등록
	private void insertMember() {

		// MemberController의 getMemberCount() 메소드를 통해 현재 회원 수 알아오고
		//1. 회원수
		int memberCount = mc.getMemberCount();
		// 현재 회원 수(memberCount)가 최대 회원 수(SIZE)를 넘어설 경우 return 처리
		//2. 자리 있어?
		if(memberCount >= mc.SIZE) {
			System.out.println("자리가 없습니다.");
			return; //자리 없으니까 끝!!!...return!!끝!!
		}else {//회원 등록
			System.out.println("아이디 : ");
			String userId = sc.nextLine();
			
			//중복 아이디 있나~
			//아이디를 입력 받아 MemberController의 checkId() 메소드로 전달 >> 결과 값 받기
			
			if(mc.checkId(userId) != null) {
				System.out.println("동일한 아이디가 존재합니다.");
			}else {
				System.out.print("비밀번호 : ");
				String userPwd = sc.nextLine();
				
				System.out.print("이름 : ");
				String name = sc.nextLine();
				
				System.out.print("나이 : ");
				int age = sc.nextInt();
				sc.nextLine();
				
				System.out.print("성별 : ");
				char gender = sc.nextLine().charAt(0);
				
				System.out.print("이메일 : ");
				String email = sc.nextLine();
				
				// 입력 받은 정보를 Member의 매개변수 생성자를 이용하여 객체 생성 후
				Member newMem = new Member(userId, userPwd, name, age, gender, email);

				// MemberController의 insertMember() 메소드로 전달
				mc.insertMember(newMem);
				System.out.println("성공적으로 회원등록이 되었습니다.");
			
			}
		}	
	}//회원 등록 끝

	
//2. 회원 정보 검색
	private void searchMember() {
		// 정보 검색 
		while(true) { //무한루프
			System.out.println("====== 회원 정보 검색 ======");
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 이전 메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			// 9번은 이전메뉴로 이 while문만 빠져나감 -> mainMenu()로 감
			if(menu == 9) {
				System.out.println("이전메뉴로 돌아갑니다.");
				return;
			}
			
			System.out.print("검색 내용 : ");
			String search = sc.nextLine();
			
			// 회원 정보 있는지 돌려보기 (Controller에 요청함)
			Member searchMember = mc.searchMember(menu, search);
			
			if(searchMember == null) {
				System.out.println("검색된 결과가 없습니다.");
			}else { //검색된 회원 객체가 searchMember에 담겨있음
				System.out.println("====== 검색결과 ======");
				System.out.println(searchMember.information());
			}
		}
	}//정보 검색 끝!!
	

//3. 회원 정보 수정
	private void updateMember() {
		
		while(true) {//무한루프
			
			System.out.println("====== 회원 정보 수정 ===== ");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 이메일 수정");
			System.out.println("9. 이전 메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 9) {
				System.out.println("이전메뉴로 돌아갑니다.");
				return;
			}
			
			// 변경할 회원 아이디 입력받고 mc로 넘기기
			System.out.print("변경할 회원 아이디 : ");
			String userId = sc.nextLine();

			//mc에서 확인하고 Member m에 값 담기
			Member m = mc.checkId(userId); 

			if(m == null) { //해당 회원이 없다아~
				System.out.println("변경할 회원에 대한 정보가 존재하지 않습니다.");
				
			}else { //일치하는 회원 있음
				
				System.out.println("기존 정보 : " + m.information()); // 우선 현재 회원의 기존 정보 출력
				
				System.out.print("변경 내용 : ");
				String update = sc.nextLine(); // 수정할 값 입력받기
				
				//해당 회원 정보 수정 요청 (Controller에 요청)
				mc.updateMember(m, menu, update);
												 
				
				System.out.println("회원의 정보가 변경되었습니다.");
			}
		}		
	}//정보 수정 끝!!!
	
	
//4. 회원 정보 삭제	
	public void deleteMember() {
		
		// 1.삭제할 회원의 아이디 입력받고 해당 객체 불러오기
		System.out.print("삭제할 회원 아이디 : ");
		String userId = sc.nextLine();

		Member m = mc.checkId(userId);
		
		if(m == null) {//회원이 없다!!!
			System.out.println("삭제할 회원에 대한 정보가 존재하지 않습니다.");
			
		}else {
			System.out.println("기존 정보 : " + m.information());
			
			System.out.print("정말 삭제하겠습니까? (y/n) : ");
			char ch = sc.nextLine().toUpperCase().charAt(0);
			
			if(ch == 'Y') {//삭제 고
				//controller의 deleteMember메소드 가서 일처리 하고 오기
				//1. 삭제할 아이디 찾고 삭제
				//2. 삭제된 배열부터 다시 채우기
				mc.deleteMember(userId); 
				
				System.out.println("회원의 정보가 삭제되었습니다.");
			}else {
				return; //이전 메뉴(mainMenu)로 돌아가기
			}
		}
	}//정보 삭제 끝!!!!!!


//5. 회원 정보 출력
	private void printAllMember() {
		
		//Member 배열에 담겨있는 mem변수 controller의 getMem메소드를 통해 호출
		Member[] mem = mc.getMem();
		
		//controller getMemberCount에 저장되어있는 회원 수만큼 반복
		for(int i = 0; i < mc.getMemberCount(); i++) {
			// 빈값이 아니라면 = 회원들이 있다면
			if(mem[i] != null) {
				//배열에 담긴 회원들 출력
				System.out.println(mem[i].information());
			}else {
				System.out.println("회원이 없습니다.");
			}
		}	
	}//정보 출력 끝
	
	
// 6. 회원 정보 정렬
	private void sortMember() {
		
		//정보 담아줄 변수 초기화
		//mc에 넘겨서 번호에 맞게 정렬해 받아올 예정
		Member[] sortMem = null;
		
		while(true) {
			System.out.println("==회원 정보 정렬==");
			System.out.println("1. 아이디 오름차순 정렬");
			System.out.println("2. 아이디 내림차순 정렬");
			System.out.println("3. 나이 오름차순 정렬");
			System.out.println("4. 나이 내림차순 정렬");
			System.out.println("5. 성별 내림차순 정렬(남여순)");
			System.out.println("9. 이전 메뉴로");
			System.out.println("메뉴 선택 : ");
			int menu = sc.nextInt();

			switch(menu) {
			case 1: 
				sortMem = mc.sortIdAsc();
				break;
			case 2: 
				sortMem = mc.sortIdDesc();
				break;
			case 3: 
				sortMem = mc.sortAgeAsc();
				break;
			case 4: 
				sortMem = mc.sortAgeDesc();
				break;
			case 5: 
				sortMem = mc.sortGenderDesc();
				break;
			case 9: 
				return;
			default : 
				System.out.println("메뉴 번호를 다시 선택해주세요.");
				break; 
			}
			
			for(int i = 0; i < sortMem.length; i++) {
				
				//리턴 값이 있다면 = 회원들이 있다면
				if(sortMem[i] != null) {
					System.out.println(sortMem[i].information());
				}
			}
		}
	}
	
			
	
}
