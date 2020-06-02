<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
    #menu {height:50px; background-color:#b30f00;margin-bottom:50px;}
    ul { width:1000px; margin:0 auto;}
    ul li{list-style-type:none; float:left;  width:150px; margin-top:10px;}
    ul li a{color:#ffffff; text-decoration:none; font-size:20px;}
    a{margin-left:20px;}
</style>

<header>


      <a href="/tappy/">
      <img src="/tappy/img/tappy_logo.png" height="120" ></a>

      <nav id="menu">
      <ul>
        <li><a href="/tappy/relay?action=menu">Menu</a></li>
        <li><a href="/tappy/relay?action=contact">お問い合わせ</a></li>
        <li><a href="/tappy/relay?action=userPage">My page</a></li>
            <%if(session.getAttribute("user")==null){ %>
              <li><a href="/tappy/relay?action=login">Login</a><li>

            <%}else{ %>
              <li><a href="/tappy/relay?action=logout">Logout</a></li>
              <li><div style="color:#ffff00; font-size:20px; padding-bottom:30px;" ><strong>${user.userId}さん</strong></div></li>
            <%} %>
      </ul>
    </nav>


</header>
