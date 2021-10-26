package ex09package.kosmo.seller;

public class FruitSeller3
{
	int numOfApple;//판매자가 보유한 사과개수
	int myMoney;//판매수익
	final int APPLE_PRICE; //사과의 단가

	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	
	//멤버메서드
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은 사과 갯수:"+numOfApple);
		System.out.println("[판매자]판매수익:"+myMoney);
	}
	
}
