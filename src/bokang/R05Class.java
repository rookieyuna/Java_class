package bokang;

import bokang.sub.CheckCard1;
import bokang.sub.CheckCard2;
import bokang.sub.CheckCard3;

public class R05Class
{

	public static void main(String[] args)
	{
		//체크카드 ver01.
		CheckCard1 cc1 = new CheckCard1();
		/*
		long타입을 쓰면 숫자 가독성을 위해서 언더바(_)를 쓸 수 있다.
		JDK7.0부터 지원하며 숫자사이에 쓰는 것만 허용한다.(출력시 안보임)
			잘못된 방법] 3._14159, 12_34_, _12_34 등 숫자 사이 아닐경우 오류
		 */
		cc1.cardNumber = 8765_1221_3456_7678L; 
		cc1.owner = "홍길동";
		cc1.balance = 10000;
		cc1.point = 0;
		
		cc1.payment(5000);
		cc1.payment(10000);
		cc1.showState();

		cc1.balance = 10000000; //멤버변수(public) 직접접근 가능
		
		////////////////////////////////////////////////
		System.out.println();
		
		CheckCard2 cc2 = new CheckCard2();
		cc2.initMembers(9999_8888_7777_6666L, "유비", 3000, 0);
		cc2.charge(4000);
		cc2.payment(9000);
		cc2.showState();
		
		//cc2.balance = 1000000; //멤버변수(private) 직접접근 불가
		
		////////////////////////////////////////////////
		System.out.println();
		
		CheckCard2 cc2_1 = new CheckCard2(1111_2222_3333_4444L, "제갈량", 10000, 0);
		cc2_1.payment(5000);
		cc2_1.showState();
		
		
		///////////////////////////////////////////////
		System.out.println();
		
		CheckCard3 cc3 = new CheckCard3(1111_2222_3333_4444L, "관우", 10000, 0);
		cc3.charge(8000);
		cc3.charge(20000);
		cc3.payment(50000);
		cc3.showState();
	}

}
