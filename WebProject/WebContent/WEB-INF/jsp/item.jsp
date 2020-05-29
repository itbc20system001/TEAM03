<%@page import="model.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<h1>商品個別画面</h1>
<!--  -->
<% ItemBean item = (ItemBean)request.getAttribute("item");%>

  <p><%=item.getItem()%></p>
  <p><%=item.getItemPrice()%></p>
  <a href="/tappy/Item?itemCd=<%=item.getItemCd()%>">
      <img src="<%=item.getItemImageUrl() %>">
    </a>
    <p><%= item.getItemText()%></p>

スコープから値をとってきて、
商品名、画像、説明を出力
→スコープからではないらしい

<!-- Customizeサーブレットへ値を投げる-->
<form action="/tappy/Customize?itemCd=<%=item.getItemCd()%>" method="post">
<input type="submit" value="この商品を選択">
</form>
</body>
</html>