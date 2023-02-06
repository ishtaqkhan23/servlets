import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product = req.getParameter("product");
        HttpSession httpSession = req.getSession();

        //check if "products" is present in session
        // if present then get the existing products collection and add the new product upon existing products.
        // if not present, then create new collection then add the product
        if(httpSession.getAttribute("products") != null){
            List<String> products = (List<String>) httpSession.getAttribute("products");
            products.add(product);
            httpSession.setAttribute("products",products );
        } else {
            List<String> products = new ArrayList<>();
            products.add(product);
            httpSession.setAttribute("products",products );
        }

    }
}
