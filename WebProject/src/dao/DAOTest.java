package dao;

import java.sql.PreparedStatement;
import java.util.List;

import model.DAOTestBean;

public class DAOTest {

	//DAO（を継承したクラス）の利用例
	public static void main(String[] args) {


		//単純なSQL文の場合
	//List<DAOTestBean> result = new DAOTestBeanDAO()
				//.executeQuery(conn -> conn.prepareStatement("SELECT * FROM dao_test"));


		//SQL文の?に値を入れる場合
		List<DAOTestBean> result = new DAOTestBeanDAO()
				.executeQuery(conn -> {
					PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM dao_test WHERE xxx < ?");
					pStmt.setInt(1, 50);
					return pStmt;
				});

		for (DAOTestBean dtb : result) {
			System.out.println(dtb.getXxx() + " " + dtb.getYyy());
		}
	}

}
