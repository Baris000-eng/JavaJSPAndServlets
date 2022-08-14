package tr.com.obss.jip22.demo3;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.util.*;

@WebServlet(name = "MyFirstServlet", value = "/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
    private String message;

    public void init() {

        message = "MyFirstServlet";
    }

    //override from super class
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    //Override from super class
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.getWriter().print("<h1> "+message+" <h1>");
    }
    public void destroy() {
         //Here, the jobs when the servlet is being destroyed is done.
    }
}