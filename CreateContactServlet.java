package tr.com.obss.jip22.demo3.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.RequestDispatcher;
import tr.com.obss.jip22.demo3.Contact;
import tr.com.obss.jip22.demo3.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateContactServlet", value = "/CreateContactServlet")
public class CreateContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("create-contact.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String gsm = request.getParameter("gsm");
        Contact contact = new Contact(name, gsm);
        contact.setName(name);
        contact.setGsm(gsm);
        try {
            DatabaseConnection.addContact(contact.getName(),contact.getGsm());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("message", "A contact is created");
        RequestDispatcher rd = request.getRequestDispatcher("operation-successful.jsp");
        rd.forward(request,response);
    }
}
