package ex17collection;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import common.Teacher;

/*
HashSet<E> 컬렉션
	: Set계열의 인터페이스를 구현한 컬렉션
	- 객체가 순서 없이 저장됨
	- 객체의 중복저장을 허용하지 않음
	(단, 기본클래스는 자동으로 중복을 방지하나 개발자가 정의한 클래스일 경우
	hashCode(), equals()를 적절히 오버라이딩하여 정의하면 중복저장방지 가능)
	-List가 배열의 성격이라면 Set은 집합의 성격을 가짐
 */
public class Ex04HashSet1
{
	public static void main(String[] args)
	{
		/*
		1] set컬렉션 생성 (Object 타입으로 설정)
		 */
		HashSet<Object> set = new HashSet<Object>();
		
		/*
		2] 다양한 객체 생성
		 */
		String strObject1  = "JAVA";
		String strObject2  = new String("KOSMO99기");
		Date dateObject = new Date();
		//변수인 int는 Object가 될수 없고 객체여야 HashSet에 들어가지만 자동으로 Integer 랩핑됨
		int number = 100; 
		Teacher teacher = new Teacher("김봉두", 55, "체육");
		
		/*
		3] 객체저장
			: add()메서드를 통해 저장되고 문제가 없다면 true 반환
		 */
		System.out.println(set.add(strObject1));//true반환
		set.add(strObject2);
		System.out.println(set.add(strObject2));//false반환
		set.add(dateObject);
		set.add(number);
		set.add(teacher);
		
		/*
		4] 저장된 객체수 얻기
		 */
		System.out.println("[중복저장전 객체수]: "+set.size()); //5개 출력
		
		/*
		5-1] 기본 클래스형 객체 중복저장
			: 기본클래스의 경우 별도의 오버라이딩 안해도 중복 자료 받지 않음
		 */
		System.out.println(set.add(strObject2)? "저장성공": "저장실패");
		System.out.println("[중복저장(String)후 객체수]: "+set.size());//5개 출력
		
		/*
		5-2] 개발자가 정의한 객체 중복저장
			: 사용자정의 클래스의 경우 내용이 동일해도 중복저장된다.
			hashCode, equals메서드를 오버라이딩하여 중복을 방지해야한다.
		 */
		Teacher teacher2 = new Teacher("김봉두", 55, "체육");
		System.out.println(set.add(teacher2)? "저장성공": "저장실패");//성공
		System.out.println("[중복저장(teacher2)후 객체수]: "+set.size());//6개 출력
		
		/*
		6] 저장된 객체 출력
			:Iterator를 통한 객체 출력, 순서없이 저장되므로 출력순서 정할 수 없음
		 */
		Iterator itr = set.iterator();//이터레이터 객체 생성 및 준비
		while(itr.hasNext()) {//추출할 객체가 있는지 확인 후
			Object object = itr.next();//추출 고고
			
			/*
			Set에 저장된 모든 객체는 Object형으로 업캐스팅되므로
			다운시에는 다운캐스팅하는 것이 좋다.
			 */
			if(object instanceof String) {
				System.out.println("String타입: "+ object);
			}
			else if(object instanceof Date) {
				System.out.println("Date타입: "+ object);
			}
			else if(object instanceof Integer) {
				System.out.println("Integer타입: "+ object);
			}
			else if(object instanceof Teacher) {
				System.out.println("Teacher타입: "+ ((Teacher)object).getInfo());
			}
			else {
				System.out.println("누구냐 넌?");
			}
		}////end of while
		
		/*
		7] 검색(존재여부확인 true)
		 */
		System.out.println(set.contains(strObject1)? "strObject1있음":"strObject1없음");
		System.out.println(set.contains("JaVa")? "JaVa있음":"JaVa없음");
		
		/*
		8] 일부삭제
			: Set은 인덱스가 없으므로 객체의 참조값을 통해서만 삭제 가능
		 */
		System.out.println(set.remove(strObject2)? "strObject2삭제":"strObject2삭제실패");
		System.out.println(set.remove("Android")? "Android삭제":"Android삭제실패");
		System.out.println("[삭제 후 객체 수]" + set.size());
		
		/*
		8] 전체삭제
		 */
		//set.clear();
		System.out.println("전체삭제"+set.remove(set));
		System.out.println("[전체삭제 후 객체 수]" + set.size());
	}

}
