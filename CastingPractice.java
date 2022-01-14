package com.kh.practice1.example;

import java.util.Scanner;

public class CastingPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		System.out.println(ch + " Unicode : " + (int)ch); //문자는 정수로 형변환이 가능 ex) A = 65
		
	}
	
	public void method2() {
		
		System.out.print("국어 : ");
		double kor = sc.nextDouble();
		System.out.print("영어 : ");
		double eng = sc.nextDouble();
		System.out.print("수학 : ");
		double math = sc.nextDouble();
		
		//총점과 평균 (정수형)
		int sum = (int) (kor + eng + math);
		int avg = sum / 3;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
	}
	
	public void method3() {
		
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		System.out.println(iNum1 / iNum2);
		System.out.println((int)dNum);  //실수 2.5를 정수화 시키면 0.5가 댕강!!!
		System.out.println(iNum2 * dNum); //자동형변환! 정수에서 실수로 편입~~~
		System.out.println((double)iNum1); //정수 10을 실수화 시키면 10.0!!!
		System.out.println("==============");
		System.out.println((int)fNum); //실수 3.0f를 정수화 시키면 3
		System.out.println(iNum1 / (int)fNum); //10 / 정수화 시킨 3 = 3
		System.out.println(iNum1 / fNum); //자동형변환! 정수에서 실수로 편입~~~
		System.out.println((double)iNum1 / fNum); //정수 10을 실수화 시키기 10.0 / 3.0f
		System.out.println("==============");
		System.out.println(ch);
		System.out.println((int)ch); //문자A를 정수화시키면 해당 문자 유니코드 출력!! =65
		System.out.println(ch + iNum1); //문자A 정수화시키고(안시켜도 자동형변환됨) 정수iNum1이랑 더하기
		System.out.println((char)(ch + iNum1)); //75를 다시 문자화
	}
	

}
