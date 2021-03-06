package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderDetailBean;
import model.PurchaseBean;
import model.SerchLogic;

/**
 * Servlet implementation class OrderCheck
 */
@WebServlet("/OrderCheck")
public class OrderCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderCheck() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/OrderSearch").forward(request, response);
/*		String name = request.getParameter("name");
		String fPath = "WEB-INF/jsp/orderCheck.jsp";
		if (name == null) {

		} else if ("取り消す".equals(name)) {
			//セッションスコープからデータを削除し、更新（同一ページに飛ぶ）
			//ArrayList
			fPath = "WEB-INF/jsp/orderCheck.jsp";
		} else if ("注文確定".equals(name)) {
			//注文確定したので、配達先とか決める
			fPath = "WEB-INF/jsp/derivery.jsp";
		} else if ("追加注文".equals(name)) {
			//追加注文するので、商品一覧ページに飛ばす
			fPath = "WEB-INF/jsp/menu.jsp";
		}
		RequestDispatcher rdp = request.getRequestDispatcher(fPath);
		rdp.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//商品コードはどのように送られてくるのか

		request.setCharacterEncoding("UTF-8");

		//再注文か、カスタマイズから飛んできたかを判断する
		boolean isHistoryCheak = false;

		if (request.getParameter("history") != null && request.getParameter("history").equals("再注文")) {

			isHistoryCheak = true;
		}
		HttpSession session = request.getSession();

		//HttpSession session = request.getSession();  //上にもsession定義してあるのでコメントアウトしました

		/*
		 処理内容
		 */

		List<OrderDetailBean> orderList = (List<OrderDetailBean>) session.getAttribute("orderList");

		if (orderList == null) {
			orderList = new ArrayList<>();
		} //空だったら新規ArrayList作る


		if (isHistoryCheak) {
			/*
			1．購入履歴からの場合はスコープから取得した
			情報をOrderCheck.jspに投げる
			 */
			//履歴から注文された注文Idを取得しセッションスコープに保存
			String[] purchaseIdList = request.getParameterValues("purchase_Id_List");
			session.setAttribute("purchaseIdList", purchaseIdList);

			List<PurchaseBean> purchaseHistoryList =(List<PurchaseBean>) session.getAttribute("PurchaseHistoryList");

			Function<PurchaseBean,OrderDetailBean> purchaseToOrderDetail = pb ->
				new OrderDetailBean(
						pb.getItemCd(),
						pb.getPurchaseQuantity(),
						pb.getDrinkSize(),
						pb.getDrinkSugar(),
						pb.getIceAmount(),
						pb.getTapiokaKind(),
						pb.getTapiokaAmount(),
						pb.getTopping()
						);

			List<OrderDetailBean> newOrderList = Arrays.asList(purchaseIdList).stream()
				.map( Integer::parseInt)
				.map(purchaseId ->
					SerchLogic.search(purchaseHistoryList, purchaseBean ->
						purchaseId == purchaseBean.getPurchaseId()))
				.map(purchaseToOrderDetail)
				.collect(Collectors.toList());

			orderList.addAll(newOrderList);





		} else {/*

				2. customize.jspからの場合はスコープに格納されている
				情報を購入履歴のDBに保存してからorderCheck.jspに投げる
				*/





			int itemCd = Integer.parseInt(request.getParameter("itemCd"));
			int purchaseQuantity = 1;
			int sizeCd = Integer.parseInt(request.getParameter("size"));
			int sugarCd = Integer.parseInt(request.getParameter("sugar"));
			int iceCd = Integer.parseInt(request.getParameter("ice"));
			int typeCd = Integer.parseInt(request.getParameter("type"));
			int amountCd = Integer.parseInt(request.getParameter("amount"));
			int toppingCd = Integer.parseInt(request.getParameter("topping"));

			//Arrays.asList(sizeCd,sugarCd,iceCd,typeCd,amountCd,toppingCd).forEach(System.out::println);

			OrderDetailBean orderDetail = new OrderDetailBean(itemCd, purchaseQuantity, sizeCd, sugarCd, iceCd, typeCd,
					amountCd, toppingCd);

			orderList.add(orderDetail);



		}

		session.setAttribute("orderList", orderList);//保存

		if (session.getAttribute("user") == null) {
			session.setAttribute("isJumpFromCustomize", true);
			response.sendRedirect("/tappy/Login");

		} else {

			RequestDispatcher rdp = request.getRequestDispatcher("/OrderSearch");
			rdp.forward(request, response);
		}
	}

}
