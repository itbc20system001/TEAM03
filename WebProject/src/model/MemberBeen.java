package model;

import java.io.Serializable;

public class MemberBeen implements Serializable {
	private String userId; //ユーザーID
	private String userLName; //姓
	private String userFName; //名
	private String password; //パスワード
	private String prefecture; //住所（都道府県）
	private String address; //住所（市以下）
	private String tel; //電話番号
	private String main; //メールアドレス

	public MemberBeen() {
	}

	public MemberBeen(String userId, String userLName, String userFName, String password, String prefecture,
			String address, String tel, String main) {
		this.userId = userId;
		this.userLName = userLName;
		this.userFName = userFName;
		this.password = password;
		this.prefecture = prefecture;
		this.address = address;
		this.tel = tel;
		this.main = main;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

}
