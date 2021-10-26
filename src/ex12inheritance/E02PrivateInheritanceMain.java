package ex12inheritance;

class Account {
	
	//멤버변수가 private로 선언되어 상속받은 하위클래스라도 접근불가 
	private int money; //잔고
	public Account(int init) {
		money = init;
	}
	
	//멤버메소드가 protected로 선언되어 하위클래스 및 동일패키지 내 접근가능
	protected void depositMoney(int _money) {
		if(_money<0) {
			System.out.println("마이너스 금액은 입금처리 불가");
			return;
		}
		money += _money;
	}
	
	//private로 선언된 멤버변수를 외부로 반환할 때 사용(=getter메서드)
	protected int getAccMoney() {
		return money;
	}
}

class SavingAccount extends Account {
	
	//하위클래스의 생성자에서 인자가 한개인 부모의 생성자 메서드를 호출
	public SavingAccount(int initVal) {
		super(initVal); 
	}
	
	//메서드를 통해 부모클래스의 protected 멤버메서드 호출
	public void saveMoney(int money) {
		depositMoney(money);
	}
	
	//private 변수 직접접근 불가 > public메서드(getAccMoney)를 통해 간접접근
	public void showAccoutMoney() {
		System.out.println("지금까지의 누적금액: "+ getAccMoney());
	}
}

public class E02PrivateInheritanceMain 
{
	public static void main(String[] args) 
	{
		//자식클래스를 통해 객체생성(부모객체의 생성이 자동으로 우선 실행)
		SavingAccount sa = new SavingAccount(10000);
		
		//sa.money = 100000;; //은닉된정보(not visible)에러 
		//하위라도 상위 private 변수 직접접근불가. 
		
		sa.saveMoney(5000);
		sa.showAccoutMoney();
		
		sa.saveMoney(-1000);
		sa.showAccoutMoney();
		
		Account account = new Account(1000);
		//account.money = 1000; //[접근불가 에러]
		//부모클래스의 참조변수를 통해서도 private 멤버는 접근불가
		//접근하려는 위치가 Account 클래스 외부이기 때문
		sa.depositMoney(3000);
		sa.showAccoutMoney();
	}

}
