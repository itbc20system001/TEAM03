package dao;

import java.util.Map;

import model.DAOTestBean;

//DAOクラスの継承例
public class DAOTestBeanDAO extends DAO<DAOTestBean> {


	@Override
	public DAOTestBean construct(Map<String, Object> record) {
		// TODO 自動生成されたメソッド・スタブ
		return new DAOTestBean(
				(int)record.get("xxx"),
				(String)record.get("yyy")
				);
	}

}
