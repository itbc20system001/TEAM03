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
 <div class="wrapper">
ご注文が確定、完了いたしました。<br>
ご利用ありがとうございます。<br>
商品受け取りコードは　<%= (String)request.getAttribute("recieveCode") %>　です。<br>
<a href="/tappy/">トップページへ戻る</a>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>