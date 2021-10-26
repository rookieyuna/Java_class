package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/*
ArrayList<E> : List 계열의 컬렉션
- 데이터의 저장 순서를 보장한다(index)
- 데이터의 중복 저장이 허용된다.
- 데이터 접근시 get() 혹은 iterator()를 활용한다.
- Array라는 이름처럼 '배열'의 특성을 가지고 있어, index를 통한 저장 및 접근 가능
 */
public class Ex03ArrayList1
{

	public static void main(String[] args)
	{
		/*
		String 객체를 저장하기 위한 List 컬렉션을 생성한다.
		 */
		ArrayList<String> list = new ArrayList<String>();
		//LinkedList<String> list = new LinkedList<String>();
		//Stack<String> list = new Stack<String>();
		//Vector<String> list = new Vector<String>();
		
		/*
		1-1] 객체저장
			add(객체) : 순차적으로 저장하면서 인덱스는 0부터 자동부여
			add(인덱스, 객체) : 인덱스를 지정하여 직접 저장. 단 건너뛰면 에러발생
			size() : 컬렉션에 저장된 객체의 수 반환메서드
		 */
		list.add("소녀시대");//인덱스0
		list.add("슈퍼주니어");//인덱스1
		list.add("샤이니");
		list.add(3, "워너원"); //인덱스 지정 가능
		//list.add(5, "소방차ㅎ"); //인덱스 건너뛰면 런타임 에러발생
		list.add(list.size(), "오마이걸");
		list.add(list.size(), "방탄소년단");
		System.out.println("중복저장 전 객체 수:"+list.size());//6개 출력
		
		/*
		1-2] 중복저장
			: List는 배열의 속성을 가지므로 데이터의 중복저장 허용.
			tip. add()메서드는 추가에 성공한 경우 true를 반환함.
		 */
		System.out.println(list.add("워너원")? "중복저장됨":"중복저장안됨");
		System.out.println("중복저장 전 객체 수:"+list.size());
		
		/*
		1-3] 리스트 컬렉션 출력하기(for, 확장for문)
			: 컬렉션을 다룰 때는 주로 확장 for문을 사용
			get(index) : 인덱스에 해당하는 객체를 반환함.
		 */
		System.out.println("\n[일반for문 사용]"); //인덱션 통해 컬렉션에 접근
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
		
		System.out.println("\n[확장for문 사용]"); //인덱스 없이 바로 객체 접근
		for(Object obj : list) {
			System.out.print(obj+ " ");
		}
		
		/*
		Iterator(반복) 사용법
		1. 컬렉션에 저장된 내용을 Iterator에게 알려주기 위해 객체 생성
		2. hasNext()로 반환할 객체가 있는지 확인하고, next()로 객체 반환
		3. 모든 객체가 반환되었다면 hasNext()는 false를 반환하여 while문 종료
		
		 */
		System.out.println("\n[반복자(Iterator) 사용]");
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println("\n======================\n");
		
		/*
		1-4] 중복저장
			: 기존객체의 내용을 삭제하고 새로운 내용으로 변경한다.
			삭제할 객체의 인덱스 값을 입력해야함! 
			set(index, "뉴객체")
		 */
		list.set(4, "오마이걸>덮어쓰기");
		for(Object obj : list) {
			System.out.print(obj+ " ");
		}
		System.out.println("\n======================\n");
		
		/*
		1-5] 끼워넣기
			: 이미 존재하는 객체들 사이에 새로운 내용을 삽입한다.
			입력한 인덱스 뒤의 기존데이터는 자동으로 뒤로 밀린다.
			add(인덱스, "뉴객체") 
		 */
		list.add(4, "블랙핑크>끼워넣기");
		for(Object obj : list) {
			System.out.println(obj+ " ");
		}
		System.out.println("\n======================\n");
		
		/*
		1-6] 포함여부 확인
			: 컬렉션에 찾고자 하는 객체가 있는지 확인. 인덱스정보는 알 수 없음
			만약 포함되어 있다면 true를 반환한다.(완전일치해야함)
			contains("찾는객체")
		 */
		System.out.println(list.contains("샤이니")? "샤이니 있음":"샤이니 없음");
		System.out.println(list.contains("블랙핑크")? "블핑 있음":"블핑 없음");
		System.out.println("\n======================\n");
		
		/*
		1-7] 삭제
		 */
		//방법1: 인덱스를 지정하여 삭제한다 remove(index).
		//삭제 후 해당 객체를 반환하므로 확인 가능하며, 인덱스가 자동으로 재정렬된다.
		Object obj = list.remove(2);
		System.out.println("삭제된객체: "+ obj);
		
		//방법2: 삭제하려는 객체의 인덱스를 모를 경우 remove(indexOf("객체"))
		//indexOf("객체")메서드로 인덱스를 확인 한 후 삭제한다.
		int index = list.indexOf("소녀시대");
		System.out.println("소녀시대 index" + index);
		list.remove(index);
		
		//방법3: 객체의 참조값을 통해 직접 삭제한다. remove("객체") 
		System.out.println(list.remove("방탄소년단")? "BTS삭제성공":"BTS삭제실패");
		//삭제할 객체가 없더라도 에러가 발생하지 않음
		System.out.println(list.remove("오마이걸")? "OMG삭제성공":"OMG삭제실패");
		
		System.out.println("==일부 삭제 후 출력==");
		for(Object ob : list) {
			System.out.print(ob+ " ");
		}
		System.out.println("\n");
		
		/*
		1-8] 전체삭제
			: 두가지 메서드를 통해 전체 삭제 가능
		 */
		list.removeAll(list);
		list.clear();
		System.out.println("전체삭제후 객체수: "+list.size());
		
	}

}