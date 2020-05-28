package dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
		return new PurchaseHistoryDAO().executeQuery( conn -> conn.prepareStatement("SELECT * FROM ") );

	}
	public void creation(PurchaseHistoryBean ph) {//注文確定時、DBの履歴を更新
		//セッションスコープからDBに移す
	}

}
