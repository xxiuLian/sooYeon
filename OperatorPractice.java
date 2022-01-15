package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "양수다" : "양수가 아니다";
		
		System.out.println(result);
		
	}
	
	public void practice2() {
		
			System.out.print("정수 : ");
			int num = sc.nextInt();
			
			String result = num > 0 ? "양수다" : num == 0 ? "0이다" : "양수가 아니다";
			
			System.out.println(result);
			
	}
	
	public void practice3() {
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		//입력받은 num을 2로 나눴을때 나머지가 없이 0으로 딱 떨어지면 짝수쓰
		String result = num % 2 == 0? "짝수다" : "홀수다";
		
		System.out.println(result);
		
	}
	
	public void practice4() {
		
		//모든 사람 사탕 나눠가지기
		//인원 수 , 사탕 개수 입력받기
		System.out.print("인원 수 : ");
		int person = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		//1인당 사탕 나눠갖은 개수(/)와 남는 사탕 개수(%) 출력
		int div = candy / person;
		int remainder = candy % person;
		
		System.out.println("1인당 사탕 개수 : " + div);
		System.out.println("남는 사탕 개수 : " + remainder);
		
	}
	
	public void practice5() {
		
		//입력받은 이름, 학년, 반, 번호, 성별, 성적 화면에 출력
		//이때 성별이 m이면 남학생 m아니면 여학생
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		System.out.print("반(숫자만) : ");
		int group = sc.nextInt();
		System.out.print("번호(숫자만) : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine() == "M" ? "남" : "여";
		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		double score = sc.nextDouble();
		//%d - 정수 %s - 문자열 %.2f - 실수 소수점 둘째자리까지 표현
		System.out.printf("%d학년 %d반 %d번 %s %s학생의 성적은 %.2f이다.", grade, group, num, name, gender, score);
		
	}
	
	
	public void practice6() {
		
		//나이 키보드로 입력받기 13세 이하 :어린이 13세 초과 ~ 19세 이하 :청소년, 19세 초과 :성인
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : age > 19 ? "성인" : "청소년";
		
		System.out.println(result);

		
	}
	
	
	public void practice7() {
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		
		//합계와 평균 구하고! 세 과목 점수가 각각 40점 이상, 평균 60점 이상일때 합격, 불합격
		int sum = kor + eng + math;
		double avg = sum / 3;
		
		String result = kor >= 40 && eng >= 40 && math >= 40 && avg >= 60 ? "합격" : "불합격";		
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println(result); //합격인지 불합격인지 출력~
		
	}
	
	
	public void practice8() {
		
		//주민번호 입력받고 남자인지 여자인지 판별
		System.out.print("주민번호를 입력하세요 (-포함) : ");
		String personal = sc.nextLine().charAt(7) % 2 == 0 ? "여자" : "남자";
		 //0부터 시작하는거 까먹고 계속 8로 써서 에러남

		System.out.println(personal);
		
	}
	
	public void practice9() {
		
		while(true) {
			//두개 정수 입력받고! 정수 하나 더 입력! 그 수가 앞에 두개의 정수 사이에 속하면 false
			System.out.print("정수 1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수 2 : ");
			int num2 = sc.nextInt();
			if(num1 > num2) {
				System.out.println("정수 1이 더 큽니다 다시 입력해주세요");
			}
			System.out.print("입력 : ");
			int num3 = sc.nextInt();
			
			//num1이하거나 num2 초과면 true
			boolean result = (num1 >= num3) || (num2 < num3);
			System.out.println(result);
			break;
		}
	}
	
	public void practice10() {
		
		//3개의 수 입력받고 3개 모두 같아야 true
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		boolean result = (num1 == num2) && (num2 == num3);
		System.out.println(result);
		
	}
	
	public void practice11() {
		
		//A사원 B사원 C사원 인센 포함한 연봉 계산
		//인센 포함 연봉이 3000이상이면 3000이상 출력 미만이면 3000미만 출력
		//A사원 인센 0.4 B사원 없음 C사원  0.15
		System.out.print("A사원 연봉 : ");
		int aYear = sc.nextInt();
		System.out.print("B사원 연봉 : ");
		int bYear = sc.nextInt();
		System.out.print("C사원 연봉 : ");
		int cYear = sc.nextInt();
		
		
		//인센과 연봉계산
		//(aYear + (aYear * 0.4) == aYear * 1.4
		double aTotal = aYear * 1.4;
		double bTotal = bYear;
		double cTotal = cYear * 1.15;
		
		String aResult = aTotal >= 3000 ? "3000이상" : "3000미만";
		String bResult = bTotal >= 3000 ? "3000이상" : "3000미만";
		String cResult = cTotal >= 3000 ? "3000이상" : "3000미만";
		
		System.out.println("A사원의 인센티브 포함 연봉 : " + aTotal);
		System.out.println(aResult);
		System.out.println("B사원의 인센티브 포함 연봉 : " + bTotal);
		System.out.println(bResult);
		System.out.println("C사원의 인센티브 포함 연봉 : " + cTotal);
		System.out.println(cResult);

		
	}
	
	
}
