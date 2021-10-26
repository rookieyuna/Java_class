package ex12inheritance;

import java.util.Scanner;

class Friends {
	String name;
	String phone;
	String addr;
	
	public Friends(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

	public void showAlData() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phone);
		System.out.println("주소: "+ addr);
	}
	
	public void showSimpleData() {}
}

class HighFriends extends Friends {
	String nickname;
	
	public HighFriends(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	
	@Override
	public void showAlData() {
		System.out.println("===고딩친구===");
		super.showAlData();
		System.out.println("별명: "+nickname);
	}
	
	@Override
	public void showSimpleData() {
		System.out.println("===고딩친구===");		
		System.out.println("이름: "+name);
		System.out.println("별명: "+nickname);
		
	}
}

class UnivFriends extends Friends {
	String major;
	
	public UnivFriends(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	
	@Override
	public void showAlData() {
		System.out.println("===대딩친구===");
		super.showAlData();
		System.out.println("전공: "+major);
	}
	
	@Override
	public void showSimpleData() {
		System.out.println("===대딩친구===");		
		System.out.println("이름: "+name);
		System.out.println("전공: "+major);
		
	}
}

public class MainFriendInfo
{
	public static void showMenu() {
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
		
		Scanner scan = new Scanner(System.in);
		FriendsHandler handler = new FriendsHandler(100);
		
		while(true) {
			showMenu();
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: case 2:
				handler.addFriends(choice); break;
			case 3:
				handler.showAlData(); break;
			case 4:
				handler.showSimpleData(); break;
			case 5:
				handler.searchFriends(); break;
			case 6:
				handler.deleteFriends(); break;
			case 7:
				System.out.println("프로그램 종료"); return;
			}
		}
	}
}

class FriendsHandler {
	
	private Friends[] myfriend;
	private int numOfFriend;
	
	public FriendsHandler(int num) {
		myfriend = new Friends[num];
		numOfFriend = 0;
	}
	
	public void addFriends(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iAddr, iNickname, iMajor;
		
		System.out.print("이름:"); iName = scan.nextLine();
		System.out.print("전화번호:"); iPhone = scan.nextLine();
		System.out.print("주소:"); iAddr = scan.nextLine();
		
		if(choice==1) {
			System.out.print("별명:"); iNickname = scan.nextLine();
			HighFriends high = new HighFriends(iName, iPhone, iAddr, iNickname);
			myfriend[numOfFriend++] = high;
			
		}
		else {
			System.out.print("전공:"); iMajor = scan.nextLine();
			UnivFriends univ = new UnivFriends(iName, iPhone, iAddr, iMajor);
			myfriend[numOfFriend++] = univ;
		}
		
		System.out.println("===친구정보 입력 완료===");
	}//end of addFriends
	
	public void showAlData() {
		for(int i=0; i<numOfFriend; i++) {
			myfriend[i].showAlData();
		}
		System.out.println("===상세정보 출력 완료===");
		
	}
	
	public void showSimpleData() {
		
		for(int i=0; i<numOfFriend; i++) {
			myfriend[i].showSimpleData();
		}
		System.out.println("===요약정보 출력 완료===");
		
	}
	
	public void searchFriends() {
		boolean isFind = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색이름 입력: ");
		String search = scan.nextLine();
		
		for(int i=0; i<numOfFriend; i++) {
			if(search.compareTo(myfriend[i].name)==0) {
				myfriend[i].showAlData();
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("**찾을 수 없습니다.**");
	}
	
	public void deleteFriends() {
		Scanner scan = new Scanner(System.in);
		System.out.println("==삭제할 이름을 입력하세요==");
		String delete = scan.nextLine();
		
		int deleteId = -1;
		
		for(int i=0; i<numOfFriend; i++) {
			if(myfriend[i].name.compareTo(delete)==0) {
				myfriend[i]= null;
				deleteId = i;
				numOfFriend--;
			}
		}
		
		if(deleteId==-1) {
			System.out.println("**삭제할 정보가 없습니다.**");
		}
		else {
			for(int i= deleteId; i<numOfFriend; i++) {
				myfriend[i] = myfriend[i+1];
			}
			System.out.println("==요청한 정보가 삭제되었습니다.==");
		}
		
		
	}
	
	
	
	
}