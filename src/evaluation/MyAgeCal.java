package evaluation;

import java.util.Calendar;

public class MyAgeCal {
    public static void main(String[] args) {
    	
        int birthYear = 1994;
        int nowYear =  Calendar.getInstance().get(Calendar.YEAR);
        int myAge = nowYear-birthYear;
        System.out.printf("내 나이는 %d살 입니다.", myAge);
    }
}
