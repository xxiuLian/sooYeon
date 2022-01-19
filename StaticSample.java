package com.method.hw3.controller;

public class StaticSample {
	
	//필드
	private static String value;

	public StaticSample() {
		//기본생성자
	}

	public static String getValue() {
		return value;
	}

	public static void setValue(String value) {
		//static의 setter는 클래스명.변수명으로 써야함
		//일반 인스턴스만 this.사용!!
		StaticSample.value = value;
	}
	
	
	//value필드 모두 대문자로 변경~	
	public static void toUpper() {
		//1. char 배열에 value 길이 담기
		char[] arr = new char[value.length()];
		
		//2. 반복문으로 하나하나 대입
		for(int i = 0; i < value.length(); i++) {
			
			arr[i] = value.charAt(i);
		}
		
		//3. 소문자인지 검사
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 97 && arr[i] <= 122) { //a~z : 97 ~122
				arr[i] -= 32;                   //A~Z : (97-32)65 ~ 90	
			}
		}

		//4. 출력
		value = ""; //이렇게 재정의해놔야 중복으로 출력되는 것을 방지함
		
		for(int i = 0; i < arr.length; i++) {
			value += arr[i];
		}		
		
	}
	
	
	//value필드 값에 기록되어 있는 문자 개수 리턴
	public static int valueLength() {
		
		return value.length();
		
	}
	
	
	//문자열 값을 전달받아 value 필드 값과 하나로 합쳐 리턴
	public static String valueConcat(String str) {
		
		value += str;
		return value;
	}
	
	
	//전달받은 인덱스 위치의 value값을 전달받은 문자로 변경
	public static void setChar(int index, char c) {
		
		//1.value길이 = arr배열 크기
		char[] arr = new char[value.length()];
		
		//2.arr의 인덱스에 따른 값 = value 인덱스에 따른 값
		for(int i = 0; i < value.length(); i++) {
			arr[i] = value.charAt(i);
		}
		//3.출력
		arr[index] = c;
		
		value="";
		
		for(int i = 0; i < arr.length; i++) {
			value += arr[i];
		}
		
	}
	

	

	
	
}
