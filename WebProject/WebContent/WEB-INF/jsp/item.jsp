<%@page import="model.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

<% ItemBean item = (ItemBean)request.getAttribute("item");%>
<h1><%=item.getItem()%></h1>

  <p>商品価格：\<%=item.getItemPrice()%></p>
  <a href="/tappy/Item?itemCd=<%=item.getItemCd()%>">
      <img src="<%=item.getItemImageUrl() %>">
    </a>
<p>   商品説明： <%= item.getItemText()%></p>

スコープから値をとってきて、
商品名、画像、説明を出力
→スコープからではないらしい

<!-- Customizeサーブレットへ値を投げる-->
<form action="/tappy/Customize?itemCd=<%=item.getItemCd()%>" method="post">
<input type="submit" value="この商品を選択">
</form>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>