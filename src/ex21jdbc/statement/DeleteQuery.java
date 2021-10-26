package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
	
	//멤버변수
	private Connection con;
	private Statement stmt; 
	
	//생성자 - 드라이버 로드만 수행
	public DeleteQuery() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Oracle 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}////end of DeleteQuery
	
	//오라클 연결 처리 메서드
	public void connect() {
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"kosmo",
					"1234");
		}
		catch(SQLException e) {
			System.out.println("Oracle 연결 오류");
			e.printStackTrace();
		}
	}
	
	//오라클 연결, 쿼리작성, 전송 및 실행
	private void execute() {
		
		connect();
		try {
			/*
			test99와 같이 실제로는 없는 레코드에 대한 삭제를 진행해도,
			에러는 발행하지 않고 진행된다.
			 */
			stmt = con.createStatement();
			String query = "DELETE FROM member WHERE id='abcde'";
			int affected = stmt.executeUpdate(query);
			System.out.println(affected + "행이 삭제됨");
		}
		catch (SQLException e) {
			System.out.println("쿼리 실행 문제발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}////end of execute
	
	private void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("DB자원 반납 완료");
		}
		catch (SQLException e) {
			System.out.println("자원반납 시 오류 발생");
			e.printStackTrace();
		}
	}////end of close
	
	public static void main(String[] args) {
		//객체생성과 메서드 호출을 동시에 진행.
		new DeleteQuery().execute();
	}////end of main
}
