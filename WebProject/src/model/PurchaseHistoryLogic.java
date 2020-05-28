package model;

import java.util.List;

import dao.PurchaseHistoryDAO;

public class PurchaseHistoryLogic {

	public List<PurchaseHistoryBean> makeHistoryList(){
		PurchaseHistoryDAO phDAO = new PurchaseHistoryDAO();
		List<PurchaseHistoryBean> historyList = phDAO.findAll();
		return historyList;
	}
}
