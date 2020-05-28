package dao;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.PurchaseHistoryBean;

public class PurchaseHistoryDAO extends DAO<PurchaseHistoryBean> {

	@Override
	protected PurchaseHistoryBean construct(Map<String, Object> record) {
		// TODO 自動生成されたメソッド・スタブ
		return new PurchaseHistoryBean(
				(String)record.get("user_id"),
				(int)record.get("item_cd"),
				(Date)record.get("purchase_date"),
				(int)record.get("purchase_quantity"),
				(int)record.get("drink_size_cd"),
				(int)record.get("drink_sugar_cd"),
				(int)record.get("ice_amount_cd"),
				(int)record.get("tapioka_kind_cd"),
				(int)record.get("tapioka_amount_cd"),
				(int)record.get("topping_cd")
				);
	}

	public List<PurchaseHistoryBean> findAll(){
		return executeQuery( conn -> conn.prepareStatement("SELECT * FROM purchase_history") );

	}

	public void addTable(HttpSession session) {
		executeQuery(conn -> {
			PreparedStatement pStmt = conn.prepareStatement("INSERT INTO `purchase_history`(`user_id`, `item_cd`, `purchase_date`, `purchase_quantity`, `drink_size_cd`, `drink_sugar_cd`, `ice_amount_cd`, `tapioka_kind_cd`, `tapioka_amount_cd`, `topping_cd`) VALUES ("+session.getAttribute("user-id")+","+session.getAttribute("item_cd")+","+session.getAttribute("purchase_date")+","+session.getAttribute("purchase_quantity")+","+session.getAttribute("drink_size_cd")+","+session.getAttribute("drink_sugar_cd")+","+session.getAttribute("ice_amount_cd")+","+session.getAttribute("tapioka_kind_cd")+","+session.getAttribute("tapioka_amount_cd")+","+session.getAttribute("topping_cd"));
			return pStmt;
		});
	}

}
