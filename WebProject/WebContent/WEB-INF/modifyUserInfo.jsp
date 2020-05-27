<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<h1>ユーザー情報の変更</h1>
<!-- 各テキストフィールドには現在のユーザー情報をデフォルトで入れたい -->
<form method="post" action="/tappy/ModifyUserInfo">
  ユーザーID<br>
  <input type="text" name="user_id"><br>
  姓<br>
  <input type="text" name="user_l_name"><br>
  名<br>
  <input type="text" name="user_f_name"><br>
  パスワード<br>
  <input type="password" name="password"><br>
  都道府県<br>
  <input type="text" name="prefecture"><br>
  住所（市以下）<br>
  <input type="text" name="address"><br>
  電話番号<br>
  <input type="text" name="tel"><br>
  メールアドレス<br>
  <input type="text" name="mail"><br>

  <input type="submit" value="変更">

</form>
</body>
</html>