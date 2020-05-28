package dao;

import java.util.Map;

import model.CustomizeBean;

public class CustomizeDAO extends DAO<CustomizeBean> {
	String customizeCalamName;

	@Override
	protected CustomizeBean construct(Map<String, Object> record) {
		// TODO 自動生成されたメソッド・スタブ

		return new CustomizeBean((String)record.get(customizeCalamName));
	}

	public String getCustomizeCalamName() {
		return customizeCalamName;
	}
	public void setCustomizeCalamName(String customizeCalamName) {
		this.customizeCalamName = customizeCalamName;
	}

}
