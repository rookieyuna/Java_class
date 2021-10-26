package ex17collection;

import java.util.Iterator;
import java.util.LinkedList;

import common.Student;

public class Ex03ArrayList2
{
	public static void main(String[] args)
	{
		/*
		아래  2개의 컬렉션은 내부적인 자료구조만 다를 뿐 ,
		구현방법은 완전히 동일하다
		컬렉션 생상시 Student형의 타입매개변수를 사용한다.
		 */
		LinkedList<Student> list2 = new LinkedList<Student>();
		//ArrayList<Student> list2 = new ArrayList<Student>();
		
		//개발자가 정의한 인스턴스 생성(외부패키지에 정의함)
		Student st1 = new Student("정우성", 10, "2018");
		Student st2 = new Student("원빈", 20, "2017");
		Student st3 = new Student("장동건", 30, "2016");
		Student st4 = new Student("공유", 40, "2015");
		
		//컬렉션에 인스턴스 저장
		list2.add(st1);//인덱스0
		list2.add(st2);
		list2.add(st3);
		list2.add(st4);//인덱스4
		list2.add(st2);//리스트이므로 중복저장가능
		
		System.out.println("\n[중복저장후]");
		for(Student st :list2) {
			st.showInfo();
		}
		
		//객체삭제: 인덱스가 아닌 객체의 참조값을 통해 삭제하면 앞에서부터 삭제됨 
		list2.remove(st2);
		System.out.println("\n[중복 저장된 객체 삭체후]");
		for(Student st :list2) {
			st.showInfo();
		}
		
		System.out.println("\n[Iterator 사용]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
			//Student student = it2.next();
			//student.showInfo();
			//위 두줄의 코드를 아래 1줄로 줄일 수 있다.
			it2.next().showInfo();
		}
		
		//List계열의 컬렉션은 인덱스로 접근 가능함
		System.out.println("\n[일반 for문 사용]");
		for(int i=0; i<list2.size(); i++) {
			list2.get(i).showInfo();
		}
		
		System.out.println("\n[확장 for문 사용]");
		for(Student st :list2) {
			st.showInfo();
		}
		
		/*
		Student 의 멤버변수가 private로 선언되어 직접 접근할 수 없고
		getter메서드를 통해서 접근할 수 있다.
		-remove()메서드는 인덱스를 통해 삭제에 성공할 경우 객체값 반환하나
		객체의 참조값을 통해 삭제할경우 true/false 반환 (오버로딩 되어있음)
		 */
		
		//인덱스를 통한 삭제 (삭제시 객체 반환)
		System.out.println("\n삭제된 객체의 이름: "+ list2.remove(2).getName());
		//인스턴스 참조값을 통한 삭제 (boolean 값 반환)
		System.out.println("인스턴스를 통한 삭제:" +list2.remove(st1));
		
		System.out.println("\n[인스턴스 삭제 후]");
		for(Student st :list2) {
			st.showInfo();
		}
	}
}
