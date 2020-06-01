package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InitializeLogic {
	public static void initCustomize(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		CustomizeLogic customizeLogic = new CustomizeLogic();

		//カスタマイズのListを作成
		List<CustomizeBean> iceList = new ArrayList<>();
		List<CustomizeBean> tapiokaTypeList = new ArrayList<>();
		List<CustomizeBean> tapiokaAmountList = new ArrayList<>();
		List<CustomizeBean> sugarList = new ArrayList<>();
		List<CustomizeBean> drinkSizeList = new ArrayList<>();
		List<CustomizeBean> toppingList = new ArrayList<>();

		//ListにDBの値を格納　引数はハードコーディングしか無理かな？
		iceList = customizeLogic.makeCustomizeList("ice_amount", "ice_amount_cd", "mst_ice_amount");
		drinkSizeList = customizeLogic.makeCustomizeList("drink_size", "drink_size_cd", "mst_drink_size");
		tapiokaAmountList = customizeLogic.makeCustomizeList("tapioka_amount", "tapioka_amount_cd", "mst_tapioka_amount");
		tapiokaTypeList = customizeLogic.makeCustomizeList("tapioka_kind", "tapioka_kind_cd", "mst_tapioka_kind");
		sugarList = customizeLogic.makeCustomizeList("drink_sugar", "drink_sugar_cd", "mst_drink_sugar");
		toppingList = customizeLogic.makeCustomizeList("topping", "topping_cd", "mst_topping");

		session.setAttribute("iceList", iceList);
		session.setAttribute("drinkSizeList", drinkSizeList);
		session.setAttribute("tapiokaAmountList", tapiokaAmountList);
		session.setAttribute("tapiokaTypeList", tapiokaTypeList);
		session.setAttribute("sugarList", sugarList);
		session.setAttribute("toppingList", toppingList);

	}

	public static void init(HttpServletRequest request, HttpServletResponse response) {
		initCustomize(request,response);
	}
}
