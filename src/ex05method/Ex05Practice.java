package ex05method;

import java.util.Scanner;

public class Ex05Practice 
{
	
	/*
	시나리오] 여러개의 숫자를 입력받은 후 최대값을 구하는 메소드를 정의하시오.
	단, 숫자의 개수는 매개변수로 전달받고 숫자의 갯수만큼 Scanner클래스를
	통해 입력받는다. 입력받은 숫자 중 최대값을 찾아 반환하도록 메소드 정의
	 */
	public static void main(String[] args) 
	{
		System.out.println("최대값:" + getMaxVal(3));
	}
	
	static int getMaxVal(int valCnt) {
		Scanner scanner = new Scanner(System.in);
		int maxVal = 0;
		for(int i=1; i<=valCnt; i++) {
			System.out.print(i+"번째 숫자입력: ");
			int inputNum = scanner.nextInt();
			if (i==0) {
				maxVal = inputNum;
			}
			else {
				if(maxVal<inputNum) {
					maxVal = inputNum;
				}
			}
		}
		return maxVal;
	}
}
