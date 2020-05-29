<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<!-- ここにヘッダー？-->
<h1>会員登録</h1>

<!-- 会員登録に失敗したときに「失敗しました」メッセージを出したい -->
<% if (request.getAttribute("registerFailed") != null){ %>
IDは既に使用済みです。別のIDを入力してください。
<%} %>
<form action="/tappy/Register" method="post">
ユーザーID：<input type="text" name="user_id"><br>
姓：<input type="text" name="user_l_name"><br>
名：<input type="text" name="user_f_name"><br>
パスワード：<input type="password" name="password"><br>
住所（都道府県）：<input type="text" name="prefecture"><br>
住所（市以下）：<input type="text" name="address"><br>
電話番号：<input type="text" name="tel"><br>
メールアドレス：<input type="text" name="mail"><br>
この内容で登録する<input type="submit" value="登録">


</form>

</body>
</html>