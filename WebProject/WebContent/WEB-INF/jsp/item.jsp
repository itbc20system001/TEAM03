<%@page import="model.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	 <div class="wrapper">
  <%
  	ItemBean item = (ItemBean) request.getAttribute("item");
  %>
   <div class="menu-item">
  <div class="menu-photo">
     <img src="<%=item.getItemImageUrl()%>">

  </div>
  <div class="menu-text">
    <h1><%=item.getItem()%></h1>
    <p>
      商品価格：&yen;<%=item.getItemPrice()%></p>
    <p>
      商品説明：
      <%=item.getItemText()%></p>
  <!-- Customizeサーブレットへ値を投げる-->
  <form action="/tappy/Customize?itemCd=<%=item.getItemCd()%>" method="post">
    <input type="submit" value="この商品を選択">
  </form>
  </div>
  </div>
  </div>
  <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>