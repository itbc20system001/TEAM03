<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tappy</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
 <div class="wrapper">
<h1>会員登録</h1>

<!-- 会員登録に失敗したときに「失敗しました」メッセージを出したい -->
<% if (request.getAttribute("message") != null){%>
<div class="error">パスワードに使用できるのは大小アルファベット、半角数字のみです</div>
<%} %>
<% if (request.getAttribute("mailfailed") != null){%>
<div class="error">メールアドレスが不適切です</div>
<%} %>
<% if (request.getAttribute("registerFailed") != null){ %>
<div class="error">IDは既に使用済みです。別のIDを入力してください。</div>
<%} %>
<form action="/tappy/Register" method="post" onsubmit="return check();">
ユーザーID：<br><input type="text" name="user_id"><br>
姓：<br><input type="text" name="user_l_name"><br>
名：<br><input type="text" name="user_f_name"><br>
パスワード： ※パスワードに使用できるのは、半角英数字のみです<br>
<input type="password" name="password"><br>
住所（都道府県）：<br><input type="text" name="prefecture"><br>
住所（市以下）：<br><input type="text" name="address"><br>
電話番号：<br><input type="text" name="tel"><br>
メールアドレス：<br><input type="text" name="mail"><br><br>
<input type="submit" value="この内容で登録する">


</form>

<script>
  function check(){

    for(var e of document.forms[0]){

      if(e.type == "text" || e.type == "password"){
        if(e.value == ""){
          alert("入力されていない項目が存在します");
          return false;
        }
      }

    }

    return true;
  }
</script>

</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>

</html>