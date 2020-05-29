package model;

import java.io.Serializable;

//注文内容（商品とカスタマイズの内容）を表すBean
public class OrderDetailBean implements Serializable{

	private int itemCd; //商品CD
	private int purchaseQuantity; //購入個数
	private int drinkSize; //ドリンクサイズ
	private int drinkSugar; //ドリンク甘さ
	private int iceAmount; //氷の量
	private int tapiokaKind; //タピオカ種類
	private int tapiokaAmount; //タピオカ量
	private int topping; //トッピング種類

	public OrderDetailBean(int itemCd, int purchaseQuantity, int drinkSize, int drinkSugar, int iceAmount,
			int tapiokaKind, int tapiokaAmount, int topping) {
		super();
		this.itemCd = itemCd;
		this.purchaseQuantity = purchaseQuantity;
		this.drinkSize = drinkSize;
		this.drinkSugar = drinkSugar;
		this.iceAmount = iceAmount;
		this.tapiokaKind = tapiokaKind;
		this.tapiokaAmount = tapiokaAmount;
		this.topping = topping;
	}

	public int getItemCd() {
		return itemCd;
	}

	public void setItemCd(int itemCd) {
		this.itemCd = itemCd;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public int getDrinkSize() {
		return drinkSize;
	}

	public void setDrinkSize(int drinkSize) {
		this.drinkSize = drinkSize;
	}

	public int getDrinkSugar() {
		return drinkSugar;
	}

	public void setDrinkSugar(int drinkSugar) {
		this.drinkSugar = drinkSugar;
	}

	public int getIceAmount() {
		return iceAmount;
	}

	public void setIceAmount(int iceAmount) {
		this.iceAmount = iceAmount;
	}

	public int getTapiokaKind() {
		return tapiokaKind;
	}

	public void setTapiokaKind(int tapiokaKind) {
		this.tapiokaKind = tapiokaKind;
	}

	public int getTapiokaAmount() {
		return tapiokaAmount;
	}

	public void setTapiokaAmount(int tapiokaAmount) {
		this.tapiokaAmount = tapiokaAmount;
	}

	public int getTopping() {
		return topping;
	}

	public void setTopping(int topping) {
		this.topping = topping;
	}
}
