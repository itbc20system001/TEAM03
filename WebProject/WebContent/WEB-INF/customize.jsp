<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
  <h1>トッピング画面</h1>
  個別注文画面から遷移
  <br> 画面左側はドリンクの画像で右側でトッピング選択するとかがいいかな？
  <br> 甘さ
  <br>
  <form action="/WebProject/hogehoge" method="post">
    <select name="sugger">
      <option value="">for文でデータベースからぶん回す！</option>
    </select> <br>氷の量<br> <select name="sugger">
      <option value="">for文でデータベースからぶん回す！</option>
    </select> <br>タピオカの種類<br> <select name="sugger">
      <option value="">for文でデータベースからぶん回す！</option>
    </select> <br>タピオカの量<br> <select name="sugger">
      <option value="">for文でデータベースからぶん回す！</option>
    </select> <br>トッピング(複数選ぶならチェックボックスかなぁ)<br> <select name="sugger">
      <option value="">for文でデータベースからぶん回す！</option>
    </select> <br><input type="submit" value="決定">
  </form>
</body>
</html>