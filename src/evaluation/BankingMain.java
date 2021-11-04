package evaluation;

class Banking {   
    String name;
    String accountNumber;
    int balance;
	public Banking(String name, String accountNumber, int balance)
	{
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void deposit(int money) {
		balance += money;
		System.out.printf("%d원이 입금됨\n", money);
	}
     
	public void withdraw(int money) {
		if(balance>=money) {
			balance-=money;
			System.out.printf("계좌에서 %d원이 출금됨\n", money);
		}
		else {
			System.out.println("잔고부족!! 출금이 불가합니다."); 
		}
	}
	public void showAccount() {
		System.out.println("계좌주:"+ name);
		System.out.println("계좌번호:"+ accountNumber);
		System.out.println("잔고:"+ balance);
	}
    
}
public class BankingMain {
    public static void main(String[] args) {
        Banking banking = new Banking("장동건", "123-45-67890", 10000);
        banking.deposit(5000);
        banking.withdraw(9000);
        banking.showAccount();
    }
}
