<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.ItemBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<header>
    <h1>Logo.img</h1>
    <nav>

      <ul>
        <li><a href="/tappy/relay?action=menu">Menu</a></li>
        <li><a href="/tappy/relay?action=contact">お問い合わせ</a></li>
        <li><a href="/tappy/relay?action=userPage">My page</a></li>
        <li><a href="/tappy/relay?action=login">Login</a></li>
        <li><a href="/tappy/relay?action=register">会員登録</a></li>
      </ul>
    </nav>
  </header>

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
<footer>
    <ul>
        <li><a href="/tappy/relay?action=menu">Menu</a></li>
        <li><a href="/tappy/relay?action=contact">お問い合わせ</a></li>
        <li><a href="/tappy/relay?action=userPage">My page</a></li>
        <li><a href="/tappy/relay?action=login">Login</a></li>
        <li><a href="/tappy/relay?action=register">会員登録</a></li>
    </ul>
    <h4>内容が空っぽに見えれば会社の情報など適当に</h4>
  </footer>
</body>
</html>