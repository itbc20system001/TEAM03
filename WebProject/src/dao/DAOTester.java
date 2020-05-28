package dao;

public class DAOTester {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new ItemDAO().executeQuery(conn -> conn.prepareStatement("SELECT * FROM item"))
			.stream()
			.map(ob -> ob.getItemCd() +" " + ob.getItemText())
			.forEach(System.out::println);
	}

}
