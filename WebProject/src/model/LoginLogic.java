package model;

import java.sql.PreparedStatement;
import java.util.List;

import dao.MemberDAO;
public class LoginLogic {

	//DBに問い合わせてログインする。失敗したらnullを返す
	public static MemberBean login(String userId,String password) {

		List<MemberBean> members = new MemberDAO().executeQuery(conn -> {
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM member WHERE user_id = ? AND password = ?");
			pStmt.setString(1, userId);
			pStmt.setString(2, password);
			return pStmt;
		});

		return members.isEmpty() ? null : members.get(0);

	}
}
