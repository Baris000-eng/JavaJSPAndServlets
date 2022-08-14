package tr.com.obss.jip22.demo3;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.util.*;

@WebServlet(name = "Secured", value = "/Secured")
public class Secured extends HttpServlet {

    public Secured () {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         super.doPost(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String url = req.getRequestURL().toString();
        String param = req.getParameter("Enter");
        url+= param;
        String sec = "Secured";
        if(url.contains(sec) || url.contains(sec.toUpperCase()) || url.contains(sec.toLowerCase()))  {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN); // send 403 error message
        }
    }
}
