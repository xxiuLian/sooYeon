package com.kh.array.practice;

import java.util.Scanner;

public class Arraypractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		//길이가 10 정수형 배열 만들고 12345678810 출력
		int[] arr = new int[10];
		
		//1부터 시작해야함~ i는 1,  배열arr길이만큼돌리고 10개 다들어가야해서 부등호는 <=라는 조건, 1증가
		for(int i = 1; i <= arr.length; i++) {
			System.out.print(i + " ");
		}
		
	}
	
	
	public void practice2() {
		
		//길이 10 정수형 배열 만들고 10987654321역순 출력
		int[] arr = new int[10];
		
		//거꾸로 시작 (길이)10부터 시작, 1까지 나와야함 그래서 > 0, 역순 하나씩 뺴줘야하니까 1감소 
		for(int i = arr.length; i > 0; i--) {
			System.out.print(i + " ");
		}
		
	}
	
	
	public void practice3() {
		
		while(true) { //음수쓰면 다시 리플레이
		
			//입력받은 양의 정수만큼 배열 크기 할당, 1부터 입력받은 값까지 출력
			System.out.print("양의 정수 : ");
			int num = sc.nextInt();
			if(num <= 0) { //음수쓰면!!!!!ㅡㅡ
				System.out.println("양의 정수가 아닙니다."); continue; //다시해다시
			}
			//양의정수 배열크기넣는 곳에 쏙!!!!!
			int[] arr = new int[num];
			
			for(int i = 1; i <= arr.length; i++) {
				System.out.print(i + " ");
			}
			break; //출력 잘 됐으니까 끝내
		}
		
	}
	
	
	public void practice4() {
		
		//길이 5인 문자열배열 선언 사과 귤 포도 복숭아 참외 배열인덱스 활용해서 초기화
		String[] fruit = new String[5];
		
		fruit[0] = "사과";
		fruit[1] = "귤";
		fruit[2] = "포도";
		fruit[3] = "복숭아";
		fruit[4] = "참외";
		
		System.out.println(fruit[1]);
		
		
	}
	
	
	public void practice5() {
		
		//문자열 입력받고 그거 문자 하나하나 배열에 넣고 검색할 문자열에 몇 개 들어가있는지 개수랑 인덱스번호 출력
		System.out.print("문자열 : ");
		String word = sc.nextLine();
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		//문자열 길이만큼 char에 크기 할당
		char[] arr = new char[word.length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = word.charAt(i);
		}
		
		//몇개들어가있는지 count해야하니까 변수 초기화
		int count = 0;
		
		/////인덱스번호 어디야?????
		System.out.print(word + "에 " + ch + "가 존재하는 위치(인덱스) : "); //이거 for문 안에 쓰면 안됨 ch가 다수면 계속 나올 수 있음ㅋㅋ
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ch) {
				System.out.print(i + " ");
				count++;
			}
		}
		////문자열에 몇 개 들어가있어???
		System.out.println();
		System.out.println(ch + " 개수 : " + count);
		
		
	}
	
	
	public void practice6() {
		
		//월~일요일까지 초기화된 문자열 배열 만들고 0부터 6까지 숫자 입력받아 같은 인덱스에 있는 요일 출력
		//범위에 없으면 잘못입력했다고 출력
		while(true) {//잘못입력하면 다시 입력하게 하려고ㅎ
			
			String[] week = {"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
			
			System.out.print("0 ~ 6사이 숫자 입력 : ");
			int num = sc.nextInt();
			if(num > 6 || num < 0) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요"); continue;
			}
			
			//for문 돌려서 0-월 1-화 ...매치매치
			for(int i = 0; i <= week.length; i++) {
				if(i == num) {
					System.out.println(week[i]);
				}
			}
			break;
			
		}
//		방법 2
//		if(num > 0 || num <= 6) 
//			System.out.println(week[num]);
//			//week[0] = "월요일"
//		
//		else 
//			System.out.println("잘못 입력하셨습니다.");
		
		
		
	}
	
	
	public void practice7() {
		
		//배열의 길이 입력받고 (정수형) 배열 크기만큼 값 입력해 인덱스 값을 초기화
		//배열 전체 값 나열
		//배열에 저장된 값 합계
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		//배열 안 값 합계 구할 변수 초기화//for안에서 쓰면 계속 출력되니 밖에서 선언쓰
		int count = 0;
		
		//for문 돌려서 인덱스에 넣을 값 받기
		for(int i = 0; i < arr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			count += arr[i]; //값을 또 더해줘야 하니께
		}
		
		//다 만들어 놨으니 출력할 차례~
		for(int i = 0; i <arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("총 합 : " + count);
		
		
	}
	
	
	public void practice8() {
		while(true) {
			//3이상인 홀수 정수 입력 중간까지 1부터 1씩 증가
			System.out.print("정수 : ");
			int num = sc.nextInt();
			
			if(num % 2 == 1 && num >= 3) {
				
				int[] arr = new int[num]; //if 밖에 선언시 정수에 음수넣으면 에러발생!!
				
				//num 반땅하고 +1한 값까지 오름차순
				for(int i = 1; i <= arr.length/2+1; i++) {
					System.out.print(i + ", ");
				}
				//num반땅한 값부터 내림차순(역순)
				for(int i = arr.length/2; i > 0; i--) {
					if(i == 1) System.out.print(i);
						else System.out.print(i + ", ");
				}
				break;
			} else {
				System.out.println("다시 입력하세요");
			}
		}
	}
	
	
	public void practice9() {
		
		//입력한 값이 배열에 있는지 검색 있으면 배달 가넝 없으면 없다고 출력
		String[] menu = {"후라이드", "양념", "골드킹", "뿌링클"};
		
		System.out.print("치킨 이름을 입력하세요 : ");
		String chicken = sc.nextLine();
		
		//입력받은 치킨 있나 없나 논리연산자
		boolean flag = false;
		
		for(int i = 0; i < menu.length; i++) {
			if(menu[i].equals(chicken)) 
				flag = true;
		}
		
		//true면 입력받은chicken이 menu에 있다는 뜻
		if(flag) {
			System.out.println(chicken + "치킨 배달 가능");
		}else {
			System.out.println(chicken + "치킨은 없는 메뉴입니다.");
		}
		
		
		
	}
	
	
	public void practice10() {
		
		//크기가 10인 정수형 배열 할당, 1~10사이의 난수 발생시켜 초기화&출력
		int[] random = new int[10];
		
		for(int i = 0; i < random.length; i++) {
			
			random[i] = (int)(Math.random() * 10 + 1); //괄호 안하니까 1111만 나옴.....잘 씌워주기
			
		}
		
		//다 만들어놨으니 출력~~~
		for(int i = 0; i < random.length; i++) {
		
			System.out.print(random[i] + " ");
		}
		
	}
	
	
	public void practice11() {
		
		//크기가 10인 정수형 배열 할당, 1~10난수 배열에 초기화, 거기서 최대값최소값출력
		int[] random = new int[10];
		
		
		for(int i = 0; i < random.length; i++) {
			random[i] = (int)(Math.random() * 10 + 1);
			System.out.print(random[i] + " "); //난수 발생시킨거 먼저 출력
		}
		
		for(int i = 0; i < random.length; i++) {
			for(int j = 0; j < i; j++) {
				//random[1] < random[0] 앞이 더 크면 안되니까 자리 바꾸는거임 왜? 오름차순 해야하니까
				if(random[i] < random[j]) {
					int tem = random[i];
					random[i] = random[j];
					random[j] = tem;
				}
			}
		}
		System.out.println();
		System.out.println("최대값 : " + random[9]);
		System.out.println("최소값 : " + random[0]);
		
		
	}
	
	
	public void practice12() {
		
		//크기가 10인 정수형 배열 선언, 1~10난수 발생 중복값 없게!
		int[] random = new int[10];
		
		
		for(int i = 0; i < random.length; i++) {
			random[i] = (int)(Math.random() * 10 + 1); //난수 발생
			
			for (int j = 0; j < i; j++) { //하지만 중복값이 있다면??
				if(random[i] == random[j]) {
					i--;//1감소시켜서 밸런스맞추기
				}
			}
		}
		//출력~
		for(int i = 0; i < random.length; i++) {
			System.out.print(random[i] + " ");
		}
		
	}
	
	
	public void practice13() {
		
		System.out.println("주민등록번호(-포함) : ");
		String num = sc.nextLine();
		
		char[] numArr = new char[num.length()];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = num.charAt(i);
		}
		
		//성별 다음부터 *표시!!
		for(int i = 0; i < numArr.length; i++) {
			if (i > 7) {
				numArr[i] = '*';
			}
		}
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
		
	}
	
	
	public void practice14() {
		
		//로또 번호 자동 생성기, 중복 x, 오름차순!!
		int[] random = new int[6];
		
		
		for(int i = 0; i < random.length; i++) {
			random[i] = (int)(Math.random() * 45 + 1); //난수 발생
			
			for (int j = 0; j < i; j++) { //하지만 중복값이 있다면??
				if(random[i] == random[j]) {
					i--;//i 인덱스 감소 시켜서 밸런스맞추기
				}
				if(random[i] < random[j]) { //오름차순
					int tem = random[i];
					random[i] = random[j];
					random[j] = tem;
				}
			}
		}
		
		for(int i = 0; i < random.length; i++) {
			
			System.out.print(random[i] + " ");
		}
		
	}
	
	
	
}
