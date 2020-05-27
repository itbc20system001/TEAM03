package dao;
import java.sql.SQLException;
import java.util.List;

import model.DAOTestBean;
public class DAOTest {

	//DAO（を継承したクラス）の利用例
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		List<DAOTestBean> result = new DAOTestBeanDAO().executeQuery(conn -> {
			try {
				return conn.prepareStatement("SELECT * FROM dao_test");
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return null;
			}
		});

		for(DAOTestBean dtb:result) {
			System.out.println(dtb.getXxx() + " " + dtb.getYyy());
		}
	}

}
