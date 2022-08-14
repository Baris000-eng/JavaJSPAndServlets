package tr.com.obss.jip22.demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BalanceServlet", value = "/balance")
public class BalanceServlet extends HttpServlet {
   private int bal;
   private Object lockedForGet = new Object();
   private Object lockedForPost = new Object();

    public void init() {
        System.out.println("Hi there !!! \n");

    }

    //override from super class
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        synchronized (lockedForGet) {
            final String amount = request.getParameter("amount");
            if (amount == null || amount.trim().length() <= 0) {
                response.getWriter().println(String.format("Balance is: %s", this.bal));
                return;
            }

            final int price = Integer.parseInt(amount);
            if(price < 0) {
                throw new ArithmeticException();
            } else if (price == 0) {
                response.getWriter().println(String.format("Balance is: %s", this.bal));
                return;
            }

            if (price < 0 && (price * -1) > bal) {
                response.getWriter().println(String.format("The Balance is: %s, Amount: %s", this.bal, amount));
                return;
            }

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.bal = this.bal + price;
        }
        response.getWriter().println(String.format("The updated balance is: %s \n", this.bal));
    }

    //Override from super class
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
         super.doPost(request,response);
         synchronized (lockedForPost) {
             System.out.println("Hello World !!! \n");
         }
    }
    public void destroy() {
        //Here, the jobs when the servlet is being destroyed is done.
    }
}