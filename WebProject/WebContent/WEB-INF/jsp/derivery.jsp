<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.MemberDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy - 配達場所・配送日指定</title>
</head>
<body>
<form method="GET" action="/tappy/OrderComplete">
<p><!-- ${user.prefecture} ${user.address} --></p><!--  配達場所：DAOでユーザー情報テーブルから引き出す　ラジオボタン-->
<p>配達日：カレンダーフォーム</p>
<input type="radio" name="send" value="">
<input type="radio" name="send" value="${user.pre}">
<input type="submit" name="name" value="決定"><%--注文確定に飛ぶ --%>
<input type="submit" name="name" value="戻る"><!-- 作る必要はない、余裕あったら・・・？ -->

</form>
</body>
</html>