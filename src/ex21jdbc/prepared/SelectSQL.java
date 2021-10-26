package ex21jdbc.prepared;

import java.sql.SQLException;

import ex21jdbc.connect.IConnectImpl;

public class SelectSQL extends IConnectImpl {

	public SelectSQL() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			while(true) {
				/*
				prepared객체를 통해 인파라미터를 설정하면 문자인 경우
				자동으로 ''로 감싸준다. 따라서 concat연산자를 활용하여
				문자를 연결하는 형태로 바꿔주어야 한다.
				 */
				String sql = "SELECT * FROM member "
					//+ " WHERE name like '%?%'"; //에러발생.부적합한 열인덱스
					+ " WHERE name LIKE '%'||?||'%'";
				psmt = con.prepareStatement(sql);
				psmt.setString(1, scanValue("찾는이름"));
				rs = psmt.executeQuery();
				while(rs.next()) {
					String id= rs.getString(1);
					String pass= rs.getString(2);
					String name= rs.getString(3);
					String regidate= rs.getString(4).substring(0,10);
					
					System.out.printf("%s %s %s %s\n", id, pass, name, regidate);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new SelectSQL().execute();
	}
}
