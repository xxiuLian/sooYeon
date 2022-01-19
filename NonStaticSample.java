package com.method.hw1.controller;

public class NonStaticSample {

	public NonStaticSample() {
		//기본생성자
	}
	
	public void printLottoNumbers() {
		
		//1.크기가 6인 정수형 배열 선언
		int[] lotto = new int[6]; //-->크기가 6개란 소리임 인덱스는 012345까지겠지?
		
		//2.반복문 통해 랜덤 숫자 출력
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			
			//중복 출력 방지!!!
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		//3.오름차순 정렬
		for(int i = 0; i < lotto.length; i++) {
			for(int j = 0; j < i; j++) {
				if(lotto[i] < lotto[j]) {
				int temp = lotto[i];
				lotto[i] = lotto[j];
				lotto[j] = temp;
				}
			}
		}
		//4. 랜덤숫자, 중복방지, 오름차순했으니 출력
		for(int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		
	}
	
	public void outputChar(int num, char c) {
		// 매개변수로 전달받은 문자 c를 전달받은 num 갯수 만큼 출력하는 메소드
		for(int i = 0; i < num; i++) { //num만큼 반복
			System.out.print(c + " "); //반복되는(num)만큼 c출력
		}
		System.out.println();
	}
	
	public char alphabette() {
		//A~Z : 65 ~ 90
		//a~z : 97 ~ 122

		//1. 값 결과 받을 변수 선언
		int num = 0;
		
		while(true) { //영어 나올때까지 돌려
			num = (int)(Math.random() * 58 + 65); //65부터 58개의 랜덤값(=65 ~ 122사이 랜덤값)
			
			if(num >= 'A' && num <= 'Z' || num >= 'a' && num <= 'z') {
				break; //조건이 맞다면 while문 빠져나오기
			}
		}
		return (char) num;
		
	}
	
	public String mySubstring(String str, int index1, int index2) {
		
		//1. 문자열이 null인지 확인
		if(str != null) {//=값이 있다면
			//2. 결과 담을 문자열 변수
			String newStr = "";
			
			for(int i = index1; i < index2; i++) {
				newStr += str.charAt(i);
			}
			return newStr;
			
		}else {//=값이 없다면
			return null;
		}
	}
	
	
}
