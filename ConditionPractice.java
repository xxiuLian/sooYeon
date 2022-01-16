package com.kh.chap01_condition;

import java.util.Scanner;

public class ConditionPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		//메뉴 번호 누르면 "ㅇㅇ메뉴입니다" 종료 번호 누르면 종료된다고 출력
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("9. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");		
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1: System.out.println("입력 메뉴입니다."); break;
		case 2: System.out.println("수정 메뉴입니다."); break;
		case 3: System.out.println("조회 메뉴입니다."); break;
		case 4: System.out.println("삭제 메뉴입니다."); break;
		case 9: System.out.println("프로그램을 종료합니다."); return;
		default: System.out.println("잘못 누르셨습니다."); return;
		}
		
	}
	
	
	public void practice2() {
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			if(num % 2 == 0) 
				System.out.println("짝수댜!!!!!!!");
			else 
				System.out.println("홀수다");
		}else System.out.println("양수만 입력해주세요");	
		
	}
	
	
	public void practice3() {
		
		/*국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
		합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
		(합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
		합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고
		불합격인 경우에는 “불합격입니다.”를 출력하세요.*/
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		int sum = kor + math + eng;
		double avg = sum / 3;
		
		if(kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		}else System.out.println("불합격입니다.");  //한 줄 쓰는거면 괄호 안해도 됨 
		
	}
	
	
	public void practice4() {
//		봄, 여름, 가을, 겨울 예제를 switch문으로 바꿔서 출력하세요.
		
		System.out.print("1 ~ 12 사이의 정수 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 12: case 1: case 2 :
			System.out.println(num + "월은 겨울입니다."); break;
		case 3: case 4: case 5 :
			System.out.println(num + "월은 봄입니다.");break;
		case 6: case 7: case 8 :
			System.out.println(num + "월은 여름입니다.");break;
		case 9: case 10: case 11 :
			System.out.println(num + "월은 가을입니다.");break;
		default : System.out.println("잘못 누르셨습니다."); return;
		}
		
	}
	
	
	public void practice5() {
		
		/*아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
		로그인 성공 시 “로그인 성공”, 
		아이디가 틀렸을 시 “아이디가 틀렸습니다.“,
		비밀번호가 틀렸을 시 “비밀번호가 틀렸습니다.”를 출력하세요.*/

		
		String userId = "user1";
		String userPwd = "1234";
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		if(id.equals(userId)) {
			if(pwd.equals(userPwd)) System.out.println("로그인 성공");
			else System.out.println("비밀번호가 틀립니다.");	
			
		}else System.out.println("아이디가 틀렸습니다.");
		
	}
	
	
	public void practice6() {
		
		/*사용자에게 관리자, 회원, 비회원 중 하나를 입력 받아 각 등급이 행할 수 있는 권한을 출력하세요.
		단, 관리자는 회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		회원은 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		비회원은 게시글 조회만 가능합니다.
		(단, 잘못 입력하였을 경우 “잘못 입력했습니다.” 라는 출력문이 출력되도록)*/
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String grade = sc.nextLine();
		
		switch(grade) {
		case "관리자" :
			System.out.println("회원관리, 게시글 관리");
		case "회원" :
			System.out.println("게시글 작성, 댓글 작성");
		case "비회원" :
			System.out.println("게시글 조회"); break;
		default : System.out.println("잘못 입력했습니다."); return;
		}
		
		
	}
	
	
	public void practice7() {
		
		/*키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라
		저체중 / 정상체중 / 과체중 / 비만을 출력하세요.
		BMI = 몸무게 / (키(m) * 키(m))
		BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
		BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
		BMI가 30이상일 경우 고도 비만*/
		
		//1. 키,몸무게 double형으로 입력 받기
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		//2. bmi지수 계산
		double bmi = weight / (height * height);
		System.out.println("BMI 지수 : " + bmi);
		
		if(bmi >= 30) {
			System.out.println("고도 비만");
		} else if (bmi >= 25) {
			System.out.println("비만");
		} else if (bmi >= 23) {
			System.out.println("과체중");
		} else if (bmi >= 18.5) {
			System.out.println("정상체중");
		} else {
			System.out.println("저체중");
		}
		
	}
	
	
	public void practice8() {
		
		/*키보드로 두 개의 양수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
		(단, 양수가 아닌 값을 입력하거나 제시되어 있지 않은 연산 기호를 입력 했을 시
		“잘못 입력하셨습니다. 프로그램을 종료합니다.” 출력)
		(printf()문을 이용하여 마지막 출력문을 작성해보시오.)*/

		//1. 두개의 양수와 연산 기호를 입력받기
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		char op = sc.nextLine().charAt(0);
		
		//2.연산 결과를 담을 변수 선언
		int result = 0;
		
		//3.양수면 연산 실행
		if(num1 > 0 && num2 > 0) {
			
			switch(op) {
			case '+':
				result = num1 + num2; break;
			case '-':
				result = num1 - num2; break;
			case '*':
				result = num1 * num2; break;
			case '/':
				result = num1 / num2; break;
			case '%':
				result = num1 % num2; break;
			default :
				System.out.println("연산자를 잘못 입력하셨습니다. 프로그램을 종료합니다."); return;
			}//연산자 잘못 입력시 default 출력
		}else {
			System.out.println("양수가 아닙니다. 프로그램을 종료합니다.");//양수 아니면 출력
		}
		System.out.printf("%d %c %d = %d", num1, op, num2, result);

	}
	
	
	public void practice9() {
		
		/*중간고사, 기말고사, 과제점수, 출석회수를 입력하고 Pass 또는 Fail을 출력하세요.
		총 점 100점 중 배점으로는 다음과 같다.
		중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)
		이 때, 출석 회수는 총 강의 회수 20회 중에서 출석한 날만 입력
		총 점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
		아니면 Fail을 출력하세요.*/
		
		System.out.print("중간 고사 점수 : ");
		double mid = sc.nextInt() * 0.2;
		System.out.print("기말 고사 점수 : ");
		double fin = sc.nextInt() * 0.3;
		System.out.print("과제 점수 : ");
		double hw = sc.nextInt() * 0.3;
		System.out.print("출석 횟수 : ");
		int att = sc.nextInt();
		
		double total = mid + fin + hw + att;
		
		if(total >= 70) {
			if(att >= 14) { //(14/20)은 출석 70%
				System.out.println("=============결과============");
				System.out.println("중간 고사 점수(20) : " + mid);
				System.out.println("기말 고사 점수(30) : " + fin);
				System.out.println("과제 점수(30) : " + hw);
				System.out.println("출석 점수(20) : " + att);
				System.out.println("총점 : " + total);
				System.out.println("PASS");
			}else {
				System.out.println("=============결과============");
				System.out.printf("FAIL [출석 횟수 부족] (%d/20)\n", att);
			}
		} else if(att >= 14) { //총점 70미만, 출석 통과
			System.out.println("=============결과============");
			System.out.printf("FAIL [점수 미달] (총점 %.1f)\n", total);
		} else { //총점 70미만, 출석도 미달
			System.out.println("=============결과============");
			System.out.printf("FAIL [출석 횟수 부족] (%d/20)\n", att);
			System.out.printf("FAIL [점수 미달] (총점 %.1f)\n", total);
		}
		
		
	}
	
	
	public void practice10() {
		
//		앞에 구현한 실습문제를 선택하여 실행할 수 있는 메뉴화면을 구현하세요.
		
		while(true) {
			
			System.out.println("1. 메뉴 출력");
			System.out.println("2. 짝수/홀수");
			System.out.println("3. 합격/불합격");
			System.out.println("4. 계절");
			System.out.println("5. 로그인");
			System.out.println("6. 권한 확인");
			System.out.println("7. BMI");
			System.out.println("8. 계산기");
			System.out.println("9. Pass/Fail");
			System.out.print("선택 : ");
			int num = sc.nextInt();
			sc.nextLine();//버퍼 비우기 바로 실행되는 번호들이 있기 때문
			
			
			switch(num) {
			case 1 :
				practice1(); break;
			case 2 :
				practice2(); break;
			case 3 :
				practice3(); break;
			case 4 :
				practice4(); break;
			case 5 :
				practice5(); break;
			case 6 :
				practice6(); break;
			case 7 :
				practice7(); break;
			case 8 :
				practice8(); break;
			case 9 :
				practice9(); break;		
			} //switch
			System.out.println();
		}//while
		
	}
	
	

}
