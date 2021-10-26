package ex17collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

/*
문제17-2] 컬렉션 set에 저장된 객체를 이름으로 검색하자. 
해당 정보가 있으면 해당 어벤져스의 정보를 출력하고 없으면 "해당 영웅은 없어요ㅠ"
라는 메시지 출력해야 한다. 검색 부분은 Iterator를 통해 구현하도록 한다.
set계열의 컬렉션은 기본적으로 중복저장을 허용하지 않는다. 
그러나 아래와 같이 새롭게 정의한 클래스에 대해서는 equals(), hashCode() 
메소드를 적절히 오버라이딩 처리해야 중복을 제거할 수 있다. 
메소드 오버라이딩을 통해 hero4 는 입력되지 않도록 Avengers 클래스를 업데이트해라

 */
class Avengers {
	private String name;
	private String heroName;
	private String weapon;

	public Avengers(String name, String heroName, String weapon) {
		super();
		this.name = name;
		this.heroName = heroName;
		this.weapon = weapon;
	}
	
	public String getName()	{
		return name;
	}

	@Override
	public String toString() {
		return "Avengers [본명=" + name + ", 닉네임=" + heroName + ", "
				+ "능력=" + weapon +"]";
	}

	@Override
	public int hashCode() //객체가 가진 주소를 정수타입으로 반환
	{
		//각 멤버변수의 hashCode값을 얻음. 반환타입은 정수형
		int NameHash = this.name.hashCode();
		int heroHash = this.heroName.hashCode();
		int weaponHash = this.weapon.hashCode();
		System.out.println("hashCode()호출됨"+NameHash);
		//멤버변수가 2개이상이면 고유주소값을 더해서 고유값 만들기
		return NameHash + heroHash + weaponHash; 
	}

	@Override
	public boolean equals(Object obj)
	{
		System.out.println("equals()호출됨");
		//매개변수로 전달된 객체는 Object로 업캐스팅 되었으므로 다운캐스팅해줌.
		Avengers avengers = (Avengers)obj;
		
		if(this.name.equals(avengers.name)&&
				this.heroName.equals(avengers.heroName) &&
				this.weapon.equals(avengers.weapon)) {
			return true; //값이 동일할 때 true반환
		}
		else {
			return false;
		}
	}
}

public class QuHashSet {

	public static void main(String[] args) {

		HashSet<Avengers> set = new HashSet<Avengers>();
		Scanner scan = new Scanner(System.in);

		Avengers hero1 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		Avengers hero2 = new Avengers("스티브로져스", "캡틴아메리카", "비브라늄 방패");
		Avengers hero3 = new Avengers("브루스배너", "헐크", "강한피부&점프");
		Avengers hero4 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		
		set.add(hero1);
		set.add(hero2);
		set.add(hero3);
		set.add(hero4);		 

		System.out.println("[최초 전체 정보출력]");
		for(Avengers av : set)
		{
			System.out.println(av.toString());			
		}
		
		//이름으로 검색하기 - Iterator 활용
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		boolean jdg = false;//정보검색 성공여부 확인변수
		
		Iterator<Avengers> itr = set.iterator();//객체생성
		while(itr.hasNext()) {
			Avengers avg = itr.next();
			if(searchName.equals(avg.getName())) {
				System.out.println(avg);
				jdg = true;
			}
		}
		if(jdg==false) {
			System.out.println("해당영웅은 없어요 ㅠㅠ");
		}
	}
}
