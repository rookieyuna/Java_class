package ex21jdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
인터페이스를 구현한 클래스로 extends대신 implements를 사용한다.
또한, 용어도 '상속'이 아닌 '구현'이라 표현한다.
 */
public class IConnectImpl implements IConnect {
	
	public Connection con;
	public PreparedStatement psmt; //동적쿼리 실행을 위한 객체
	public ResultSet rs;
	
	//기본생성자(default생성자)
	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	//인자생성자1 : 아이디, 패스워드를 인자로 받음
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//인자생성자2 : 오라클드라이버, 아이디, 패스워드를 인자로 받음
	public IConnectImpl(String driver, String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(driver);
			connect(user, pass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//오라클에 연결하기 위한 메서드
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	
	//오버라이딩의 목적으로 정의한 메서드. 쿼리실행문은 각 클래스에서 진행
	@Override
	public void execute() {
		//하는 일 없음(실행부 없음)
	}
	
	//자원반납
	@Override
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("DB자원 반납 완료");
		}
		catch (SQLException e) {
			System.out.println("자원반납 시 오류가 발생");
		}
	}////end of close
	
	//사용자로부터 입력 값을 받기 위한 메서드
	@Override
	public String scanValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.println(title + "을(를) 입력(exit->종료): ");
		String inputStr = scan.nextLine();
		
		/*
		equalsIgnoreCase(String)
			: equals()와 동일하게 문자열이 같은지 비교하는 메서드
			대소문자를 구분하지 않고 비교하여 true/false 반환
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0); //프로그램 즉시 종료
		}
		return inputStr;
	}
}
