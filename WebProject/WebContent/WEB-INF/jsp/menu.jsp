<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
</head>
<body>
<header>
    <h1>Logo.img</h1>
    <nav>

      <ul>
        <li><a href="/tappy/relay?action=menu">Menu</a></li>
        <li><a href="/tappy/relay?action=contact">お問い合わせ</a></li>
        <li><a href="/tappy/relay?action=userPage">My page</a></li>
        <li><a href="/tappy/relay?action=login">Login</a></li>
      </ul>
    </nav>
  </header>

<form action="/Webproject/hogehoge" method="post">
<input type="text" name="text">
<input type="submit" value="検索">
</form>

<footer>
    <ul>
        <li><a href="/tappy/relay?action=menu">Menu</a></li>
        <li><a href="/tappy/relay?action=contact">お問い合わせ</a></li>
        <li><a href="/tappy/relay?action=userPage">My page</a></li>
        <li><a href="/tappy/relay?action=login">Login</a></li>
    </ul>
    <h4>内容が空っぽに見えれば会社の情報など適当に</h4>
  </footer>
</body>
</html>