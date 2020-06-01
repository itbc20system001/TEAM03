package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomizeBean;
import model.ItemBean;
import model.OrderDetailBean;
import model.OrderDetailRawBean;

/**
 * Servlet implementation class OrderSearch
 */
@WebServlet("/OrderSearch")
public class OrderSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<ItemBean> itemList = (List<ItemBean>) session.getAttribute("itemList");

		List<CustomizeBean> drinkSizeList = (List<CustomizeBean>) session.getAttribute("drinkSizeList");
		List<CustomizeBean> sugarList = (List<CustomizeBean>) session.getAttribute("sugarList");
		List<CustomizeBean> iceList = (List<CustomizeBean>) session.getAttribute("iceList");
		List<CustomizeBean> tapiokaTypeList = (List<CustomizeBean>) session.getAttribute("tapiokaTypeList");
		List<CustomizeBean> tapiokaAmountList = (List<CustomizeBean>) session.getAttribute("tapiokaAmountList");
		List<CustomizeBean> toppingList = (List<CustomizeBean>) session.getAttribute("toppingList");

		List<OrderDetailBean> orderList = (List<OrderDetailBean>) session.getAttribute("orderList");

		List<OrderDetailRawBean> rawOrderList = new ArrayList<>();
		orderList.forEach(System.out::println);



		for (OrderDetailBean order : orderList) {

			if(order == null) {
				rawOrderList.add(null);
				continue;
			}

			ItemBean foundItem = null;
			for (ItemBean item : itemList) {
				if (order.getItemCd() == item.getItemCd()) {
					foundItem = item;
					break;
				}
			}

			CustomizeBean foundDrinkSize = null;
			for (CustomizeBean drinkSize : drinkSizeList) {
				if (order.getDrinkSize() == drinkSize.getCode()) {
					 foundDrinkSize = drinkSize;
					break;
				}
			}

			CustomizeBean foundDrinkSugar = null;
			for (CustomizeBean drinkSugar : sugarList) {
				if (order.getDrinkSugar() == drinkSugar.getCode()) {
					 foundDrinkSugar = drinkSugar;
					break;
				}
			}

			CustomizeBean foundIceAmount = null;
			for (CustomizeBean iceAmount : iceList) {
				if (order.getIceAmount() == iceAmount.getCode()) {
					 foundIceAmount = iceAmount;
					break;
				}
			}

			CustomizeBean foundTapiokaKind = null;
			for (CustomizeBean tapiokaKind : tapiokaTypeList) {
				if (order.getTapiokaKind() == tapiokaKind.getCode()) {
					 foundTapiokaKind = tapiokaKind;
					break;
				}
			}

			CustomizeBean foundTapiokaAmount = null;
			for (CustomizeBean tapiokaAmount : tapiokaAmountList) {
				if (order.getTapiokaAmount() == tapiokaAmount.getCode()) {
					 foundTapiokaAmount= tapiokaAmount;
					break;
				}
			}
			CustomizeBean foundTopping = null;
			for (CustomizeBean topping : toppingList) {
				if (order.getTopping() == topping.getCode()) {
					foundTopping = topping;
					break;
				}
			}

			OrderDetailRawBean rawOrder= new  OrderDetailRawBean(
					foundItem,
					order.getPurchaseQuantity(),
					foundDrinkSize,
					foundDrinkSugar,
					foundIceAmount,
					foundTapiokaKind,
					foundTapiokaAmount,
					foundTopping
					);

			System.out.println(rawOrder);

			rawOrderList.add(rawOrder);

		}

		rawOrderList.forEach(System.out::println);

		session.setAttribute("rawOrderList", rawOrderList);

		RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/jsp/orderCheck.jsp");
		rdp.forward(request, response);

	}

}
