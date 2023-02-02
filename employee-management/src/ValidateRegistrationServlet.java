import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ValidateRegistrationServlet extends HttpServlet {
    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNum = req.getParameter("phone");

        boolean containsAlphabet = phoneNum.matches("^[a-zA-Z]*$");

        if (containsAlphabet) {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("Phone num should not contain alphabets. Go back and Please enter correct phone number.");
        } else {
            ServletContext context = servletConfig.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/register");
            dispatcher.forward(req, resp);
        }
    }
}
