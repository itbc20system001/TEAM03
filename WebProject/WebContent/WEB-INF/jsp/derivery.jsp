<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.MemberDAO, model.MemberBean" %>
<%
//MemberBean user = (MemberBean) session.getAttribute("user");
MemberBean user = new MemberBean("suzuiti","鈴木","一郎","suzukisan","東京都","三鷹市の山の中","0120333906","hogehoge@hogehoge.com");

%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
var date = new Date();

var yyyy = date.getFullYear();
var mm = ("0"+(date.getMonth()+1)).slice(-2);
var dd = ("0"+date.getDate()).slice(-2);

document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;

var dd = ("0"+date.getDate()-1).slice(-2);
document.getElementById("limitpast").value=yyyy+'-'+mm+'-'+dd;

</script>
<head>
<meta charset="UTF-8">
<title>Tappy - 配達場所・配送日指定</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<form method="GET" action="/tappy/OrderComplete">
<p>配達先を指定してください：</p>
<p><input type="radio" name="send" value="<%=user.getPrefecture()%> <%=user.getAddress()%>"></p>
<p>配達日を指定してください：</p>
<p><input type="date" value=today min=limitpast></p>
<br><input type="submit" name="name" value="決定"><!-- 注文確定に飛ぶ -->
<input type="submit" name="name" value="戻る"><!-- 作る必要はない、余裕あったら・・・？ -->

</form>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>