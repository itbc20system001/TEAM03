<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy - ご注文ありがとうございました</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
ご注文が確定、完了いたしました。
ご利用ありがとうございます。
<form method="GET" action="/tappy/menu.jsp">
<input type="submit" name="void" value="トップページに戻る">
</form>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>