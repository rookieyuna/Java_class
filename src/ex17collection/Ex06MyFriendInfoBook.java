package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Friend {
	//멤버변수
	String name; 	//이름
	String phone; 	//전화번호
	String addr; 	//주소
	//생성자
	public Friend(String name, String phone, String addr) {
		super();
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	//멤버변수 전체정보출력용 멤버메서드
	public void showAllData() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phone);
		System.out.println("주소:"+addr);
	}

	public void showBasicInfo() {}
}

//고딩친구 클래스
class HighFriend extends Friend {
	//확장한 멤버변수
	String nickname; //별명
	
	public HighFriend(String name, String phone, String addr, 
			String nickname) {
		//부모클래스의 생성자 호출
		super(name,phone,addr);
		//자신의 멤버변수 초기화
		this.nickname = nickname;
	}

	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+nickname);
	}

	@Override
	public void showBasicInfo()
	{
		System.out.println("==고딩친구==");
		System.out.println("별명:"+nickname);
		System.out.println("전화번호:"+phone);
	}
}

//대딩친구 클래스
class UnivFriend extends Friend {
	String major;
	
	public UnivFriend(String name, String phone, String addr, 
			String major) {
		super(name,phone,addr);
		this.major = major;
	}
	
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공:"+major);
	}
	
	@Override
	public void showBasicInfo()
	{
		System.out.println("==대딩친구==");
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phone);
	}
}

public class Ex06MyFriendInfoBook
{
	public static void menuShow() {
		System.out.println("##### 메뉴를 입력하세요 #####");
		System.out.print("1.고딩친구입력 ");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력 ");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색 ");
		System.out.print("6.삭제 ");
		System.out.println("7.프로그램 종료");
		System.out.print("메뉴선택>>>>>");
	}
	
	public static void main(String[] args) {
		
		//기능을 담당하는 핸들러 클래스의 객체생성
		//초기값으로 100명의 정보를 저장할수 있는 객체배열
		FriendInfoHandler handler = new FriendInfoHandler();
		
		Scanner scan = new Scanner(System.in);
		//무한루프 조건으로 특정입력에만 종료할 수 있는 구조!
		while(true) {
			menuShow();
			
			int choice = scan.nextInt();
			switch(choice) {
			case 1: case 2: //친구정보입력
				handler.addFriend(choice);
				break;
			case 3: //전체정보출력
				handler.showAllData();
				break;
			case 4: //간략정보출력
				handler.showSimpleData();
				break;
			case 5://정보 검색
				handler.searchInfo();
				break;
			case 6://정보 삭제
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				return;//main 메서드의 종료 = 프로그램 자체 종료
			}////switch 끝
		}////while 끝
	}///main 끝
}//class 끝


class FriendInfoHandler {
	
	//친구의 정보를 저장할 List컬렉션 생성
	ArrayList<Friend> lists;
	
	public FriendInfoHandler() {
		lists = new ArrayList<Friend>();
	}
	
	//새로운 친구 입력 (choice가 1이면 고딩, 2면 대딩추가)
	public void addFriend(int choice) {
		
		//정보입력을 위한 객체생성
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		if(choice==1) { //고딩친구 객체 만든 후 컬렉션에 add
			System.out.print("별명:"); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			lists.add(high);
		}
		else if(choice==2) {//대딩친구 객체 생성과 동시에 컬렉션에 add
			System.out.print("전공:"); iMajor = scan.nextLine();
			lists.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		
		System.out.println("친구정보 입력이 완료되었습니다.");
	}////end of addFriend
	
	public void showAllData() {
		//일반for문
		for(int i=0; i<lists.size(); i++) {
			lists.get(i).showAllData();
		}
		//확장for문
		for(Friend frd:lists) {
			frd.showAllData();
		}
		//Iterator문
		Iterator<Friend> it = lists.iterator();
		while(it.hasNext()) {
			it.next().showAllData();			
		}
		
		System.out.println("==전체정보가 출력되었습니다.==");
	}
	
	//친구정보 간략보기 출력 메서드
	public void showSimpleData() {
		for(Friend frd:lists) {
			frd.showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다.==");
	}
	
	//친구정보 검색
	boolean isFind = false; //검색한 정보가 있는지 확인하기 위한 변수
	public void searchInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		for(Friend frd:lists) {
			if(searchName.equals(frd.name)) {
				//일치하는 이름이 있으면 정보를 출력
				frd.showAllData();
				System.out.println("==귀하가 요청한 정보를 찾았습니다.==");
				isFind = true;//찾는정보가 있다면 true로 변경
			}
		}
		//Iterator 이용하여 검색
		/*
		이터레이터 사용방법
		1. 컬렉션의 참조변수를 기반응로 이터레이터 객체 생성
		2. 조건으로 hasNext()를 통해 다음 출력요소가 있는지 검사
		3. true를 반환하면 next()로 반환
		(단, while문 내에서 next()를 두번 호출하면 다다음 것이 출력됨..주의)
		 */
		Iterator<Friend> it = lists.iterator();
		while(it.hasNext()) {
			//next()를 두번쓰면 출력이 잘못되므로 하나의 변수로 생성!
			Friend fr = it.next();
			if(searchName.equals(fr.name))
			fr.showAllData();
		}
		
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다.***");
	}
	
	//친구정보 삭제 메서드
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		boolean jdg = false; //삭제여부 확인용 변수
		
		for(Friend frd:lists) {
			if(deleteName.equals(frd.name)) {
				lists.remove(frd);
				jdg = true;
				System.out.println("==데이터가 삭제되었습니다.==");
				break;
			}
		}
		if(jdg==false) {
			System.out.println("**삭제될 데이터가 없습니다.**");
		}
	}////end of deleteInfo
}//end of FriendInfoHandler