<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>MyFirstServlet</title>
    <style>
        body {
            background-color: Red;
            font: 18px Arial, times-new-roman;
            font-weight: bold;
            opacity: 0.7;
        }
        input[type=text] {
            width: 20%;
            padding: 13px 19px;
            margin: 11px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            background-color: aqua;
        }
        input[type=submit] {
            width: 15%;
            padding: 13px 19px;
            margin: 11px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            background-color: green;
        }
    </style>
</head>
<body>
<h1><%= "MyFirstServlet" %>
</h1>
<form action="redirection.jsp">
    <label>Login Form:</label><br><br>
    <label>Name: </label><input type="text" name="fname"><br><br>
    <label>Surname: </label><input type="text" name="lname"><br><br>
    <label>Email Address:  </label><input type="text" name = "email"><br><br>
    <label>University Name: </label><input type="text" name = "uniName"><br><br>
    <label>Department Name: </label><input type="text" name = "department"><br><br>
    <label>Submit: </label> <input type="submit" value="Submit" onclick="window.location='redirection.jsp'" >
</form>
<br/>
<a href= "mailto:bkaplan18@ku.edu.tr">Email</a>
</body>
</html>