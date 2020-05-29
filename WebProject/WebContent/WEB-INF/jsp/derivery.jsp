<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.MemberDAO" %>

<!DOCTYPE html>
<html>
<script type="text/javascript">
var date = new Date();

var yyyy = date.getFullYear();
var mm = ("0"+(date.getMonth()+1)).slice(-2);
var dd = ("0"+date.getDate()).slice(-2);

document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;

var dd = ("0"+date.getDate()).slice(-2);
document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;

</script>
<head>
<meta charset="UTF-8">
<title>Tappy - 配達場所・配送日指定</title>
</head>
<body>
<form method="GET" action="/tappy/OrderComplete">
<p><!-- ${user.prefecture} ${user.address} --></p><!--  配達場所：DAOでユーザー情報テーブルから引き出す　ラジオボタン-->
<p>配達日：カレンダーフォーム</p>
<input type="radio" name="send" value="today" min=""><!-- valueの中に住所のEL式入れたい -->
<input type="date">
<input type="submit" name="name" value="決定"><%--注文確定に飛ぶ --%>
<input type="submit" name="name" value="戻る"><!-- 作る必要はない、余裕あったら・・・？ -->

</form>
</body>
</html>