<%@ page import="tr.com.obss.jip22.demo3.BankingServlet" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Secured JSP</title>
</head>
<body>
<%
    response.getWriter().println("Hello World !!!\n\n\n");

%>
<label>Enter word: </label><input type="text" name ="Enter" value="EnterMoney"> <br><br>
</body>
</html>