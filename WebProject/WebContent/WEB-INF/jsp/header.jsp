<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    #menu{height:50px; background-color:#b30f00; }
    ul li{list-style-type:none; float:left; margin-left:40px; }
    ul li a{color:#ffffff; text-decoration:none;}
</style>

</head>
<body>
<header>
<table width="1000">
      <tr height="50">
      <a href="/tappy/">
      <h1 id="logo"><img src="/tappy/img/tappy_logo.png" height="120" ></a>

      <nav id="menu">
      <ul>
        <li><a href="/tappy/relay?action=menu">Menu</a></li>
        <li><a href="/tappy/relay?action=contact">お問い合わせ</a></li>
        <li><a href="/tappy/relay?action=userPage">My page</a></li>
        <li><a href="/tappy/relay?action=login">Login</a></li>
      </ul>
    </nav>

  </header>
  </table>
</body>
</html>