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
<p>配達場所：DAOでユーザー情報テーブルから引き出す</p>
<p>配達日：カレンダーフォーム</p>
<input type="submit" name="thank" value="決定"><%--注文確定に飛ぶ --%>
<input type="submit" name="return" value="戻る"><%--hrefで書く --%>>

</form>
</body>
</html>