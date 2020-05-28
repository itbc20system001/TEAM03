package model;

import dao.MemberDAO;
public class LoginLogic {

	//DBに問い合わせてログインする。失敗したらnullを返す
	public static MemberBean login(String userId,String password) {
		return new MemberDAO().find(userId, password);
	}


}
