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
 <div class="wrapper">
<h1>ログイン</h1>

<% if (request.getAttribute("loginFailed") != null){ %>
<h3>ログイン失敗しました</h3>
<%} %>

<form method="post" action="/tappy/Login">


  ユーザーID<br>
  <input type="text" name="user_id"><br>

  パスワード<br>
  <input type="password" name="password"><br>

  <input type="submit" value="ログイン">
  <a href="/tappy/Register">会員登録</a>

</form>


</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>