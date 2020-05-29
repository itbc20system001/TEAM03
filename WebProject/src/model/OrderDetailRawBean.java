package model;

import java.io.Serializable;

public class OrderDetailRawBean implements Serializable{
	private ItemBean item;
	private int purchaseQuantity;
	private CustomizeBean drinkSize;
	private CustomizeBean drinkSugar;
	private CustomizeBean iceAmount ;
	private CustomizeBean tapiokaKind;
	private CustomizeBean tapiokaAmount;
	private CustomizeBean topping;

	public OrderDetailRawBean() {

	}


	public OrderDetailRawBean(ItemBean item, int purchaseQuantity, CustomizeBean drinkSize, CustomizeBean drinkSugar,
			CustomizeBean iceAmount, CustomizeBean tapiokaKind, CustomizeBean tapiokaAmount, CustomizeBean topping) {
		super();
		this.item = item;
		this.purchaseQuantity = purchaseQuantity;
		this.drinkSize = drinkSize;
		this.drinkSugar = drinkSugar;
		this.iceAmount = iceAmount;
		this.tapiokaKind = tapiokaKind;
		this.tapiokaAmount = tapiokaAmount;
		this.topping = topping;
	}
	public ItemBean getItem() {
		return item;
	}
	public void setItem(ItemBean item) {
		this.item = item;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public CustomizeBean getDrinkSize() {
		return drinkSize;
	}
	public void setDrinkSize(CustomizeBean drinkSize) {
		this.drinkSize = drinkSize;
	}
	public CustomizeBean getDrinkSugar() {
		return drinkSugar;
	}
	public void setDrinkSugar(CustomizeBean drinkSugar) {
		this.drinkSugar = drinkSugar;
	}
	public CustomizeBean getIceAmount() {
		return iceAmount;
	}
	public void setIceAmount(CustomizeBean iceAmount) {
		this.iceAmount = iceAmount;
	}
	public CustomizeBean getTapiokaKind() {
		return tapiokaKind;
	}
	public void setTapiokaKind(CustomizeBean tapiokaKind) {
		this.tapiokaKind = tapiokaKind;
	}
	public CustomizeBean getTapiokaAmount() {
		return tapiokaAmount;
	}
	public void setTapiokaAmount(CustomizeBean tapiokaAmount) {
		this.tapiokaAmount = tapiokaAmount;
	}
	public CustomizeBean getTopping() {
		return topping;
	}
	public void setTopping(CustomizeBean topping) {
		this.topping = topping;
	}

}
