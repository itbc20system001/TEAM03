package model;

import java.io.Serializable;

public class CustomizeBean implements Serializable{
	@Override
	public String toString() {
		return "CustomizeBean [code=" + code + ", customize=" + customize + "]";
	}


	private int code;
	private String customize;


	public CustomizeBean(int code,String customize) {
		super();
		this.code = code;
		this.customize = customize;
	}


	public String getCustomize() {
		return customize;
	}


	public void setCustomize(String customize) {
		this.customize = customize;
	}


	public CustomizeBean() {

	}
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}

}
