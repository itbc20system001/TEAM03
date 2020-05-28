package model;

import java.util.List;

import dao.ItemDAO;

	public class ItemListLogic {

		public static List<ItemBean> itemList(){
			return new ItemDAO().findAll();
		}



}
