package tr.com.obss.jip22.demo3;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    private String message;

    public void init() {

        message = "MyFirstServlet";
    }


    //override from super class
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("Response Content Type is: "+response.getContentType()+"\n");
        System.out.println("Response Writer: "+response.getWriter()+"\n");
        System.out.println("Request Authentication Type is: "+request.getAuthType()+"\n");
        System.out.println("Request Context Path is: "+request.getContextPath()+"\n");
        System.out.println("Request Dispatcher Type is: "+request.getDispatcherType()+"\n");
        System.out.println("Request Servlet Path is: "+request.getServletPath()+"\n");
        System.out.println("Requested Session ID is: "+request.getRequestedSessionId()+"\n");
        System.out.println("Request Content Type is: "+request.getContentType()+"\n");
        System.out.println("Request Attribute Names are: "+request.getAttributeNames()+"\n");
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    //Override from super class
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        System.out.println("Request Authentication Type is: "+request.getAuthType()+"\n");
        System.out.println("Request Context Path is: "+request.getContextPath()+"\n");
        System.out.println("Request Dispatcher Type is: "+request.getDispatcherType()+"\n");
        System.out.println("Request Servlet Path is: "+request.getServletPath()+"\n");
        System.out.println("Requested Session ID is: "+request.getRequestedSessionId()+"\n");
        System.out.println("Request Content Type is: "+request.getContentType()+"\n");
        System.out.println("Request Attribute Names are: "+request.getAttributeNames()+"\n");
    }
    public void destroy() {
        //Here, the jobs when the servlet is being destroyed is done.
    }
}