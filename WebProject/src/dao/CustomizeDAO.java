package dao;

import java.util.List;
import java.util.Map;

import model.CustomizeBean;

public class CustomizeDAO extends DAO<CustomizeBean> {
	String customizeCalamName;
	String customizeCodeName;
	String tableName;

	public CustomizeDAO(String customizeCalamName,String CustomizeCodeName,String tableName) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.customizeCalamName = customizeCalamName;
		this.customizeCodeName = CustomizeCodeName;
		this.tableName = tableName;
	}

	public CustomizeDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected CustomizeBean construct(Map<String, Object> record) {
		// TODO 自動生成されたメソッド・スタブ

		return new CustomizeBean((int)record.get(customizeCodeName),(String)record.get(customizeCalamName));
	}

	public String getCustomizeCalamName() {
		return customizeCalamName;
	}
	public void setCustomizeCalamName(String customizeCalamName) {
		this.customizeCalamName = customizeCalamName;
	}

	public String getCustomizeCodeName() {
		return customizeCodeName;
	}

	public void setCustomizeCodeName(String customizeCodeName) {
		this.customizeCodeName = customizeCodeName;
	}

	public List<CustomizeBean> findAll(){
		return executeQuery( conn -> conn.prepareStatement("SELECT * FROM "+tableName) );

	}

}
