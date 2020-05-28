package model;

import java.io.Serializable;
import java.util.Date;

public class PurchaseBean implements Serializable {
	//private int purchaseId; //購入ID
	private String userId; //ユーザーID
	private int itemCd; //商品CD
	private Date  purchaseDate; //購入日時
	private int purchaseQuantity; //購入個数
	private int drinkSize; //ドリンクサイズ
	private int drinkSugar; //ドリンク甘さ
	private int iceAmount; //氷の量
	private int tapiokaKind; //タピオカ種類
	private int tapiokaAmount; //タピオカ量
	private int topping; //トッピング種類

	public PurchaseBean() {
	}

	public PurchaseBean(/*int purchaseId */ String userId, int item, Date purchaseDate, int purchaseQuantity, int drinkSize,
			int drinkSugar, int iceAmount, int tapiokaKind, int tapiokaAmount, int topping) {
		super();
		//this.purchaseId = purchaseId;
		this.userId = userId;
		this.itemCd = item;
		this.purchaseDate = purchaseDate;
		this.purchaseQuantity = purchaseQuantity;
		this.drinkSize = drinkSize;
		this.drinkSugar = drinkSugar;
		this.iceAmount = iceAmount;
		this.tapiokaKind = tapiokaKind;
		this.tapiokaAmount = tapiokaAmount;
		this.topping = topping;
	}

/*	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}*/

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getItem() {
		return itemCd;
	}

	public void setItem(int item) {
		this.itemCd = item;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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
