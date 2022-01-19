package com.method.hw2.controller;

public class NonStaticSample {

	public NonStaticSample() {
		//기본생성자
	}
	
	public int[] intArrayAllocation(int length) {
		
		//1. 길이가 length인 배열 선언
		int[] arr = new int[length];
		
		//2. length만큼 반복, 1~100난수 출력
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100 + 1);
		}
		return arr; //arr이 리턴
	}
	
	
	public void display(int[] arr) {
		//1. 위에서 전달 받은 배열 출력 
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " "); //배열 랜덤값 출력
		}
		
	}
	
	
	public void swap(int[] arr, int idx1, int idx2) {
		//위에서 한 arr배열의 idx1과 idx2를 교환
		
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
		
	}
	
	
	public void sortDescending(int[] arr) {
		
		//내림차순
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) { //비교주체 > 비교대상
					swap(arr, i, j);
				}
			}
		}
		display(arr); //위에서 배열 랜덤값 출력하는 메소드 + 내림차순
		
	}
	
	
	public void sortAscending(int[] arr) {
		
		//오름차순
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j]) { //비교주체 < 비교대상
					swap(arr, i, j);
				}
			}
		}
		display(arr);
	}
	
	
	public int countChar(String str, char c) {
		//문자열, 문자 하나씩 전달받아 문자열에 포함된 문자의 개수 리턴
		
		//1. 문자 개수 담을 결과 변수
		int count = 0;
		
		//2. 문자열 길이만큼 반복
		for(int i = 0; i < str.length(); i++) {
			
			//3. 문자열에 문자c와 같은 문자가 있다면 카운트혀
			if(str.charAt(i) == c) {
				count++;
			}
		}
		//3번에서 센 문자 개수 리턴
		return count;
		
	}
	
	
	public int totalValue(int num1, int num2) {
		//정수 두개 전달받아 두 수 중 작은 값에서 큰 값 사이 정수들의 합계 리턴
		//단! 전달받은 두 수는 포함x
		
		//리턴할 합계 변수
		int sum = 0;
		
		//1.두 수 중 작은값!(최소값)
		int min = Math.min(num1, num2);
		int max = Math.max(num1, num2);
		
		//2. 반복문으로 정수들 누적합계 만들기
		for(int i = min+1; i < max; i++) {
			sum += i;
		}
		return sum;
		
	}
	
	
	public char pCharAt(String str, int index) {
		//전달받은 문자열의 인덱스를 통해 해당 인덱스의 문자 리턴
		char ch;
		return ch = str.charAt(index);
	}
	
//	public char pCharAt2(String str, int index) {
//		//전달받은 문자열의 인덱스를 통해 해당 인덱스의 문자 리턴
//		char ch;
//		return ch = str.charAt(index - 1);
//	}
//	
	
	public String pConcat(String str1, String str2) {
		//두 개의 문자열 전달받아 하나의 문자열로 합치기
		return str1 + str2;
	}
	
	
	
}
