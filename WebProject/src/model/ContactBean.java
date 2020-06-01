package model;

import java.io.Serializable;

public class ContactBean implements Serializable{
	private String exp; //ユーザーID
	private String cause; //姓
	private String message; //名

	public ContactBean() {
	}


	public ContactBean(String exp, String cause, String message) {
		this.exp = exp;
		this.cause = cause;
		this.message = message;
		}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
	}


	public String getCause() {
		return cause;
	}


	public void setCause(String cause) {
		this.cause = cause;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
}
