package ex13interface;
/*
추상클래스를 인터페이스로 변경하기
	abstract class => interface
	-멤버변수인 경우 public static final 제거
	-메서드인경우 public abstract 제거
	
 */
interface IPersonalNumberStroage {
	void addPersonalInfo(String juminNum, String name);
	String searchPersonalInfo(String juminNum);
}

/*
DTO에서 VO로 명칭만 변경
 */
class PersonInfoVO {
	//멤버변수
	private String name;
	private String juminNum;
	//생성자
	public PersonInfoVO(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}
	
	public String getName()	{return name;}
	public String getJuminNum() {return juminNum;}	
	public void setName(String name) {this.name = name;}
	public void setJuminNum(String juminNum) {this.juminNum=juminNum;}
}
/*
클래스가 클래스를 상속할 때 = extends
클래스가 인터페이스를 상속할 때 = implements
드물지만 인터페이스가 인터페이스를 상속할 때 = extends

extends는 '상속', implements는 '구현'이라 표현한다.
 */
class PersonalNumberStroageImpl implements IPersonalNumberStroage {

	PersonInfoVO[] personalArr; //정보저장용 객체배열
	int numOfPerInfo; //입력정보 카운트용 변수
	//생성자
	public PersonalNumberStroageImpl(int arrSize) {
		personalArr = new PersonInfoVO[arrSize];
		numOfPerInfo = 0;
	}
	
	
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] = new PersonInfoVO(name, juminNum);
		numOfPerInfo++;
	}
	
	//주민등록번호를 인자로 객체배열을 검색한 후 정보를 반환한다.
	@Override
	public String searchPersonalInfo(String juminNum) {
		for(int i=0; i<numOfPerInfo; i++) {
			
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0) {
				//getter를 통해 이름을 반환한다.
				return personalArr[i].getName();
			}
		}
		return null;//검색결과가 없는 경우 null반환
	}
}

public class E02AbstractToInterface2
{
	public static void main(String[] args)
	{
		//10명의 정보를 저장할 수 있는 객체배열 생성
		PersonalNumberStroageImpl storage = new PersonalNumberStroageImpl(10);
		
		//정보저장
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("009876-1010101"));
	}
}
