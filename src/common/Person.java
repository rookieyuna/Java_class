package common;

import java.util.Objects;

public class Person
{	
	//멤버변수
	private String name;
	private int age;
	//생성자
	public Person(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	//getter/setter
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	//멤버메서드
	public String getInfo() {
		//해당객체의 정보를 문자열로 반환
		return String.format("이름:%s, 나이:%d", name, age);
	}
	public void showInfo() {
		//문자열로 반환된 정보를 출력
		System.out.println(getInfo());
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	
	
}
