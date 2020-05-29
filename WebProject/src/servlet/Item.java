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

import model.ItemBean;

@WebServlet("/Item")
public class Item extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//menu.jspから値を受け取る
	//item.jspに投げる
	public Item() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//itemList.jspから処理が投げられる
		//全商品情報の配列は多分セッションスコープに入っている
		//受け取ったitemitem_cdをもとに①データベースから検索する②セッションスコープから全情報を取ってくる？

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
		String itemCd = request.getParameter("itemCd");
		HttpSession session = request.getSession();
		List<ItemBean> itemList = (List<ItemBean>) session.getAttribute("itemList");
		//【変更】セッションスコープから情報を取ってくる
		//ItemBean item;
		//for
		for(ItemBean itemBean:itemList) {
			int i = itemBean.getItemCd();
			if(String.valueOf(i).equals(itemCd)) {
			//	item = itemBean;
				request.setAttribute("item", itemBean);
				break;
			}
		}
		//item.jspにフォワードする
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ドリンクの値をスコープに保存？

		//customizeに処理を投げる 違った
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customize.jsp");
		//dispatcher.forward(request, response);
	}

}
