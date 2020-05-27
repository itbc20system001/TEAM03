<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<h1>マイページ</h1>
<!-- サーブレットを介さずmodifyUserInfoへ -->
<form action="ユーザー情報変更ページへ" method="post">
<input type="submit" value="ユーザー情報を変更"><br>
</form>
<!-- サーブレットを介さずPurchaseHistoryへ -->
<form action="購入履歴画面へ" method="post">
<input type="submit" value="購入履歴の確認"><br>
</form>
<h2>ユーザー情報</h2>
ID：<br>
姓：<br>
名：<br>
パスワード（不要？）：<br>
住所（都道府県）：<br>
住所（市以下）：<br>
電話番号：<br>
メールアドレス：<br>




</body>
</html>