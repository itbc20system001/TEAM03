package model;

import java.util.List;

import dao.CustomizeDAO;

public class CustomizeLogic {

	CustomizeDAO customizeDAO = new CustomizeDAO();

	//ここで処理する内容はカスタマイズのDBからデータを持ってきてListに格納する処理
	public List<CustomizeBean> makeCustomizeList(String customizeCalamName,String customizeCodeName, String tableName){
		customizeDAO.setCustomizeCalamName(customizeCalamName);
		customizeDAO.setCustomizeCodeName(customizeCodeName);
		List<CustomizeBean> custimizeList = customizeDAO.executeQuery( conn -> conn.prepareStatement("SELECT * FROM "+tableName) );
		return custimizeList;

	}

}
