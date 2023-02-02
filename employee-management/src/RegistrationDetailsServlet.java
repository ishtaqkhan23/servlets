import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationDetailsServlet extends HttpServlet {

    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.servletConfig.getServletContext();
        String name =  String.valueOf(context.getAttribute("name"));
        String city = String.valueOf(context.getAttribute("city"));

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Your name is : "+ name);
        printWriter.println("Your city is : "+ city);

        RequestDispatcher dispatcher = context.getRequestDispatcher("/project");
        dispatcher.include(req, resp);
    }
}
