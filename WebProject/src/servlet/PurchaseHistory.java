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

import model.ItemListLogic;
import model.PurchaseBean;
import model.PurchaseHistoryLogic;

/**
 * Servlet implementation class PuchaseHistory
 */
@WebServlet("/PurchaseHistory")
public class PurchaseHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 購入履歴を取得する処理
		 注文するたびに更新されるので毎回呼び出す必要性あり？
		 */


		HttpSession session = request.getSession();
		if(session.getAttribute("itemList") == null) {
			session.setAttribute("itemList", ItemListLogic.itemList());
		}
		List<PurchaseBean> historyList = new ArrayList<>();
		PurchaseHistoryLogic phLogic = new PurchaseHistoryLogic();
		historyList = phLogic.makeHistoryList(session);
		session.setAttribute("PurchaseHistoryList", historyList);

		RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/jsp/purchaseHistory.jsp");
		rdp.forward(request, response);
	}

}
