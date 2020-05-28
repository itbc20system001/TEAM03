package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import dao.PurchaseDAO;

public class PurchaseHistoryLogic {

	public List<PurchaseBean> makeHistoryList(HttpSession session){
		PurchaseDAO phDAO = new PurchaseDAO();
		List<PurchaseBean> historyList = phDAO.findAll();
		//String userId = (String) session.getAttribute("ユーザーを保存している奴の名前");
		String userId = "suzuiti";
		List<PurchaseBean> userPHList = new ArrayList<>();
		for(PurchaseBean i:historyList) {
			if(userId.equals(i.getUserId())){
				userPHList.add(i);
			}
		}
		return userPHList;
	}

	public void addHistoryList(HttpSession session) {

	}
}
