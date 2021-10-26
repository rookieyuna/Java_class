package ex17collection;

import java.util.HashSet;

import common.Student;

public class Ex04HashSet2
{

	public static void main(String[] args)
	{
		/*
		아래의 경우 s3과 s3Copy는 Student 클래스에 오버라이딩된 
		hashCode(), equals()메서드를 통해 hash값 비교, 멤버변수간의 비교가 되어
		중복등록에 실패하게 된다.
		(Student 클래스에서 학번으로만 비교했기에 이름이 달라져도 등록불가)
		 */
		HashSet<Student> hashSet = new HashSet<Student>();
		
		Student s1 = new Student("정우성", 40, "2000-01");
		Student s2 = new Student("송강호", 42, "2000-02");
		Student s3 = new Student("이병헌", 44, "2000-04");
		
		hashSet.add(s1);
		hashSet.add(s2);
		hashSet.add(s3);
		
		System.out.println("hashSet의 크기: "+ hashSet.size());
		
		Student s3Copy = new Student("병헌", 44, "2000-04");
		System.out.println("s3Copy저장여부:" +hashSet.add(s3Copy));
		System.out.println("hashSet의 크기: "+ hashSet.size());
	}

}
