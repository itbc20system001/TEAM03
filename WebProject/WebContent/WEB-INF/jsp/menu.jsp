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
p{font-size:20px; color:#b30f00; text-align:center;}
table{margin:0 auto;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


<table width="200">
<%
  List<ItemBean> itemList =(List<ItemBean>) session.getAttribute("itemList");

  int k=0;
  for(ItemBean bean:itemList){
    if(k%3==0) {
%>    <tr height="50">
    <%} %>

<td width="50" >
    <a href="/tappy/Item?itemCd=<%=bean.getItemCd()%>">
      <img src="<%=bean.getItemImageUrl() %>" style="height:250px; width:300px;">
    <p><strong><%= bean.getItem()%> </strong></p>
    </a>
</td>

<% k+=1; }%>


</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>