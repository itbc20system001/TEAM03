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

import model.OrderDetailBean;
import model.PurchaseBean;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String fPath = "WEB-INF/jsp/orderCheck.jsp";
		if(name==null) {

		}else if("取り消す".equals(name)) {
			//セッションスコープからデータを削除し、更新（同一ページに飛ぶ）
			//ArrayList
			fPath = "WEB-INF/jsp/orderCheck.jsp";
		}else if("注文確定".equals(name)){
			//注文確定したので、配達先とか決める
			fPath = "WEB-INF/jsp/derivery.jsp";
		}else if("追加注文".equals(name)){
			//追加注文するので、商品一覧ページに飛ばす
			fPath = "WEB-INF/jsp/menu.jsp";
		}
		RequestDispatcher rdp = request.getRequestDispatcher(fPath);
		rdp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品コードはどのように送られてくるのか
		HttpSession session = request.getSession();
		request.getParameterValues("purchase_Id_List");
		List<OrderDetailBean> orderList = (List<OrderDetailBean>)session.getAttribute("orderList");

		if (orderList == null) {
			orderList = new ArrayList<>();
		}//空だったら新規ArrayList作る


		int itemCd = 1;
		int purchaseQuantity = 1;
		int sizeCd = Integer.parseInt(request.getParameter("size"));
		int sugarCd = Integer.parseInt(request.getParameter("sugar"));
		int iceCd = Integer.parseInt(request.getParameter("ice"));
		int typeCd = Integer.parseInt(request.getParameter("type"));
		int amountCd = Integer.parseInt(request.getParameter("amount"));
		int toppingCd = Integer.parseInt(request.getParameter("topping"));

		OrderDetailBean orderDetail = new OrderDetailBean(itemCd, purchaseQuantity, sizeCd, sugarCd, iceCd, typeCd, amountCd, toppingCd);

		orderList.add(orderDetail);

		session.setAttribute("orderList", orderList);//保存


		boolean a = true;
		//HttpSession session = request.getSession();  //上にもsession定義してあるのでコメントアウトしました
		List<PurchaseBean> pHList = new ArrayList<>();
		pHList = (List<PurchaseBean>) session.getAttribute("PurchaseHistoryList");

		/*
		 処理内容
		 1．購入履歴からの場合はスコープから取得した
		    情報をOrderCheck.jspに投げる
		 */
		if(a) {

		}else{/*

		 2. customize.jspからの場合はスコープに格納されている
		    情報を購入履歴のDBに保存してからorderCheck.jspに投げる
		 */

			if(request.getParameter("name").equals("history")) {
				//HttpSession session = request.getSession();
				//セッションスコープからインスタンス取得、p220から やり方が分からん・・・
				//PurchaseHistoryBean ph =(PurchaseHistoryBean) session.getAttribute("")
			}
			if(request.getParameter("name").equals("customize")) {

			}

			RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/jsp/orderCheck.jsp");
			rdp.forward(request, response);
		}

	}
}