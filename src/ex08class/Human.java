package ex08class;

/*
시나리오]
다음에 주어진 조건으로 '사람'을 추상화 하시오
-속성 : 이름, 나이, 에너지
-행동 : 걷는다, 생각한다, 먹는다, 현재상태표현
-행동의 조건
	걸으면 에너지 1 감소
	생각하면 에너지 2 감소
	먹으면 에너지 2 증가
	단, 에너지의 범위는 0~10으로 한다.
	(무한히 먹을 수 없고 에너지는 마이너스가 될 수 없기 때문이다.)
 */

public class Human {

	//객체의 속성을 표현하는 멤버변수
	String name;
	int age;
	int energy;
	
	//행동을 표현하는 멤버 메소드
	// 1.'걷는다'를 표현
	void walking() {
		//에너지를 1 차감한 후 음수인지 확인하여 음수면 0으로 고정한다.
		energy--;
		if(energy<0) {
			energy = 0;
			System.out.println("[walking]에너지는 0이 최소입니다.");
			System.out.println("0으로 고정됩니다.");
		}
		else {
			System.out.println("[walking]에너지가 1 감소하였습니다.");	
		}
	}
	// 2.'생각하다'를 표현
	void thinking() {
		energy-= 2;
		if(energy<0) {
			energy = 0;
			System.out.println("[thinking]에너지는 0이 최소입니다.");
			System.out.println("0으로 고정됩니다.");
		}
		else {
			System.out.println("[thinking]에너지가 2 감소하였습니다.");	
		}
	}
	
	//3.'먹다'를 표현
	void eating() {
		//에너지를 2 증가시킨 후 10을 초과하면 10으로 고정한다.
		energy += 2;
		if(energy>10) {
			energy = 10;
			System.out.println("[eating]에너지는 10이 최대입니다.");
			System.out.println("0으로 고정됩니다.");
		}
		else {
			System.out.println("[eating]에너지가 2 증가하였습니다.");	
		}
	}
	
	//객체의 현재상태를 출력
	void showState() {
		System.out.println("===님의 현재 상태는===");
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("에너지:"+energy);
		System.out.println("======================");
		
	}
	
}
