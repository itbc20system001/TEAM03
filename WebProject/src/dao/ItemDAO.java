package dao;

import java.util.Map;

import model.ItemBean;

public class ItemDAO extends DAO<ItemBean> {

	@Override
	protected ItemBean construct(Map<String, Object> record) {

		return new ItemBean(
				(String)record.get("item"),
				(int)record.get("item_price"),
				(String)record.get("item_text"),
				(String)record.get("item_image_url")

				);
	}




}

