<%@ page import="tr.com.obss.jip22.demo3.BankingServlet" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Forward Demo</title>
</head>
<body>
<%

%>
<label>Enter Amount: </label><input type="text" name ="Enter" value="EnterMoney"> <br><br>
<label>Withdraw: </label><input type="text" name="Withdraw" value="Withdraw"><br><br>
<label>Deposit: </label><input type="text" name="Deposit" value="Deposit"><br><br>
<input type="button" value="Continue" name = "Continue" onclick="window.location='BankingServlet'"><br><br>
</body>
</html>