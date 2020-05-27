<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy - ご注文ありがとうございました</title>
</head>
<body>
ご注文が確定、完了いたしました。
ご利用ありがとうございます。
<form method="GET" action="/tappy/relay?jump=top"><%--リレー.javaで遷移？ --%>
<input type="submit" name="void" value="トップページに戻る">
</form>
</body>
</html>