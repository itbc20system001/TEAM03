package servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class OrderSearch
 */
@WebServlet("/OrderSearch")
public class OrderSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

		for (OrderDetailBean order : orderList) {

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
				if (order.getDrinkSugar() == drinkSugar.getCode()) {
					 foundDrinkSugar = drinkSugar;
					break;
				}
			}
		}

		RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/jsp/orderCheck.jsp");
		rdp.forward(request, response);

	}

}
