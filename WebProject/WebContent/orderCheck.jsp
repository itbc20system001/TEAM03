<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--@ page import="pinyapinya" --%>>
    <%--
    型 変数 = (型) session.getAttribute("????????????????????????????????????")
    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy - ご注文内容確認</title>
</head>
<body>
<h3>お客様がご注文された内容は以下の通りです。</h3>
<h3>以下の内容でよろしければ【注文確定】のボタンを押してください。</h3>

<p>【イメージ：セッションスコープに入れられた注文内容を引っ張ってくる】</p>
<p>注文されたドリンクの分だけ配列が作られる？</p>
<p>【商品コード、サイズ、あまさ、こおり、たぴおか種、タピオカ量、とっぴんぐを表示】画像も</p>
<p>【値段、個数を表示】</p>
<p>↑を配列数だけ繰り返す</p>
<p>【合計値段を表示】</p>
<br><p>以下、例</p><br>

<form method ="POST" action="orderComplete.jsp">
<%-- for (型 i : ???[]) {--%>
	<img src="TapiocaBread" alt="タピオカドリンク・サーモンピンク味">
	<p>タピオカドリンク・サーモンピンク味【Mサイズ・マイルド、氷少、抹茶タピオカ、トッピング：生クリーム、鷹の爪】</p>
	<p>￥620 × 3</p>
	<input type="submit" name="cancel" value="取り消す">
	<input type="submit" name="change" value="変更する">
<%-- } --%>
	<h4>合計金額：￥1,860</h4>
<input type="submit" name="confirm" value="注文確定">
<input type="submit" name="return" value="戻る">
</form>
</body>
</html>