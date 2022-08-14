package tr.com.obss.jip22.demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SearchContactServlet", value = "/SearchContactServlet")
public class SearchContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher r = req.getRequestDispatcher("search-contact.jsp");
        r.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");

        //response.setContentType("text/html; charset=ISO-8859-1");
        PrintWriter out = response.getWriter();

        java.sql.Connection con = null;
        java.sql.PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/Contacts";
        String user = "barissss";
        String password = "root";

        try {
            name = request.getParameter("name");
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("SELECT * FROM Contacts WHERE Name ='" + name + "';");
            if (pst != null) {
                rs = pst.executeQuery();
                response.sendRedirect(request.getContextPath() + "/EditContact.jsp");
            } else {
                System.out.println("Contact Not Found !!!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


