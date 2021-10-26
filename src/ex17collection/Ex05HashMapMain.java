package ex17collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
HashMap<K,V>
	: Map<T> 인터페이스를 구현한 컬렉션 클래스
	- key, value의 쌍으로 객체를 저장한다.
	- 키 값 중복 불가. 중복으로 저장할 경우 기존의 데이터가 덮어써짐
	- 키값으로 검색하므로 다른컬렉션에 비해 속도가 빠르다.
 */

public class Ex05HashMapMain
{

	public static void main(String[] args)
	{
		//Map컬렉션 생성. key와 Value는 둘 다 String형으로 선언
		HashMap<String, String> map = new HashMap<String, String>();
		
		/*
		1] 객체저장
			: 객체저장 시 기존에 저장된 동일한 key값이 존재하면 
			이전에 저장된 객체가 반환된다. 만약 처음입력이라면 null값 반환.
		 */
		System.out.println("name 키값으로 저장된 이전의 값:"
				+ map.put("name", "홍길동")); //null값(저장되기 전의 값) 반환
		
		/*
		2] 다양한 객체 생성
		 */
		int number = 20;
		//map.put("age", number);//=> value타입 불일치로 에러발생
		map.put("age", String.valueOf(number));
		map.put("gender", "남자");
		map.put("address", "가산디지털단지");
		
		/*
		3. 객체 수 확인
		 */
		System.out.println("\n저장된 객체 수:"+map.size());
		
		/*
		4. 중복저장(덮어쓰기)
			: 기존에 입력된 동일한 key값 name에 새로운 값을 등록할 경우 
			value값이 대체된다.
		 */
		System.out.println("\nname 키값으로 저장된 이전의 값:"
				+ map.put("name", "최길동"));
		System.out.println("키값으로 중복 저장 후 객체 수:"+map.size());
		
		/*
		5. 출력
		 */
		//5-1]키값을 알고 있을 때 출력 : get(키값)메서드 이용
		System.out.println("키값을 알 때:"+ map.get("name"));//최길동 출력
		
		//5-2]키값을 모를 때 출력 : keySet()메서드를 호출하여 키값을 Set컬렉션으로 얻어옴
			//해당 반환값을 확장된for문으로 추출하고, 이를 통해 value를 얻어올 수 있다.
		Set<String> keys = map.keySet();
		System.out.println("\n[확장for문 적용]");
		for(String key : keys) {
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}
		
		//5-3]반복자를 통한 출력 : keySet()메서드를 호출하여 Set컬렉션에 저장한 뒤 반복자호출
		//※ Map계열의 컬렉션은 처음부터 확장된 for문을 쓸 수 없고 key값을 저장한 뒤 가능하다.
		System.out.println("\n[Iterator사용하기]");
		Set<String> keys2 = map.keySet();
		Iterator<String> it = keys2.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}
		
		//5-4] Value값만 얻어올 때 : values()메소드 호출하여 Collection에 저장한 뒤 추출
		System.out.println("\n[value값들만 출력하기]");
		Collection<String> values = map.values();
		for(String value : values) {
			System.out.println(value);
		}
		
		System.out.println();
		/*
		6. 존재유무판단
			: containsKey()/containsValue => 찾는 key혹은 value가 존재할 경우 true 반환
		 */
		System.out.println(map.containsKey("name")? "name키값있다":"name키값없다");
		System.out.println(map.containsKey("account")? "account키값있다":"account키값없다");
		System.out.println(map.containsValue("남자")? "남자 있다":"남자 없다");
		System.out.println(map.containsValue("여자")? "여자 있다":"여자 없다");
		
		System.out.println();
		/*
		7. 삭제 remove()
			: key값을 통해 삭제하고 삭제되면 해당 value 반환
		 */
		System.out.println("삭제된객체: "+map.remove("age"));
		System.out.println("[age키값을 삭제 후 출력]");
		for(String key : keys) {
			System.out.println(String.format("%s:%s", key, map.get(key)));
		}
		
		/*
		8. 전체삭제 : removeAll()은 없음
		 */
		map.clear();
		System.out.println("\n전체 삭제 후 객체 수:"+map.size());
		
	}

}
