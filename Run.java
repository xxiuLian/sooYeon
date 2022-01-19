package com.method.hw2.run;

import com.method.hw2.controller.NonStaticSample;

public class Run {

	public static void main(String[] args) {
		NonStaticSample ns = new NonStaticSample();
		
		System.out.print("- 크기가 5인 배열의 랜덤값 : ");
		int[] arr = ns.intArrayAllocation(5); // intArrayAllocation(int length)
		ns.display(arr); //display(int[] arr)

		System.out.println();
		System.out.print("- 내림차순 출력 : ");
		ns.sortDescending(arr);
		
		
		System.out.println();
		System.out.print("- 오름차순 출력 : ");
		ns.sortAscending(arr);
		
		
		System.out.println();
		System.out.println("\n- apple문자열에 p의 개수 : " + ns.countChar("apple", 'p'));
		System.out.println("- 13과 7사이 정수들의 합계 : " + ns.totalValue(13, 7));
		System.out.println("- programming문자열의 3번 인덱스 문자 : " + ns.pCharAt("programming", 3));
//		System.out.println("- programming문자열의 3번째 문자 : " + ns.pCharAt2("programming", 3));
		System.out.println("- JAVA와 programming을 합친 문자열 : "  + ns.pConcat("JAVA", "programming"));
	}

}
