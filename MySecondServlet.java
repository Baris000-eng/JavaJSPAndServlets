package tr.com.obss.jip22.demo3;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MySecondServlet", value = "/MySecondServlet")
public class MySecondServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "MySecondServlet";
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