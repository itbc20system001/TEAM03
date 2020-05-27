package model;

import java.io.Serializable;

//DAOのテストのためのBean
public class DAOTestBean implements Serializable{
	private int xxx;
	private String yyy;

	public int getXxx() {
		return xxx;
	}
	public void setXxx(int xxx) {
		this.xxx = xxx;
	}
	public String getYyy() {
		return yyy;
	}
	public void setYyy(String yyy) {
		this.yyy = yyy;
	}
	public DAOTestBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public DAOTestBean(int xxx, String yyy) {
		super();
		this.xxx = xxx;
		this.yyy = yyy;
	}
}
