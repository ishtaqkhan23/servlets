import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/pants")
public class PantServlet extends HttpServlet {
    List<String> pants = Arrays.asList("blue_pant", "green_pant", "red_pant");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        //show items from cart
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("products") != null ){
            List<String> availableProductsInSession = (List<String>) httpSession.getAttribute("products");
            printWriter.println(availableProductsInSession);
            printWriter.println("<br/><br/>");
            printWriter.println("<br/><br/>");
            printWriter.println("<br/><br/>");
        } else {
            printWriter.println("Your cart is empty. Please shop");
            printWriter.println("<br/><br/>");
            printWriter.println("<br/><br/>");
            printWriter.println("<br/><br/>");
        }


        printWriter.println("Shop your pants here.");
        for(String str: pants){
            printWriter.println("<form action=\"cart\" method=\"post\">");
            printWriter.println("<input name=\"product\" value= \""+ str + " \" ><br/><br/>");
            printWriter.println("<button type=\"submit\">Add to cart</button>");
            printWriter.println("<br/><br/>");
            printWriter.println("<br/><br/>");
            printWriter.println("<br/><br/>");
        }

    }
}
