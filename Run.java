package com.method.hw3.run;

import com.method.hw3.controller.StaticSample;

public class Run {

	public static void main(String[] args) {
//		StaticSample ss = new StaticSample();
//		ss.setValue("java");
//		System.out.println("value : " + ss.getValue());
//		
//		ss.toUpper();
//		System.out.println("를 대문자로 : " +ss.getValue());
//		
//		System.out.println("길이 : " + ss.valueLength());
//		
//
//		System.out.println("Programming 붙이기" + ss.valueConcat("PROGRAMMING"));
//		
//		ss.setChar(0, 'C');
//		System.out.println("J => C : " + ss.getValue());
		
		StaticSample.setValue("java");
		System.out.println("value : " + StaticSample.getValue());
		
		StaticSample.toUpper();
		System.out.println("를 대문자로 : " + StaticSample.getValue());
		
		System.out.println("길이 : " + StaticSample.valueLength());
		

		System.out.println("Programming 붙이기" + StaticSample.valueConcat("PROGRAMMING"));
		
		StaticSample.setChar(0, 'C');
		System.out.println("J => C : " + StaticSample.getValue());

	}

}
