package model;

public enum PassName {
	drink_size,
	ice_amount,
	tapioka_amount,
	tapioka_kind,
	drink_sugar,
	topping;

	public String getCodeName() {
		return this.name()+"_cd";
	}

	public String getTableName() {
		return "mst_"+this.name();
	}
}
