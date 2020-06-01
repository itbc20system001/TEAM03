<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy -お問い合わせ-</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="wrapper">
<h1>お問い合わせ</h1>
<form method="post" action="/tappy/ContactSend">
	<div>
	お問い合わせの種類<br>
	<select>
		<option  value="delivery">宅配・配送について</option>
		<option  value="item">商品について</option>
		<option  value="company">企業について</option>
		<option  value="other">その他</option>
	</select>
	</div>
	<div>
		Tappyをご利用いただくのは何回目ですか？<br>
		<label><input type="radio" name="exp" value="try" checked>初めて</label>
		<label><input type="radio" name="exp" value="few"        >2～3回</label>
		<label><input type="radio" name="exp" value="some"       >4～6回</label>
		<label><input type="radio" name="exp" value="several"    >7～10回</label>
		<label><input type="radio" name="exp" value="most"       >10回より多い</label>
	</div>
	<div>
		Tappyをお知りになったきっかけは何ですか？<br>
		<label><input type="checkbox" name="cause" value="sns"      >SNSで</label>
		<label><input type="checkbox" name="cause" value="friends"  >友人からの紹介</label>
		<label><input type="checkbox" name="cause" value="web"      >Webサイトから</label>
		<label><input type="checkbox" name="cause" value="radio"    >ラジオで</label>
		<label><input type="checkbox" name="cause" value="other"    >その他</label>
	</div>
	<div>
		<label>お問い合わせの内容<br><textarea name="message"></textarea></label>
	</div>
	<div>
		<input type="submit" name="submit" value="送信">
	</div>

</form>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>