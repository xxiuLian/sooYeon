package com.mvc.controller;

import com.mvc.model.Member;

public class MemberController {

	public static final int SIZE = 10;
	private int memberCount;
	private Member[] mem = new Member[SIZE];
	// 인스턴스 초기화 블럭을 이용하여 기본적인 회원 5명의 정보 초기화, memberCount 수 5 초기화
	{
		mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
		mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
		mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@hanmail.net");
		mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gmail.com");
		mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
		memberCount = 5;
	}
	
	public MemberController() {}
	
	public int getMemberCount() {

		return memberCount;
	}
	

	public Member[] getMem() {
		//가지고 있는 Member mem객체 다 내놔
		return mem;
	}

	public Member checkId(String userId) {
		//m을 null로 초기화
		Member m = null;
		//회원 들어있는 mem배열 돌려서 같은 아이디 있는지 확인
		for(int i = 0; i < memberCount; i++) {
			if(mem[i].getUserId().equals(userId)) {
				m = mem[i];
			}
		}
		//있으면 해당 정보 리턴, 없으면 null 리턴
		return m;
	}

	public void insertMember(Member newMem) {
		
		//새로운 회원 mem배열에 담기 회원수 세는 memberCount도 ++
		mem[memberCount++] = newMem;
		
	}

	public Member searchMember(int menu, String search) {
		// 검색된 회원 보관할 변수
		Member searchMem = null;
		
		//회원 mem돌려서 해당 회원 있는지 돌려~
		for(int i = 0; i < memberCount; i++) {
			
			//메뉴 1번은 아이디
			if(menu == 1) {
				if(mem[i].getUserId().equals(search)) {
					searchMem = mem[i]; //찾는아이디랑 일치하는mem아이디 있으면 searchMem에 저장해
				}//메뉴 2번은 이름
			}else if(menu == 2) {
				if(mem[i].getName().equals(search)) {
					searchMem = mem[i];
				}//메뉴 3번은 이메일
			}else if(menu == 3) {
				if(mem[i].getEmail().equals(search)) {
					searchMem = mem[i];
				}
			}
		}
		
		return searchMem; //있으면 해당searchMem 리턴, 없으면 null리턴
	}

	public void updateMember(Member m, int menu, String update) {
		//매개변수로 전달받은 m 회원과 변경 내용인 update 문자열을 menu에 따라
		//setter이용해서 변경변경
		if(menu == 1) {	//메뉴가 1이면 비밀번호 수정
			m.setUserPwd(update);
			
		}else if(menu == 2) { // 메뉴가 2이면 이름 수정
			
			m.setName(update);
			
		}else {
			
			m.setEmail(update);
		}
		
	}

	//XX
	public void deleteMember(String userId) {
		
		//1. 삭제한 배열에 다음 배열 인덱스가 순차적으로 담길 결과 초기화
		int index = 0;
		
		//2. 반복문 돌려서 삭제할 아이디 찾기
		for(int i = 0; i < memberCount; i++) {
			if(mem[i].getUserId().equals(userId)) {
				mem[i] = null; //일치하는 아이디 있으면 삭제혀(null)
				index = i; //인덱스 i에 저장
				break; //나와
			}
		}
		
		//3. 반복문 돌려서 삭제된 인덱스부터 다시 채우기
		//먼저 인덱스가 0인지 확인 왜?
		//== 0--> index값 안바뀜 1.과 같은상태
		//!= 0 --> index = i 에서 바뀐거임
		if(index != 0) {
			//    삭제된 인덱스부터;         회원수까지;  증감
			for(int j = index; j < memberCount; j++) {
				mem[j] = mem[j+1]; //삭제된 인덱스 자리부터 한칸씩 채워야 하니까 +1
			}
			memberCount--; //그리고 삭제됐으니까 회원수도 마이너스 1해
		}
		
	}

	public Member[] sortIdAsc() {
		// copy배열에 mem담아 아이디별 오름차순 정렬 진행 
		// 기존의 배열 복사해서 사용 (clone(), System.arraycopy() 둘 중 하나 사용해서 복사) 
		Member[] copy = mem.clone();
		
		for(int i = 0; i < memberCount; i++) {
			for (int j = 0; j < i; j++) {
				int result = copy[i].getUserId().compareTo(copy[j].getUserId());
				//compare to --> 비교대상 보다 작은경우 -1 큰 경우 +1 출력됨
				//result가 음수면 = -1이면 = 비교주체(i)가 비교대상(j)보다 작으면 바꾸기
				if(result < 0) {
					Member temp = copy[i];
					copy[i] = copy[j];
					copy[j] = temp;
				}
			}
		}
		return copy;
	}
	

	public Member[] sortIdDesc() {
		// copy 배열을 아이디 별 내림차순 정렬 진행 
		// 기존의 배열 복사해서 사용 (clone(), System.arraycopy() 둘 중 하나 사용해서 복사) 
		Member[] copy = mem.clone();
		
		for(int i = 0; i < memberCount; i++) {
			for (int j = 0; j < i; j++) {
				int result = copy[i].getUserId().compareTo(copy[j].getUserId());
				//compare to --> 비교대상 보다 작은경우 -1 큰 경우 +1 출력됨
				//result가 양수면 = 1이면 = 비교주체(i)가 비교대상(j)보다 크면 바꾸기
				if(result > 0) {
					Member temp = copy[i];
					copy[i] = copy[j];
					copy[j] = temp;
				}
			}
		}
		return copy;
	}

	
	public Member[] sortAgeAsc() {
		
		Member[] copy = mem.clone();
		
		for(int i = 0; i < memberCount; i++) {
			for(int j = 0; j < i; j++) {
				if( copy[i].getAge() < copy[j].getAge()) {
					Member temp = copy[i];
					copy[i] = copy[j];
					copy[j] = temp;
				}
			}
		}
		return copy;
	}
	
	
	//나이 내림차순
	public Member[] sortAgeDesc() {

		Member[] copy = mem.clone();
		
		for(int i = 0; i < memberCount; i++) {
			for(int j = 0; j < i; j++) {
				if( copy[i].getAge() > copy[j].getAge()) {
					Member temp = copy[i];
					copy[i] = copy[j];
					copy[j] = temp;
				}
			}
		}
		return copy;
	}

	
	//성별 내림차순
	public Member[] sortGenderDesc() {
		Member[] copy = mem.clone();
		
		for(int i = 0; i < memberCount; i++) {
			for(int j = 0; j < i; j++) {
				if( copy[i].getGender() =='M' && copy[j].getGender() =='F') {
					Member temp = copy[i];
					copy[i] = copy[j];
					copy[j] = temp;
				}
			}
		}
		return copy;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
