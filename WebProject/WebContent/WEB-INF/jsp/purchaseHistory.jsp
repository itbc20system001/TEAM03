<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.PurchaseBean,java.util.List,java.util.ArrayList"%>

<%

List<PurchaseBean> phList = (List<PurchaseBean>) session.getAttribute("PurchaseHistoryList");
List<PurchaseBean> checkList = new ArrayList<>();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
  <h1>購入履歴画面</h1>
  ユーザーIDとかを取ってきて表示
  <br> 再注文とかするボタンをつけるのがよさげ？
  <br> どこまで表示するかはちょっと考えるかな
  <br>
  <form action="/WebProject/OrderCheck" method="post">
    <table border="1">
      <tr>
        <th>注文内容</th>
        <th>チェックボックス</th>
      </tr>
      <%
      	for (PurchaseBean i : phList) {
      %>
      <tr>
        <td><%=i.getUserId()%></td>
        <td><input type="checkbox" name="purchase_Id_List" value=<%=i.getPurchaseId() %>></td>
        <!-- ここで過去の購入履歴データを選択して投げれば処理楽になるのでは？ -->
        <%
        	}
        %>
      </tr>
    </table>
    <input type="submit" name="history" value="再注文">
  </form>
</body>
</html>