package dao;

import java.util.Date;
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

}
