package ex09package;

import ex09package.kosmo.buyer.FruitBuyer3;
import ex09package.kosmo.seller.FruitSeller3;

/*
연습문제] 해당 프로그램을 아래의 지시에 따라 패키지로 구분하여 
정상 실행되도록 변경하시오.

FruitSeller3 클래스 -> ex09package.kosmo.seller 패키지에 묶는다
FruitBuyer3 클래스 -> ex09package.kosmo.buyer 패키지에 묶는다

두 클래스를 적절히 import 하여 정상 동작 할 수 있도록 FruitSalesMain3 구성

 */

public class FruitSalesMain4
{
	public static void main(String[] args)
	{
		
		//판매자1 : 사과100개, 단가 1000원
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);
		
		//판매자2 : 사과 80개, 단가300원
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		
		//구매자 : 보유금액 10000원
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
		System.out.println("구매행위가 일어나기전 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//판매자1, 판매자2에게 각각 5000원 지불하고 구매
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어난 후 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
	}
}
