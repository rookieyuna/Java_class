package ex15usefulclass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class E05LocalDateTime
{

	public static void main(String[] args)
	{
		LocalDate localDate = LocalDate.now();
		System.out.println("오늘날짜: "+ localDate);
		LocalTime localTime = LocalTime.now();
		System.out.println("현재시간: "+ localTime);
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("지금이순간: "+ localDateTime);
		
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH시mm분ss초");
		DateTimeFormatter format3 = DateTimeFormatter
				.ofPattern("오늘은 yyyy년의 w주차, D번째날");
		DateTimeFormatter format4 = DateTimeFormatter
				.ofPattern("오늘은 M월의 W번째주, d번째날, F번째 E요일");
		System.out.println("서식1: "+ localDateTime.format(format1));
		System.out.println("서식2: "+ localDateTime.format(format2));
		System.out.println("서식3: "+ localDateTime.format(format3));
		System.out.println("서식4: "+ localDateTime.format(format4));
		
		System.out.println("현재년: "+ localDate.getYear());
		System.out.println("현재월: "+ localDate.getMonth());
		System.out.println("현재일: "+ localDate.getDayOfMonth());
		System.out.println("현재요일: "+ localDate.getDayOfWeek());
		
		//원하는 날짜로 설정한다. 올해 크리스마스로 설정
		LocalDate xMas = LocalDate.of(localDate.getYear(), 12, 25);
		System.out.println("올해 크리스마스까지....");
		
		/*
		Period 클래스: 두 날짜 사이의 간격을 나타낸다
		 */
		Period period = Period.between(localDate, xMas);
		System.out.println(period.getMonths()+"개월 "+period.getDays()+"일 남음");
		
		/*
		ChronoUnit클래스 : 특장시간 단위로 차이를 구한다
		 */
		//?개월 남음
		System.out.println(ChronoUnit.MONTHS.between(localDate, xMas));
		//?일 남음
		System.out.println(ChronoUnit.DAYS.between(localDate, xMas));
		
		//어제와 오늘
		System.out.println("어제: "+localDateTime.minusDays(1));
		System.out.println("내일: "+localDateTime.plusDays(1));
	}
}
