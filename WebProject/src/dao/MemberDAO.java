package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import model.MemberBean;

public class MemberDAO extends DAO<MemberBean> {

	@Override
	protected MemberBean construct(Map<String, Object> record) {
		// TODO 自動生成されたメソッド・スタブ
		return new MemberBean(
				(String)record.get("user_id"),
				(String)record.get("user_l_name"),
				(String)record.get("user_f_name"),
				(String)record.get("password"),
				(String)record.get("prefecture"),
				(String)record.get("address"),
				(String)record.get("tel"),
				(String)record.get("mail")
				);
	}

	//ユーザーID、パスワードが等しいユーザーを探して返す。存在しなければnullを返す
	public MemberBean find(String userId,String password) {

		List<MemberBean> members = executeQuery(conn -> {
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM member WHERE user_id = ? AND password = ?");
			pStmt.setString(1, userId);
			pStmt.setString(2, password);
			return pStmt;
		});

		return members.isEmpty() ? null : members.get(0);

	}

}
