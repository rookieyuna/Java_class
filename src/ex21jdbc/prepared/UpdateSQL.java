package ex21jdbc.prepared;

import ex21jdbc.connect.IConnectImpl;

public class UpdateSQL extends IConnectImpl  {

	public UpdateSQL() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		//수정, 삭제시에는 주로 PK컬럼을 조건으로 사용
		String sql = "UPDATE member SET name=?, pass=? WHERE id=?";
		/*
		사용자 입력시 exit를 입력할 때까지는 계속 실행되는 구조로 되어있다.
		prepared 객체는 재사용이 가능한 쿼리문을 수행하는 구조이므로
		이런 형태(무한반복)의 프로그래밍이 가능하다.
		 */
		try {
			psmt = con.prepareStatement(sql);
			
			while(true) {
				//인파라미터 설정시 인덱스만 맞으면 입력순서는 상관없다!
				psmt.setString(3, scanValue("수정할 아이디"));
				psmt.setString(1, scanValue("이름"));
				psmt.setString(2, scanValue("패스워드"));
				
				int affected = psmt.executeUpdate();
				System.out.println(affected +"행이 업데이트 되었습니다.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new UpdateSQL().execute();
	}
}
