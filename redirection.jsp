<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>MySecondServlet</title>
</head>
<body>
<h1><%= "MySecondServlet" %>
</h1>
<br/>
<html>
<body>
<%
    String name = request.getParameter("fname");
    String surname = request.getParameter("lname");
    String email = request.getParameter("email");
    String university = request.getParameter("uniName");
    String department = request.getParameter("department");
    response.getWriter().println("Your Name is: "+name+"<br/>");
    response.getWriter().println("Your Surname is: "+surname+"<br/>");
    response.getWriter().println("Your Email is: "+email+"<br/>");
    response.getWriter().println("Your University is: "+university+"<br/>");
    response.getWriter().println("Your Department is: "+department+"<br/>");
    try {
        if (name.length() > 5) { //more than 5 chars
            response.getWriter().println("Hi " + name + " !!! Your name has more than 5 charachters");
        } else if (3 <= name.length() && name.length() <= 5 ) {
            response.getWriter().println("Hi " + name + " !!! Character number of your name is  between 3 and 5 (inclusive)");
        } else {
            System.out.println(name.length());
            if(name.equals("")){ //empty string value
                response.getWriter().println("Empty string !!");
            } else {
                response.getWriter().println("A string with less than 3 charachters is provided !!!");
            }
        }
    } catch (NullPointerException npe) {
        response.getWriter().println(npe.getMessage());
    }
%>
</form>
<input type="button" value="Change Page" onclick="window.location='index.jsp'" >
</body>
</html>