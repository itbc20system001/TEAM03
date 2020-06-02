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
		iceList = customizeLogic.makeCustomizeList(PassName.ice_amount);
		drinkSizeList = customizeLogic.makeCustomizeList(PassName.drink_size);
		tapiokaAmountList = customizeLogic.makeCustomizeList(PassName.tapioka_amount);
		tapiokaTypeList = customizeLogic.makeCustomizeList(PassName.tapioka_kind);
		sugarList = customizeLogic.makeCustomizeList(PassName.drink_sugar);
		toppingList = customizeLogic.makeCustomizeList(PassName.topping);

		System.out.println(iceList);

		session.setAttribute("iceList", iceList);
		session.setAttribute("drinkSizeList", drinkSizeList);
		session.setAttribute("tapiokaAmountList", tapiokaAmountList);
		session.setAttribute("tapiokaTypeList", tapiokaTypeList);
		session.setAttribute("sugarList", sugarList);
		session.setAttribute("toppingList", toppingList);

	}

	public static void initOrderDetail(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().setAttribute("orderList",new ArrayList<OrderDetailBean>());
	}

	public static void init(HttpServletRequest request, HttpServletResponse response) {
		initCustomize(request,response);
		initOrderDetail(request, response);
	}
}
