package com.kh.practice1.example;

import java.util.Scanner;

public class VariablePractice {

	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		
		while(true) {
			System.out.print("이름을 입력하세요 : ");
			String name = sc.nextLine();
			System.out.print("나이를 입력하세요 : ");
			int age = sc.nextInt();
			sc.nextLine(); //--> 버퍼 비우기 왜? 나이 입력후 엔터 치면 gender가 엔터를 인식해서 넘어감
			System.out.print("성별을 입력하세요(남/여) : ");
			char gender = sc.nextLine().charAt(0);
			if(gender == '남' || gender == '여') {
				System.out.print("키를 입력하세요(cm) : ");
				double height = sc.nextDouble();
				System.out.println("키 " + height + "인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다^^");
				System.out.printf("키 %.1f인 %d살 %c자 %s님 반갑습니다^^", height, age, gender, name);
				break;
			}else {
				System.out.println("다시 입력해주세요");
				continue;
			}
		}	
	}
	
	
	public void method2() {
		
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		int add = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		int div = num1 / num2;
		
		System.out.println("더하기 결과 : " + add);
		System.out.println("빼기 결과 : " + sub);
		System.out.println("곱하기 결과 : " + mul);
		System.out.println("나누기 몫 결과 : " + div);
		
	}
	
	
	public void method3() {
		
		System.out.print("가로 : ");
		double num1 = sc.nextDouble(); //실수형으로 받기
		System.out.print("세로 : ");
		double num2 = sc.nextDouble();
		
		double width = num1 * num2; //면적 = 가 * 세
		double length = (num1 + num2) * 2; //둘레 = (가 + 세) *2
		
		System.out.println("면적 : " + width);
		System.out.println("둘레 : " + length);
		System.out.printf("면적 : %.1f\n", width); //소수점 1째자리까지 표현
		System.out.printf("둘레 : %.5f\n", length); //소수점 5째자리까지 표현 값이 없으면 0으로 표시됨
		
	}
	
	public void method4() {
		
		System.out.println("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		System.out.println("첫 번째 문자 : " + str.charAt(0));
		System.out.println("두 번째 문자 : " + str.charAt(1));
		System.out.println("세 번째 문자 : " + str.charAt(2));
		
	}
	
}
