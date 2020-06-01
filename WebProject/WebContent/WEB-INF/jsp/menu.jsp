<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.ItemBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form action="/Webproject/hogehoge" method="post">
<input type="text" name="text">
<input type="submit" value="検索">
</form>

<table width="900">
<%
  List<ItemBean> itemList =(List<ItemBean>) session.getAttribute("itemList");

  int k=0;
  for(ItemBean bean:itemList){
    if(k%3==0) {
%>    <tr height="50">
    <%} %>

<td width="300" >
    <a href="/tappy/Item?itemCd=<%=bean.getItemCd()%>">
      <img src="<%=bean.getItemImageUrl() %>">
    </a>
    <p><%= bean.getItemText()%></p>
</td>

<% k+=1; }%>


</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>