package dao;

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

}
