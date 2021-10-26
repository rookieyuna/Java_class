package bokang.sub;

/*
체크카드 클래스 Ver.01

시나리오] 체크카드를 클래스로 표현해보자.
	멤버변수 : 카드번호, 소유자, 잔액, 포인트
	멤버메소드 : 충전(입금), 결제, 적립, 현재상태출력
	적립율 : 사용금액의 0.1%	
*/

public class CheckCard1
{
	//멤버변수
	public long cardNumber;//카드번호
	public String owner; //소유자
	public int balance; //잔액
	public int point; // 포인트
	
	//멤버메서드
	//충전(입금)
	public void charge(int amount) {
		//현재 잔고에 충전할 금액 amount원 추가
		this.balance += amount;
	}
	
	//결제
	public void payment (int amount) {
		if (this.balance<amount) {
			System.out.println("※한도초과로 결제실패");
		}
		else {
			this.balance -= amount;
			savingPoint(amount);
			System.out.println(amount+"원 결제완료");
			}
		//체크카드 사용시 적립금이 발생되므로 호출한다.
		
	}
	
	//적립
	public void savingPoint(int amount) {
		this.point += (amount*0.1);
		/*
		복합대입 연산자의 특성상 자료형은 항상 좌측항을 따른다.
		따라서 형변환으로 인한 에러가 발생하지 않는다. 하지만,
		this.point = this.point+(amount*0.1); 는 오류가 발생한다.
		 */
		
	}
	
	//현재상태출력
	public void showState() {
		System.out.println("######카드정보######");
		System.out.println("카드번호:"+ cardNumber);
		System.out.println("소유자:"+ owner);
		System.out.println("잔액:"+ balance);
		System.out.println("현재포인트:"+ point);
	}
}

