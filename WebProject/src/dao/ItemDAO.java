package dao;

import java.util.List;
import java.util.Map;

import model.ItemBean;

public class ItemDAO extends DAO<ItemBean> {

	@Override
	protected ItemBean construct(Map<String, Object> record) {


		return new ItemBean(

				(String) record.get("item_name"),
				(int)record.get("item_price"),
				(String)record.get("item_text"),
				(String)record.get("item_image_url")
				);
	}

	public List<ItemBean> findAll(){
		return new ItemDAO().executeQuery( conn -> conn.prepareStatement("SELECT * FROM ") );

	}



}
