package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//객체생성이 불가하므로 상속의 목적으로 정의한 추상클래스
public abstract class ConnectDB {
	
	/*
	멤버변수 : protected로 선언하여 자식클래스에서 접근을 허용
	 */
	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	
	//생성자1 : 인자가 없는 생성자
	public ConnectDB() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"kosmo", "1234");
				System.out.println("Oracle DB 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Oracle 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("Oracle 연결실패");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알 수 없는 예외발생");
			e.printStackTrace();
		}
	}////end of ConnectDB()
		
	
	//생성자2 = 인자가 있는 생성자
	public ConnectDB(String id, String pw) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					id, pw);
				System.out.println("Oracle DB 연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Oracle 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("Oracle 연결실패");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알 수 없는 예외발생");
			e.printStackTrace();
		}
	}////end of ConnectDB(id,pw)
	
	public void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			if(rs!=null) rs.close();
			System.out.println("DB자원 반납 완료");
		}
		catch (SQLException e) {
			System.out.println("자원반납 시 오류가 발생하였습니다.");
		}
	}////end of close
	
	/*
	상속관계에서 오버라이딩을 목적으로 생성한 추상메서드
	하위 클래스에서 각 목적에 따라 재정의한다.
	*/
	abstract void execute();
}
