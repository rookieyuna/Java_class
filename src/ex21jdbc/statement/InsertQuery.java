package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
	//멤버변수
	Connection con; //DB연결을 위한 객체
	Statement stmt; //정적쿼리문 전송 및 실행하기위한 객체
	
	public InsertQuery() {
		try {
			//드라이버에 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//오라클 DB에 계정연결 : 정상연결 시 Connection 객체 반환
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"kosmo",
					"1234");
				System.out.println("Oracle DB 연결성공");
		}
		catch(ClassNotFoundException e) {
			//ojdbc6. jar파일이 없거나 연동되지 않은 경우
			System.out.println("Oracle 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch(SQLException e) {
			//커넥션 URL이나 계정정보가 잘못되었을 때 
			System.out.println("Oracle 연결실패");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("알 수 없는 예외발생");
			e.printStackTrace();
		}
	}////end of InsertQuery
	
	//쿼리작성 및 전송, 실행
	private void execute() {
		try {
			//Statement 객체 생성을 위한 메서드 호출
			stmt = con.createStatement();
			//쿼리문 작성
			String sql = "INSERT INTO member VALUES "
					+ " ('test5','5555','오공이', sysdate)";
			
			//쿼리문 실행 및 결과값 반환
			int affected = stmt.executeUpdate(sql);
			//insert문에 대한 결과 출력
			System.out.println(affected + "행이 입력되었습니다.");
		}
		catch (SQLException e) {
			System.out.println("쿼리 실행에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
		finally {
			/*
			finally: try문으로 진입했다면 예외가 발생하더라도 무조건 실행
			- 자원반납을 위한 close()메서드 호출
			 */
			close();
		}
	}
	
	private void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("DB자원 반납 완료");
		}
		catch (SQLException e) {
			System.out.println("자원반납 시 오류가 발생하였습니다.");
		}
	}////end of close
	
	public static void main(String[] args) {
		InsertQuery iSQL = new InsertQuery();
		iSQL.execute();
	}////end of main
}
