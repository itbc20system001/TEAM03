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
			System.out.println("取り消す");
			fPath = "WEB-INF/jsp/orderCheck.jsp";
		}else {

		}
		RequestDispatcher rdp = request.getRequestDispatcher(fPath);
		rdp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean a = true;
		HttpSession session = request.getSession();
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