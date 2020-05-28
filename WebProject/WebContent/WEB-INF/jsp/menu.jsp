<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<h1>メニュー</h1>
データベースから画像やらなんやらを持ってくる<br>
画像をクリックすると個別ページに飛ぶ<br>
クリックした際に画像データなどの情報をpostに持たせておけば便利？<br>
テーブルで表示したほうが見栄えがよさそうだけどきれいに書く方法があまり分からない！
<br>

<form action="/Webproject/hogehoge" method="post">
<input type="text" name="text">
<input type="submit" value="検索">
</form>
検索窓をどこに配置するかはヘッダー決めてからのほうがよさそう
</body>
</html>