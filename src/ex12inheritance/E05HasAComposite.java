package ex12inheritance;

/*
구성관계로 표현하기에 적합한 Has-A관계
	: X Has a Y ==> X가 Y를 소유(포함)하다
	-경찰이 권총을 소유하다
	
	Has-A와 같이 소유의 관계를 상속으로 표현하면 클래스간의 강한
	연결고리가 형성되어 권총이 없는 경찰을 표현하기가 힘들어진다.
	따라서 이 경우에는 구성관계로 표현하는 것이 적합하며, 구성관계란
	클래스의 멤버로 또 다른 객체를 사용하는 것을 말한다.
 */
class Gun {
	int bullet;
	public Gun(int bNum) {
		bullet = bNum;
	}
	public void shutGun() {
		System.out.println("빵!");
		bullet--;
	}
	public int bulletCnt() {
		return bullet;
	}
}

//경찰을 표현
class Police {
	
	int handCuffs; //수갑 보유개수
	Gun gun;//권총을 표현하기 위한 객체형 멤버변수
	
	public Police(int bNum, int hCuff) {
		handCuffs = hCuff;
		/*
		권총의 보유여부 초기화
			: 만약 총알이 없는 상태라면 보유한 권총이 없는 것으로
			표현하기 위해 멤버변수를 null로 초기화한다.
			참조변수가 null값이란것은 참조할 객체가 없다는 것을 의미.
			(즉, Heap영역에 생성된 객체가 없는 것을 말함)
		 */
		
		if(bNum<=0){
			gun = null;
		}
		else {
			gun = new Gun(bNum);
		}
	}
	//수갑을 채우는 행위를 표현
	public void putHandcuff() {
		System.out.println("수갑채우기~ 철컥");
		handCuffs--; //수갑개수 차감
	}
	//총을 쏘는 행위를 표현
	public void shut() {
		//경찰이 총을 보유하지 않았다면 발사 불가..
		if(gun==null) {
			System.out.println("보유한 총없음! ㅠㅠ");
		}
		//총을 보유하고 있으므로 Gun클래스의 멤버메서드를 호출
		else {
			gun.shutGun();
		}
	}
}
public class E05HasAComposite
{
	public static void main(String[] args)
	{
		//총을 보유한 경찰을 표현
		System.out.println("==경찰1==");
		Police police1 = new Police(5, 3);
		police1.shut();
		police1.putHandcuff();
		System.out.println("police1 총알 개수: "+police1.gun.bulletCnt()); //거꾸로타고가기
		System.out.println("police1 수갑 개수: "+police1.handCuffs);
		
		//총을 보유하지 않은 경찰을 표현
		System.out.println("==경찰2==");
		Police police2 = new Police(0, 3);
		police2.shut();
		police2.putHandcuff();
	}
}
