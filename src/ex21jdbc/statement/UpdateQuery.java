package ex21jdbc.statement;

import java.sql.SQLException;

//추상클래스(ConnectDB)를 상속하여 정의
public class UpdateQuery extends ConnectDB {
	
	public UpdateQuery(String user, String pass) {
		//인자를 가진 부모의 생성자를 호출
		super(user, pass);
	}
	
	//
	@Override
	void execute() {
		try {
			//statement 객체생성 및 쿼리작성, 실행
			stmt = con.createStatement();
			
			String sql = "UPDATE member "
				+ " SET "
					+ " pass='1111', "
					+ " name='이순신', "
					+ " regidate=SYSDATE "
					+ " where id='test99' ";
			System.out.println("sql=" +sql);
			/*
			executeUpdate()
				:쿼리문이 insert/update/delete와 같이
				기존레코드에 영향을 미치는 경우 사용한다.
				실행 후 영향을 받은 행의 개수를 int형으로 반환
			executeQuery()
				: select 쿼리를 실행할 때 호출하는 메서드
				레코드에 영향을 미치지 않고 조회만 하는경우 사용
				조회된 레코드를 반환 받아야하므로 반환타입으로
				ResultSet객체를 사용
			 */
			
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected + "행이 업데이트됨");
		}
		catch (SQLException e) {
			System.out.println("쿼리 오류");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알 수 없는 예외 발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new UpdateQuery("kosmo", "1234").execute();
	}
}
