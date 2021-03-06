<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberBean" %>

    <%
      MemberBean user = (MemberBean)session.getAttribute("user");
    %>
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
<h1>ユーザー情報の変更</h1>

<% if (request.getAttribute("mailfalse") != null){%>
<div class="error">メールアドレスが不適切です</div>
<%} %>

<% if(request.getAttribute("modifyFailed") != null) {%>
<div class="error">ユーザー情報の変更に失敗</div>
<%} %>
<!-- 各テキストフィールドには現在のユーザー情報をデフォルトで入れたい（済） -->
<form method="post" action="/tappy/ModifyUserInfo">
<!--
  ユーザーID<br>
  <input type="text" name="user_id" value=${user.userId} ><br>
-->
  ユーザーID<br>
  ${user.userId}<br>

  姓<br>
  <input type="text" name="user_l_name" value=${user.userLName}><br>
  名<br>
  <input type="text" name="user_f_name" value=${user.userFName}><br>

 <!--
  パスワード<br>
  <input type="password" name="password" value=${user.password}><br>
  -->

  都道府県<br>
  <input type="text" name="prefecture" value=${user.prefecture}><br>
  住所（市以下）<br>
  <input type="text" name="address" value=${user.address}><br>
  電話番号<br>
  <input type="text" name="tel" value=${user.tel}><br>
  メールアドレス<br>
  <input type="text" name="mail" value=${user.mail}><br>

  <input type="submit" value="変更">
  <a href="/tappy/UserPage">キャンセル</a>

</form>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>