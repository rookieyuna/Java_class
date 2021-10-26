package ex09package.kosmo.buyer;

import ex09package.FruitSalesMain4;
import ex09package.kosmo.seller.FruitSeller3;

public class FruitBuyer3
{
	int myMoney; //보유한 금액
	int numOfApple; //구매한 사과의 개수
	
	//초기화 메서드 선언
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller3 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	//구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]사과갯수:"+numOfApple);
		System.out.println("[구매자]현재잔액:"+myMoney);
	}
}
