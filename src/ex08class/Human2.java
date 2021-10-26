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

public class Human2 {

	String name;
	int age;
	int energy;
	
	void walking() {
		energy-= 1;
		if(energy<0) {
			energy = 0;
			System.out.println("에너지는 0이 최소값입니다.");
			System.out.println("캐릭터 사망;");
		}
		else {
			System.out.println("-walking 에너지 1 감소");
		}
	}
	void thinking() {
		energy-= 2;
		if(energy<0) {
			energy = 0;
			System.out.println("에너지는 0이 최소값입니다.");
			System.out.println("캐릭터 사망;");
		}
		else {
			
			System.out.println("-thinking 에너지 2 감소");
		}
	}
	void eating() {
		energy+= 2;
		if(energy>10) {
			energy = 10;
			System.out.println("에너지는 10을 넘을 수 없습니다.");
		}
		else {
			System.out.println("-eating 에너지 2 증가");
		}
	}
	void showNow() {
		System.out.println("================");
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("에너지: "+energy);
		System.out.println("================");
	}

}
