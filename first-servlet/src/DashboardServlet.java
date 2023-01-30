import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DashboardServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Set response content type
        resp.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1> This is a Dashboard Page </h1>");
    }
}
