package model;

//商品Beans
import java.io.Serializable;

public class ItemBean implements Serializable {
	private String item; //商品名
	private String itemPrice; //商品価格
	private String itemText; //商品説明
	private String itemImageUrl; //商品画像URL

	public ItemBean() {
	}

	public ItemBean(String itemCd, String itemPrice, String itemText, String itemImageUrl) {
		this.item = itemCd;
		this.itemPrice = itemPrice;
		this.itemText = itemText;
		this.itemImageUrl = itemImageUrl;
	}

	public String getItemCd() {
		return item;
	}

	public void setItemCd(String itemCd) {
		this.item = itemCd;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
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
