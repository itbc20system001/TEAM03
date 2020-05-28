package model;

import java.util.List;

import dao.CustomizeDAO;

public class CustomizeLogic {



	//ここで処理する内容はカスタマイズのDBからデータを持ってきてListに格納する処理
	public List<CustomizeBean> makeCustomizeList(String customizeCalamName,String customizeCodeName, String tableName){
		CustomizeDAO customizeDAO = new CustomizeDAO(customizeCalamName,customizeCodeName,tableName);
		List<CustomizeBean> custimizeList = customizeDAO.findAll();
		return custimizeList;

	}

}
