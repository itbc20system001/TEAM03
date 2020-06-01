<%@page import="model.MemberBean"%>
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
<h1>マイページ</h1>

<!-- リレーを介してmodifyUserInfoへ -->
<a href="/tappy/relay?action=modifyUserInfo">ユーザー情報を変更</a>

<!-- リレーを介してPurchaseHistoryへ -->
<a href="/tappy/relay?action=purchaseHistory">購入履歴の確認</a>

<% MemberBean user = (MemberBean)session.getAttribute("user");%>
<h2>ユーザー情報</h2>
<p style="text-align: left;">ID：<%=user.getUserId() %><br>
姓：<%=user.getUserLName() %><br>
名：<%=user.getUserFName() %><br>
住所（都道府県）：<%=user.getPrefecture() %><br>
住所（市以下）：<%=user.getAddress() %><br>
電話番号：<%=user.getTel() %><br>
メールアドレス：<%=user.getMail() %><br>
</p>
</div>



<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>