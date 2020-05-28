<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.PurchaseHistoryBean,java.util.List" %>

    <%

    List<PurchaseHistoryBean> phList = (List<PurchaseHistoryBean>) session.getAttribute("PurchaseHistoryList");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<h1>購入履歴画面</h1>
ユーザーIDとかを取ってきて表示<br>
再注文とかするボタンをつけるのがよさげ？<br>
どこまで表示するかはちょっと考えるかな<br>
<table border ="1">
<tr><th>注文内容</th><th>再注文</th></tr>
<tr><td>注文履歴データベースから表示</td>
<td><form action="/WebProject/OrderCheck" method="post">
<!-- ここで過去の購入履歴データを選択して投げれば処理楽になるのでは？ -->
<input type="submit" name="history" value="再注文">
</form></td></tr>
</table>
</body>
</html>