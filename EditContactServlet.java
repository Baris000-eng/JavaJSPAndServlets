package tr.com.obss.jip22.demo3.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.RequestDispatcher;
import tr.com.obss.jip22.demo3.DatabaseConnection;
import tr.com.obss.jip22.demo3.Model.Contact;

import java.io.IOException;

public class EditContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("edit-contact.jsp");
        rd.forward(req,res);

        String name = req.getParameter("name");
        String gsm = req.getParameter("gsm");
       // Contact.setName(name);
        // Contact.setGsm(gsm);
        DatabaseConnection.connectDatabase();


        RequestDispatcher rDis = req.getRequestDispatcher("operation-successful.jsp");
        rDis.forward(req,res);




    }
}
