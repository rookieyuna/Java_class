package ex17collection;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/*
문제 17-1]사용자로부터 이름을 입력받아 그 이름으로 검색해서 
인덱스 위치(indexOf사용)를 알아내서 해당 인덱스로 그 객체를 
삭제하고 삭제된 객체의 정보(이름,나이,학번)를 출력하여라.
 */

class Student 
{
	String name;
	int age;
	String stNumber;
	public Student(String name, int age, String stNumber)
	{
		this.name = name;
		this.age = age;
		this.stNumber = stNumber;
	}

	public String getName()
	{
		return name;
	}
	public void showInfo()
	{
		System.out.printf("이름:%s, 나이:%d, 학번:%s\n", name, age, stNumber);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(age, name, stNumber);
	}
	@Override
	public boolean equals(Object obj)
	{
		Student other = (Student) obj;
		System.out.println("오버라이딩한 equals()메서드 호출됨:"+other.getName());
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(stNumber, other.stNumber);
	}

	@Override
	public String toString() {
		return "Student [이름=" + name + ", 나이=" + age + ", 학번=" + stNumber + "]";
	}
	
	
}
public class QuArrayList
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		
		//저장할 객체 생성
		Student st1 = new Student("가길동", 10, "2018");
		Student st2 = new Student("나길동", 20, "2017");
		Student st3 = new Student("다길동", 30, "2016");
		Student st4 = new Student("마길동", 40, "2015");
		
		//객체 추가(컬렉션에 저장)
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
			
		//1.검색할 이름을 입력받음
		System.out.print("검색할 이름을 입력하세요: ");
		String searchName = scan.nextLine();
		int index = -1;
		//2.확장for문으로 컬렉션 전체를 접근
		for(Student str : list) {
			if(searchName.equals(str.getName())) {
				index = list.indexOf(str);
			}
		}
		//3.검색결과 있을때 해당 데이터 삭제 (없으면 없다고 출력)
		if(index!=-1) {
			System.out.println("[검색되었습니다]");
			System.out.println("[삭제 후 정보출력]");
			list.remove(index).showInfo();
			/*
			컬렉션에 저장된 객체를 인덱스를 통해 삭제하면
			삭제된 객체 자체를 반환하므로 멤버메서드를 바로 호출가능
			 */
		}
		else {
			System.out.println("[검색정보가 없습니다]");
		}
		//4.전체정보 출력
		for(Student str : list) {
			str.showInfo();
			System.out.println(str);
			//참조주소값이 나오게 되지만 올바른 출력하려면 toString() 오버라이딩 
		}
	}	
}
