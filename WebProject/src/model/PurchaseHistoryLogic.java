package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import dao.PurchaseHistoryDAO;

public class PurchaseHistoryLogic {

	public List<PurchaseHistoryBean> makeHistoryList(HttpSession session){
		PurchaseHistoryDAO phDAO = new PurchaseHistoryDAO();
		List<PurchaseHistoryBean> historyList = phDAO.findAll();
		String userId = (String) session.getAttribute("ユーザーを保存している奴の名前");
		List<PurchaseHistoryBean> userPHList = new ArrayList<>();
		for(PurchaseHistoryBean i:historyList) {
			if(userId.equals(i.getUserId())){
				userPHList.add(i);
			}
		}
		return userPHList;
	}
}
