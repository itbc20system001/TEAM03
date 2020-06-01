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
<style type="text/css">
a { text-decoration:none }
p{font-size:20px; color:#b30f00;}
table{text-align: center;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 <div class="wrapper">

<table width="400">
<%
  List<ItemBean> itemList =(List<ItemBean>) session.getAttribute("itemList");

  int k=0;
  for(ItemBean bean:itemList){
    if(k%3==0) {
%>    <tr height="50">
    <%} %>

<td width="100" >
    <a href="/tappy/Item?itemCd=<%=bean.getItemCd()%>">
      <img src="<%=bean.getItemImageUrl() %>" style="height:450px; width:500px;">
    <p><strong><%= bean.getItem()%> </strong></p>
    </a>
</td>

<% k+=1; }%>


</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>