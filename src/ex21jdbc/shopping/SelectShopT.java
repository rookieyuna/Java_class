package ex21jdbc.shopping;

import java.sql.Statement;

import ex21jdbc.connect.IConnectImpl;

public class SelectShopT extends IConnectImpl {
	Statement stmt;
	
	public SelectShopT() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			//1.statement 객체 생성
			stmt = con.createStatement();
				
			//2.쿼리작성
			String sql = "SELECT g_idx, goods_name, "
				+ " to_char(goods_price,'9,990,000'), "
				+ " to_char(regidate,'yyyy-mm-dd hh:mi'), p_code "
				+ " FROM sh_goods WHERE 1=1";

			String searchStr = scanValue("검색할상품명");
			if(searchStr!=null) {
				sql = sql + " AND goods_name "
						+ " LIKE '%"+ searchStr +"%' ";
			}
			System.out.println("쿼리문:"+ sql);
			
			/*
			※차후 JSP에서 검색에 대한 부분을 구현할때를 
			대비하여 설명을 위한 코드임.
			즉, where 1=1 이 쿼리에 있으면 뒷부분의 추가조건에 
			대해서는 무조건 and로 연결하면 되기때문에 코드작성에
			편리하다.
			
			String searchCode = "1";
			if(searchCode!=null) {
				sql = sql + " AND p_code='"+ searchCode +"' ";
			}*/
			
			sql = sql + " ORDER BY g_idx DESC";
			
			//3.쿼리실행
			rs = stmt.executeQuery(sql);		
			
			//4.ResultSet의 갯수만큼 반복하며 출력
			System.out.println("No  상품명  가격  등록일  제품코드");
			while(rs.next()){
				int g_idx = rs.getInt("g_idx");
				String goods_name = rs.getString("goods_name");
				String goods_price = rs.getString(3);
				
				//date타입인 경우 getString()으로 가져오면 날자/시간까지 출력됨
				String regidate = rs.getString(4);
				
				//getDate()로 가져오면 날자만 출력됨
				//java.sql.Date regidate = rs.getDate(4);
				
				String p_code = rs.getString("p_code");
			
				System.out.printf("%2s %8s %8s %s %s\n", 
						g_idx, goods_name, goods_price, 
						regidate, p_code);
			}			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}		
	}

	public static void main(String[] args) {
		new SelectShopT().execute();
	}
}
