package ex12inheritance;

import java.util.Scanner;
/*
친구를 표현한 최상위 클래스.
해당프로그램에서는 Friend클래스로 객체생성은 하지 않을 것
상속의 목적으로만 정의된 클래스
 */
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
	/*
	간략정보를 출력하는 용도의 멤버메서드로 실행부가 없음
	오버라이딩이 가능하려면 부모클래스에서 우선 정의되어야
	하기 때문에 내용없이 정의된 상태. 
	 */
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
	/*
	고딩친구의 전체정보를 출력하기 위해 부모에서 정의된
	메서드를 오버라이딩하여 super를 통해 출력하고 별도로
	확장된 변수를 출력
	 */
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+nickname);
	}
	/*
	자식에서 부모메서드 오버라이딩한 뒤 호출하여 확장
	 */
	@Override
	public void showBasicInfo()
	{
		System.out.println("==고딩친구==");
		System.out.println("별명:"+nickname);
		System.out.println("전번:"+phone);
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

public class E10MyFriendInfoBook
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
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
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


/*
프로그램에서 기능을 담당하는 클래스를 핸들러 혹은 매니저라고 함
 */
class FriendInfoHandler {
	
	//멤버변수
	//친구정보 저장할 Friend타입 객채배열 선언
	private Friend[] myFriends;
	//실제 저장된 연락처 개수
	private int numOfFriends;
	
	public FriendInfoHandler(int num) {
		//num크기의 객체배열 생성
		myFriends = new Friend[num];
		numOfFriends = 0;
	}
	
	//새로운 친구 입력 (choice가 1이면 고딩, 2면 대딩추가)
	public void addFriend(int choice) {
		
		//정보입력을 위한 객체생성
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		/*
		1. 친구정보를 입력받은후
		2. 객체배열의 0번방에 객체를 저장하고
		3. numOfFriends를 1 증가시킨다(후위증가)
		 */
		if(choice==1) {
			System.out.print("별명:"); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends[numOfFriends++] = high;
		}
		else if(choice==2) {
			System.out.print("전공:"); iMajor = scan.nextLine();
			myFriends[numOfFriends++] = new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
		
		System.out.println("친구정보 입력이 완료되었습니다.");
	}////end of addFriend
	
	
	/*
	<친구의 정보를 출력하기 위한 멤버메서드>
	1. 친구정보를 추가할 때  High 또는 Univ 객체가 배열에 저장된다.
	2. 입력시 모든 객체는 Friend로 자동 형변환되어 저장된다.
	3. 정보 출력 시 배열에 입력된 객체수만 큼 반복하면서 각 요소를
		통해 멤버메서드를 호출한다.
	4. 이때 오버라이딩 된 메서드를 통해 항상 해당 객체의 정보를
		출력할 수 있다. 참조변수의 타입에 영향을 받지 않고 항상
		오버라이딩된 최하위 메소드가 호출되기 때문이다.
	 */
	//친구정보 전체보기 출력 메서드
	public void showAllData() {
		for(int i=0; i<numOfFriends; i++) {
			myFriends[i].showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다.==");
	}
	
	//친구정보 간략보기 출력 메서드
	public void showSimpleData() {
		for(int i=0; i<numOfFriends; i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다.==");
	}
	
	//친구정보 검색
	boolean isFind = false; //검색한 정보가 있는지 확인하기 위한 변수
	public void searchInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		for(int i=0; i<numOfFriends; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {
				//일치하는 이름이 있으면 정보를 출력
				myFriends[i].showAllData();
				System.out.println("**귀하가 요청한 정보를 찾았습니다.**");
				isFind = true;//찾는정보가 있다면 true로 변경
			}
		}
		
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다.***");
	}
	
	//친구정보 삭제 메서드
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		/*
		배열의 요소중 삭제된 요소의 인덱스 값을 저장할 용도의 변수
		요소를 삭제한 후 빈자리를 채워넣을 때 사용 할 것.
		배열은 0부터시작하는 인덱스이므로 초기값은 -1로설정한다.
		 */
		int deleteIndex = -1;
		
		for(int i=0; i<numOfFriends; i++) {
			//삭제할 이름이 있는지 검색
			if(deleteName.compareTo(myFriends[i].name)==0) {
				//해당 객체에 연결된 주소값을 삭제하기위해 null값으로 변경
				myFriends[i] = null;
				//삭제된 요소의 index 저장
				deleteIndex = i;
				numOfFriends--;
			}
		}
		if(deleteIndex == -1) {
			System.out.println("**삭제된 데이터가 없습니다.**");
		}
		else {
			/*
			객체배열에서 검색된 요소를 삭제한 후 입력된 위치의
			바로 뒤 요소를 앞으로 하나씩 이동시킨다.
			numOfFrined는 앞에서 1 차감되므로 마지막요소는 무시된다.
			 */
			for(int i=deleteIndex; i<numOfFriends; i++) {
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("==데이터("+deleteIndex+"번)가 삭제되었습니다.==");
		}
	}////end of deleteInfo
}//end of FriendInfoHandler