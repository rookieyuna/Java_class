package ex12inheritance;

class Bank {
	private int myMoney;
	
	public Bank (int myMoney) {
		this.myMoney = myMoney;
	}
	
	void deposit (int newMoney) {
		if(newMoney<0) {
			System.out.println("마이너스 입금 불가");
			return;
		}
		this.myMoney += newMoney;
		System.out.println("*"+newMoney+"입금");
	}
	
	int showBal() {
		return myMoney;
	}
}

class SaveAccount extends Bank {
	
	public SaveAccount(int money) {
		super(money);
	}
	
	void plusMoney(int newMoney) {
		super.deposit(newMoney);
	}
	
	void showAccoutMoney() {
		System.out.println("잔액"+ super.showBal());
	}
}


public class PriavateBank {

	public static void main(String[] args) {

		SaveAccount sa = new SaveAccount(10000);
		sa.showAccoutMoney();
		
		sa.plusMoney(5000);
		sa.showAccoutMoney();
		
		sa.plusMoney(-1000);
		sa.showAccoutMoney();

	}

}
