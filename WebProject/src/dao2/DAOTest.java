package dao2;
import java.sql.PreparedStatement;

import dao2.DAOTestBeanDAO;
public class DAOTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DAOTestBeanDAO dao = new DAOTestBeanDAO();
		dao.setSql("SELECT * FROM dao_test");
		PreparedStatement pStmt=dao.getPStmt();
		dao.executeQuery(pStmt);
	}

}
