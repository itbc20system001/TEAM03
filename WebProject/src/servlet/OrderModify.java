package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderDetailBean;

/**
 * Servlet implementation class OrderModify
 */
@WebServlet("/OrderModify")
public class OrderModify extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String modify = (String)request.getParameter("modify");

		List<OrderDetailBean> orderList = (List<OrderDetailBean>) session.getAttribute("orderList");
		int orderId = Integer.parseInt(request.getParameter("orderId"));

		if(modify.equals("取り消す")) {

			orderList.remove(orderId);
			session.setAttribute("orderList", orderList);


			request.getRequestDispatcher("/OrderSearch").forward(request, response);
		}else if(modify.equals("変更する")) {


			int itemCd = orderList.get(orderId).getItemCd();


			//削除処理
			orderList.remove(orderId);
			session.setAttribute("orderList", orderList);

			response.sendRedirect("/tappy/Customize?itemCd="+itemCd);



		}

	}

}
