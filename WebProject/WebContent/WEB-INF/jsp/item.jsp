<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<h1>商品個別画面</h1>
<!--  -->
スコープから値をとってきて、
商品名、画像、説明を出力

<!-- Customizeサーブレットへ値を投げる-->
<form action="/tappy/Item" method="post">
<input type="submit" value="この商品を選択">
</form>
</body>
</html>