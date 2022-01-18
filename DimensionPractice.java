package com.kh.practice;

import java.util.Scanner;

public class DimensionPractice {

	public void practice1() {
		
		//4행4열 정수형 배열 선언 및 할당 , 1~16 까지 값 차례대로 저장 및 출력
		int[][] arr = new int[4][4];
		
		//arr에 1씩 더해줄 변수 초기화
		int count = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = count++;
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println(); //행마다 엔터
		}
		
	}
	
	
	public void practice2() {
		
		//4행4열 정수형 배열 선언 및 할당 , 1~16 까지 값 차례대로 저장 및 출력
		int[][] arr = new int[4][4];
		
		//arr에 1씩 빼줄 변수 초기화
		int count = 16;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = count--;
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println(); //행마다 엔터
		}	
		
	}
	
	
	public void practice3() {
		
		//3행3열 문자열 배열 선언, 인덱스 0행0열 ~ 2행 2열까지 "(0,0)"형식으로 출력
		String[][] arr = new String[3][3];
	
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("(%d, %d)", i, j);
				
			}
			System.out.println();
		}
		
		
	}
	
	
	public void practice4() {
		
		//4행4열 정수형 배열 생성
		int[][] arr = new int[4][4];
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr[i].length-1; j++) {
				arr[i][j] = (int)(Math.random() * 10 + 1);
				arr[i][3] += arr[i][j];
				arr[3][j] += arr[i][j];
				arr[3][3] += arr[i][j];
			}
			
		}
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				//arr[3][3] += arr[i][3] + arr[3][j];
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}	
		
	}

	public void practice5() {
		
		//2차원 배열 행,열 크기 입력받기 1~10사이 숫자가 아니면 반드시1~10사이 정수를 입력해야합니다 출력
		//이차원 배열 안 영어 대문자 랜덤으로 들어가게 한 뒤 출력
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.print("행 크기 : ");
			int row = sc.nextInt();
			System.out.print("열 크기 : ");
			int col = sc.nextInt();
		
			
		
			char[][] alpha = new char[row][col];
			
			for(int i = 0; i < alpha.length; i ++) {
				for(int j = 0; j < alpha[i].length; j++) {
					
					alpha[i][j] = (char)((int)(Math.random() * 26 + 65));
					System.out.print(alpha[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
		
		
	public void practice6() {
			
		String[][] strArr = new String[][] {{"이","까","왔","앞","힘"},
											{"차","지","습","으","냅"},
											{"원","열","니","로","시",},
											{"배","심","다","좀","다"},
											{"열","히","! ","더","!! "}};
		for(int i = 0; i < strArr.length; i++) {
			for(int j = 0; j < strArr[i].length; j++) {
				//계속 안에서 돌고있는 j를 앞에 둬서 행으로, j가 다 돌면 바뀌는 i를 뒤에 둬서 열로 둔다.
				System.out.print(strArr[j][i] + " ");
			}
			System.out.println();
		}
										
			
		// 지금까지 읽어왔던 흐름은
		// (0, 0), (0, 1), (0, 2), (0, 3), (0, 4), 
		// (1, 0), (1, 1), (1, 2), (1, 3), (1, 4), 
		// (2, 0), ....
		// 행이 한 번 변하고 열이 계속 바뀌는 흐름

		// 현재 읽어야하는 흐름은
		// (0, 0), (1, 0), (2, 0), (3, 0), (4, 0), 
		// (0, 1), (1, 1), (2, 1), (3, 1), (4, 1), 
		// (0, 2), ....
		// 열이 한번 변하고 행이 계속 바뀌는 흐름
	}
		
		
	public void practice7() {
		
		/*사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 각각 해당 행의 크기도 받아
		문자형 가변 배열을 선언 및 할당하세요.
		그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.*/
		
		Scanner sc = new Scanner(System.in);
		
		//행 만들기
		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		
		char[][] alpha = new char[row][]; //알파벳문자니까 char형
		
		//결과에서 하나씩 커질 ....알파벳
		char result = 'a';
		
		//열 만들기
		for(int i = 0; i < alpha.length; i++) {
			System.out.print(i + "행의 크기 : ");
			int col = sc.nextInt();
			alpha[i] = new char[col];
		}
		//행과 열에 알파벳 넣기
		for(int i = 0; i < alpha.length; i++) {
			for(int j = 0; j < alpha[i].length; j++) {
				alpha[i][j] = result++;	
			}	
		}
		
		//출력
		for(int i = 0; i < alpha.length; i++) {
			for(int j = 0; j < alpha[i].length; j++) {
				System.out.print(alpha[i][j] + " ");
			}
			System.out.println();
		}

	}
		
		
	public void practice8() {
		
		/*1차원 배열에 12명의 학생들을 출석부 순으로 초기화 하고
		3행 2열로 2차원 배열 2개를 이용하여 분단을 나눠서 저장.*/
		
		String[] student = {"강건강","남나나","도대담","류라라","문미미","박보배",
							"송성실","윤예의","진재주","차천축","피풍표","홍하하"};
		
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int count = 0;
		
		System.out.println("== 1분단 ==");
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = student[count];
				System.out.print(arr1[i][j] + " ");
				count++;
			}
			System.out.println();
		}
		
		System.out.println("== 2분단 ==");
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = student[count];
				System.out.print(arr2[i][j] + " ");
				count++;
			}
			System.out.println();
		}
		
	}
	
	public void practice9() {
	
		/*1차원 배열에 12명의 학생들을 출석부 순으로 초기화 하고
		3행 2열로 2차원 배열 2개를 이용하여 분단을 나눠서 저장.*/
		
		Scanner sc = new Scanner(System.in);
		
		String[] student = {"강건강","남나나","도대담","류라라","문미미","박보배",
							"송성실","윤예의","진재주","차천축","피풍표","홍하하"};
		
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int count = 0;
		
		System.out.println("== 1분단 ==");
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = student[count];
				System.out.print(arr1[i][j] + " ");
				count++;
			}
			System.out.println();
		}
		
		System.out.println("== 2분단 ==");
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = student[count];
				System.out.print(arr2[i][j] + " ");
				count++;
			}
			System.out.println();
		}
		
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		//2분단 2번째 줄 오른쪽 출력할 변수 초기화
		String part = "";
		int row = 0;
		String col = "";
		
		//1분단에서 찾아보기
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				if(arr1[i][j].equals(name)) {
					part = "1분단";
					row = i + 1; //인덱스 0부터 시작하기 때문에 1더해서 1번째줄 2번째줄로 나오게 해줘야함
					if(j == 0) col = "왼쪽";
					else col = "오른쪽"; //(0,0) (0,1) (1,0) (1,1) 0이면 왼 1이면 오
				}
			}	
		}
		
		//2분단에서 찾아보기
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				if(arr2[i][j].equals(name)) {
					part = "2분단";
					row = i + 1; //인덱스 0부터 시작하기 때문에 1더해서 1번째줄 2번째줄로 나오게 해줘야함
					if(j == 0) col = "왼쪽";
					else col = "오른쪽"; //(0,0) (0,1) (1,0) (1,1) 0이면 왼 1이면 오
				}
			}	
		}
		
		//출력~~~~~~~
		if(part.equals("")) { //처음 초기값과 같다면 없는것,,ㅎ
			System.out.println("검색하신" + name + "학생은 없습니다.");
		}else {
			System.out.printf("검색하신 %s 학생은 %s %d번째줄 %s에 있습니다.", name, part, row, col);
		}
		
	}
	
	
	
	
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
