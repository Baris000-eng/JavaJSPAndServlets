package tr.com.obss.jip22.demo3;

import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BankingServlet", value = "/BankingServlet")
public class BankingServlet extends HttpServlet {
    private static int money = 999;

    public static
    int getMoney() {
        return money;
    }

    public static
     void setMoney(int money) {

        BankingServlet.money = money;
    }

    public BankingServlet() {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        money = money + 1000;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1> The Current Balance is : " + money + " TL </h1>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        try {
            req.getRequestDispatcher("atm.jsp").forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}








