package dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DAOTester {

	public static void main(String[] args) {

		new ItemDAO().executeQuery(conn -> conn.prepareStatement("SELECT * FROM item"))
				.stream()
				.map(ob -> ob.getItemCd() + " "
						+ ob.getItemText() + " "
						+ ob.getItemPrice() + " "
						+ ob.getItemImageUrl())
				.forEach(System.out::println);

		System.out.println();

		new MemberDAO().executeQuery(conn -> conn.prepareStatement("SELECT * FROM member"))
				.stream()
				.map(ob -> ob.getUserId() + " "
						+ ob.getUserLName() + " "
						+ ob.getUserFName() + " "
						+ ob.getPassword() + " "
						+ ob.getPrefecture() + " "
						+ ob.getAddress() + " "
						+ ob.getTel() + " "
						+ ob.getMain() + " ")
				.forEach(System.out::println);

		System.out.println();

		new PurchaseHistoryDAO().executeQuery(conn -> conn.prepareStatement("SELECT * FROM purchase_history"))
				.stream()
				.map(ob -> ob.getUserId() + " " +
						ob.getItem() + " " +
						ob.getPurchaseDate() + " " +
						ob.getPurchaseQuantity() + " " +
						ob.getDrinkSize() + " " +
						ob.getDrinkSugar() + " " +
						ob.getIceAmount() + " " +
						ob.getTapiokaKind() + " " +
						ob.getTapiokaAmount() + " " +
						ob.getTopping() + " ")
				.forEach(System.out::println);

		List<String> tableNames = Arrays.asList("mst_drink_size", "mst_drink_sugar", "mst_ice_amount",
				"mst_tapioka_kind", "mst_tapioka_amount", "mst_topping");

		List<String> customizeCodeNames = Arrays.asList("drink_size_cd", "drink_sugar_cd", "ice_amount_cd",
				"tapioka_kind_cd", "tapioka_amount_cd", "topping_cd");

		List<String> customizeColumnNames = Arrays.asList("drink_size", "drink_sugar", "ice_amount", "tapioka_kind",
				"tapioka_amount", "topping");

		IntStream.range(0, tableNames.size())
				.forEach(i -> {
					new CustomizeDAO(customizeColumnNames.get(i), customizeCodeNames.get(i))
							.executeQuery(conn ->
								conn.prepareStatement("SELECT * FROM " + tableNames.get(i)))
							.stream()
							.map(ob -> ob.getCode() + " " + ob.getCustomize())
							.forEach(System.out::println);
				});


	}

}
