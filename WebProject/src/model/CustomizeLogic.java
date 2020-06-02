package model;

import java.util.List;

import dao.CustomizeDAO;

public class CustomizeLogic {



	//ここで処理する内容はカスタマイズのDBからデータを持ってきてListに格納する処理
	public List<CustomizeBean> makeCustomizeList(PassName p){
		CustomizeDAO customizeDAO = new CustomizeDAO(p);
		List<CustomizeBean> custimizeList = customizeDAO.findAll();
		return custimizeList;

	}

}
