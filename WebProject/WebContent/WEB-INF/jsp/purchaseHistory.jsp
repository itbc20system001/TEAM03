<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.PurchaseBean,java.util.List,java.util.ArrayList,model.ItemBean"%>

<%

List<PurchaseBean> phList = (List<PurchaseBean>) session.getAttribute("PurchaseHistoryList");
List<PurchaseBean> checkList = new ArrayList<>();
List<ItemBean> itemList =(List<ItemBean>) session.getAttribute("itemList");

%>
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
  <h1>購入履歴画面</h1>

  <br>
  <form action="/tappy/OrderCheck" method="post" onsubmit="return check();">
    <table border="1">
      <tr>
        <th>注文内容</th>
        <th>チェックボックス</th>
      </tr>
      <%
      	for (PurchaseBean i : phList) {
      %>
      <tr>
        <td>
          <%
        	for(ItemBean j: itemList){
                  if(i.getItemCd() == j.getItemCd()){ %> <a href="/tappy/Item?itemCd=<%=j.getItemCd()%>"> <img src="<%=j.getItemImageUrl() %>">
        </a>
          <p><%= j.getItemText()%></p> <%
                  }
                }
        %>
        </td>
        <td><input type="checkbox" name="purchase_Id_List" value=<%=i.getPurchaseId() %>></td>
        <!-- ここで過去の購入履歴データを選択して投げれば処理楽になるのでは？ -->
        <%
        	}
        %>
      </tr>
    </table>
    <% if(!phList.isEmpty()) {%>
      <input type="submit" name="history" value="再注文">
    <%} %>

  </form>
  </div>
  <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

<script>
	function check(){

	  for(var e of document.forms[0]){
	    if(e.type == "checkbox"){
	      if(e.checked){
	        return true;
	      }
	    }

	  }
	  alert("チェックがされていません");
	  return false;
	}
</script>
</body>
</html>