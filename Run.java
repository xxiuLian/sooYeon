package com.method.hw1.run;

import com.method.hw1.controller.NonStaticSample;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonStaticSample ns = new NonStaticSample();
		
		//1. 매개변수X 반환값X
		System.out.print("1. 랜덤 값 : ");
		ns.printLottoNumbers();
		
		//2. 매개변수O 반환값X
		System.out.println();
		System.out.print("2. a문자 5개 출력 : ");	
		ns.outputChar(5, 'a');
		
		//3. 매개변수X 반환값O
		System.out.print("3. 랜덤 영문자 출력 : ");
		System.out.println(ns.alphabette());
		
		//4. 매개변수O 반환값O
		System.out.print("4. apple의 2번 4번 인덱스 사이의 값 출력 : ");
		System.out.println(ns.mySubstring("apple", 2, 4));
	}

}
