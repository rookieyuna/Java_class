package ex15usefulclass;

import java.util.Calendar;
import java.util.Scanner;

class CalenderPrint{
	//사용자가 입력할 년/월
	public int year; 
	public int month;
	//해당월의 마지막 날짜와 1일의 요일
	public int lastDay;
	public int startWeek;
	
	//생성자
	public CalenderPrint(int year, int month) {
		this.year = year;
		this.month = month;
		Calendar c = Calendar.getInstance();
		//사용자가 지정한 년/월로 설정, 단 월은 0부터 시작하기 때문에 1을 뺌
		c.set(year, month-1, 1);
		//해당월의 마지막 날을 구함(28/29/30/31일)
		this.lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		//해당월의 1일의 요일을 구함, SUNDAY로 1부터 시작
		this.startWeek = c.get(Calendar.DAY_OF_WEEK);
	}
	
	//실제달력을 출력하는 메서드
	public void display() {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		//만약 1일이 수요일이면 startWeek==4이므로 tab은 3번 삽입
		for(int i=1; i<startWeek; i++) {
			System.out.print(" \t");
		}
		//1일부터 마지막날까지 날짜를 출력
		int countDay=startWeek;
		for(int i=1; i<=lastDay; i++) {
			System.out.printf("%2d\t",i);
			//토요일이 되었을 때 줄바꿈 처리
			if(countDay%7==0) {
				System.out.println();
			}
			countDay++;
		}
	}
}

public class E05DateCalendar2 {
	
	public static void main(String[] args) {
		
		System.out.println("달력 출력하기");
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 및 월 입력(스페이스로 구분가능): ");
		int year = sc.nextInt();
		int month = sc.nextInt();
		new CalenderPrint(year, month).display();
	}
}
