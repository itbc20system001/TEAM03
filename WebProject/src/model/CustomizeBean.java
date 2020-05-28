package model;

import java.util.List;

public class CustomizeBean {
	private List<String> suger;
	private List<String> topping;
	private List<String> ice;
	private List<String> drinkSize;
	private List<String> tapiocaAmount;
	private List<String> tapiocaType;

	public CustomizeBean() {

	}



	public CustomizeBean(List<String> suger, List<String> topping, List<String> ice, List<String> drinkSize,
			List<String> tapiocaAmount, List<String> tapiocaType) {
		super();
		this.suger = suger;
		this.topping = topping;
		this.ice = ice;
		this.drinkSize = drinkSize;
		this.tapiocaAmount = tapiocaAmount;
		this.tapiocaType = tapiocaType;
	}



	public List<String> getSuger() {
		return suger;
	}

	public void setSuger(List<String> suger) {
		this.suger = suger;
	}

	public List<String> getTopping() {
		return topping;
	}

	public void setTopping(List<String> topping) {
		this.topping = topping;
	}

	public List<String> getIce() {
		return ice;
	}

	public void setIce(List<String> ice) {
		this.ice = ice;
	}

	public List<String> getDrinkSize() {
		return drinkSize;
	}

	public void setDrinkSize(List<String> drinkSize) {
		this.drinkSize = drinkSize;
	}

	public List<String> getTapiocaAmount() {
		return tapiocaAmount;
	}

	public void setTapiocaAmount(List<String> tapiocaAmount) {
		this.tapiocaAmount = tapiocaAmount;
	}

	public List<String> getTapiocaType() {
		return tapiocaType;
	}

	public void setTapiocaType(List<String> tapiocaType) {
		this.tapiocaType = tapiocaType;
	}

}
