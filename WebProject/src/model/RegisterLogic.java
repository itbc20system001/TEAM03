package model;

import dao.MemberDAO;

//会員情報を登録し、成功すればtrueを返す
public class RegisterLogic {
/*
	public static void main(String[] args) {
		MemberDAO memDao = new MemberDAO();
		Boolean b = memDao.addUser(new MemberBean("userId", "userLName", "userFName", "password", "prefecture", "address", "tel", "mail"));
		System.out.println(b);
	}
*/
	public boolean execute(MemberBean member) {
		//引数の値を入れる
		MemberBean m = member;

		//daoのメソッドを呼び出して、booleanの戻り値を受け取る
		MemberDAO memDao = new MemberDAO();
		Boolean b = memDao.addUser(m);


		//呼び出し元のサーブレットに成功判定を返す
		return b;

		/*	if() {
				return true;
			} else {
				return false;
			}
		 return true;
*/
	}

}
