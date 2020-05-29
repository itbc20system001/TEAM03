package model;

//商品Beans
import java.io.Serializable;

public class ItemBean implements Serializable {
	private int itemCd;//商品のCD
	private String item; //商品名
	private int itemPrice; //商品価格
	private String itemText; //商品説明
	private String itemImageUrl; //商品画像URL

	public ItemBean() {
	}

	public ItemBean(int itemCd, String item, int itemPrice, String itemText, String itemImageUrl) {
		this.itemCd=itemCd;
		this.item = item;
		this.itemPrice = itemPrice;
		this.itemText = itemText;
		this.itemImageUrl = itemImageUrl;
	}

	public int getItemCd() {
		return itemCd;
	}

	public void setItem(int itemCd) {
		this.itemCd = itemCd;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemText() {
		return itemText;
	}

	public void setItemText(String itemText) {
		this.itemText = itemText;
	}

	public String getItemImageUrl() {
		return itemImageUrl;
	}

	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}

}
