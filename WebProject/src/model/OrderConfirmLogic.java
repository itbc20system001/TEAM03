package model;

public class OrderConfirmLogic {//注文内容ダブってたら統合

	int total=0;
	int price=0;
	int itemarray[] = new int[5];

	public void matchOrder(){
		//スコープから取得
		/*
		for (スコープに格納した配列の回数（注文数）だけ){
			if (今回注文した各種コード equals. それより前に注文した各種コード) {//コードならint型の==でOK？
				すべてtrueなら2種の注文の個数を合算（今注文したデータを削除）
				else {スコープに配列を追加}
			}
		}
		*/
	}
	public int totalPrice() {//引数にインスタンス
		for(int i : itemarray) {
			total += itemarray[i];//インスタンス配列の値段部分合計？書き方分からない
		}
		return total;
	}
}
