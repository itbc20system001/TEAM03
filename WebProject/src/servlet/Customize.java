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

/**
 * Servlet implementation class Customize
 */
@WebServlet("/Customize")
public class Customize extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Customize() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
			DBからトッピングの内容を持ってきてスコープに保存する処理を書く
			一度だけ動かせばそれで終わりかもしれない
		 */
		//ロジックをインスタンス化（Staticmethodにできないかなぁ）

		HttpSession session = request.getSession();


		List<ItemBean> itemList = (List<ItemBean>) session.getAttribute("itemList");
		//【変更】セッションスコープから情報を取ってくる
		//ItemBean item;
		//for
		String itemCd = request.getParameter("itemCd");
		for(ItemBean itemBean:itemList) {
			int i = itemBean.getItemCd();
			if(String.valueOf(i).equals(itemCd)) {
			//	item = itemBean;
				request.setAttribute("item", itemBean);
				break;
			}
		}
		RequestDispatcher rdp = request.getRequestDispatcher("WEB-INF/jsp/customize.jsp");
		rdp.forward(request, response);
	}

}
