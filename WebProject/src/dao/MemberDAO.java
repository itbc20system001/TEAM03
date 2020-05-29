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
				(String) record.get("user_id"),
				(String) record.get("user_l_name"),
				(String) record.get("user_f_name"),
				(String) record.get("password"),
				(String) record.get("prefecture"),
				(String) record.get("address"),
				(String) record.get("tel"),
				(String) record.get("mail"));
	}

	//ユーザーID、パスワードが等しいユーザーを探して返す。存在しなければnullを返す
	public MemberBean find(String userId, String password) {

		List<MemberBean> members = executeQuery(conn -> {
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM member WHERE user_id = ? AND password = ?");
			pStmt.setString(1, userId);
			pStmt.setString(2, password);
			return pStmt;
		});

		return members.isEmpty() ? null : members.get(0);

	}

	//会員情報を登録するメソッド
	public boolean addUser(MemberBean mb) {
		//変更先のユーザーIDが衝突しているか判定
		boolean isIdConflicted = ! executeQuery(conn -> {
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM member WHERE user_id = ?");
			pStmt.setString(1, mb.getUserId());
			return pStmt;
		}).isEmpty();

		boolean res;

		//衝突して失敗する
		if(isIdConflicted ) {
			res = false;
		}else {

			//ここにインサート文
			res = executeUpdate(conn -> {
				String sql ="INSERT INTO member VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//INSERT文中の？に使用する値を設定しSQLを完成
				pStmt.setString(1,mb.getUserId());
				pStmt.setString(2,mb.getUserLName());
				pStmt.setString(3,mb.getUserFName());
				pStmt.setString(4,mb.getPassword());
				pStmt.setString(5,mb.getPrefecture());
				pStmt.setString(6,mb.getAddress());
				pStmt.setString(7,mb.getTel());
				pStmt.setString(8,mb.getMail());

				return pStmt;
			});
		}


		//成功判定を返す
		return res;
	}


	public boolean modifyMember(MemberBean oldMember,MemberBean newMember) {
		//変更先のユーザーIDが衝突しているか判定
		System.out.println(oldMember.getUserId());
		System.out.println(newMember.getUserId());
		boolean isIdConflicted = ! executeQuery(conn -> {
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM member WHERE user_id = ?");
			pStmt.setString(1, newMember.getUserId());
			return pStmt;
		}).isEmpty();

		//衝突していて、かつそれが現在の自分のアカウントでなければ失敗する
		if(isIdConflicted & !oldMember.getUserId().equals(newMember.getUserId())) {
			return false;

		}else {
			return executeUpdate(conn ->{
				PreparedStatement pStmt = conn.prepareStatement("UPDATE member SET "
						+ "user_id=?, "
						+ "user_l_name=?, "
						+ "user_f_name=?, "
						+ "password=?, "
						+ "prefecture=?, "
						+ "address=?, "
						+ "tel=?, "
						+ "mail=? "
						+ "WHERE user_id=?");
				pStmt.setString(1, newMember.getUserId());
				pStmt.setString(2, newMember.getUserLName());
				pStmt.setString(3, newMember.getUserFName());
				pStmt.setString(4, newMember.getPassword());
				pStmt.setString(5, newMember.getPrefecture());
				pStmt.setString(6, newMember.getAddress());
				pStmt.setString(7, newMember.getTel());
				pStmt.setString(8, newMember.getMail());

				pStmt.setString(9, oldMember.getUserId());
				return pStmt;
			});



		}
	}
}
