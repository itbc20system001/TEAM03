package model;

import java.util.Date;

import dao.PurchaseDAO;

//注文内容をDBに保存するクラス
public class OrderCompleteLogic {

	//memberの注文orderDateilを注文履歴に保存
	public static void leaveOrder(OrderDetailBean orderDetail,MemberBean member) {

		//ユーザー情報、注文情報、現在時刻から注文履歴を作成
		PurchaseBean pb = new PurchaseBean(
				member.getUserId(),
				orderDetail.getItemCd(),
				new Date().toString(),
				orderDetail.getPurchaseQuantity(),
				orderDetail.getDrinkSize(),
				orderDetail.getDrinkSugar(),
				orderDetail.getIceAmount(),
				orderDetail.getTapiokaKind(),
				orderDetail.getTapiokaAmount(),
				orderDetail.getTopping()
				);

		//注文履歴をDBに保存
		new PurchaseDAO().creation(pb);
	}
}
