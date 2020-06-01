<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.CustomizeBean,java.util.List,model.ItemBean"%>

<%
	List<CustomizeBean> iceList = (List<CustomizeBean>) session.getAttribute("iceList");
	List<CustomizeBean> drinkSizeList = (List<CustomizeBean>) session.getAttribute("drinkSizeList");
	List<CustomizeBean> tapiokaAmountList = (List<CustomizeBean>) session.getAttribute("tapiokaAmountList");
	List<CustomizeBean> tapiokaTypeList = (List<CustomizeBean>) session.getAttribute("tapiokaTypeList");
	List<CustomizeBean> sugarList = (List<CustomizeBean>) session.getAttribute("sugarList");
	List<CustomizeBean> toppingList = (List<CustomizeBean>) session.getAttribute("toppingList");
   ItemBean item = (ItemBean)request.getAttribute("item");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
  <h1>トッピング画面</h1>
  個別注文画面から遷移
  <br> 画面左側はドリンクの画像で右側でトッピング選択するとかがいいかな？
  <br> ドリンクのサイズ
  <br>
  <form action="/tappy/OrderCheck" method="post">
    <select name="size">
      <%
      	for (CustomizeBean i : drinkSizeList) {
      %>
      <option value=<%=i.getCode()%>><%=i.getCustomize()%></option>
      <%
      	}
      %>
    </select><br>甘さ<br> <select name="sugar">
      <%
      	for (CustomizeBean i : sugarList) {
      %>
      <option value=<%=i.getCode()%>><%=i.getCustomize()%></option>
      <%
      	}
      %>
    </select> <br>氷の量<br> <select name="ice">
      <%
      	for (CustomizeBean i : iceList) {
      %>
      <option value=<%=i.getCode()%>><%=i.getCustomize()%></option>
      <%
      	}
      %>
    </select> <br>タピオカの種類<br> <select name="type">
      <%
      	for (CustomizeBean i : tapiokaTypeList) {
      %>
      <option value=<%=i.getCode()%>><%=i.getCustomize()%></option>
      <%
      	}
      %>
    </select> <br>タピオカの量<br> <select name="amount">
      <%
      	for (CustomizeBean i : tapiokaAmountList) {
      %>
      <option value=<%=i.getCode()%>><%=i.getCustomize()%></option>
      <%
      	}
      %>
    </select> <br>トッピング(複数選ぶならチェックボックスかなぁ)<br> <select name="topping">
      <%
      	for (CustomizeBean i : toppingList) {
      %>
      <option value=<%=i.getCode()%>><%=i.getCustomize()%></option>
      <%
      	}
      %>
    </select> <br>
    <input name="customize" type="submit" value="決定">
  </form>
</body>
</html>