<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
  #menu1 {height:50px;border-top: 3px dotted #b30f00; margin-top:50px;padding-top: 30px; padding-bottom:100px;}
  ul li{list-style-type:none; float:left; margin-left:40px; }
  #menu1 ul li a{color:#f2822c;}
</style>

<footer id="menu1">
    <ul>
        <li><a href="/tappy/relay?action=menu">Menu</a></li>
        <li><a href="/tappy/relay?action=contact">お問い合わせ</a></li>
        <li><a href="/tappy/relay?action=userPage">My page</a></li>
        <%if(session.getAttribute("user")==null){ %>
              <li><a href="/tappy/relay?action=login">Login</a><li>

            <%}else{ %>
              <li><a href="/tappy/relay?action=orderCheck">注文内容</a></li>
              <li><a href="/tappy/relay?action=logout">Logout</a></li>
              <%} %>
    </ul><br><br><br>
    <p style="text-align:center;">© 株式会社タッピ</p>

  </footer>
