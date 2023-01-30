import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RegistrationServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Employee employee= new Employee();
        employee.setName(req.getParameter("name"));
        employee.setCity(req.getParameter("city"));
        employee.setSalary(Integer.parseInt(req.getParameter("salary")));

        //date conversion logic - from string to java date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date joinDate = null;
        try {
            joinDate = dateFormat.parse(req.getParameter("joindate"));
        } catch (ParseException e) {
            System.out.println("Incorrect date format provided");
        }
        employee.setJoinDate(joinDate);

        employee.setPhoneNumber(req.getParameter("phone"));

        System.out.println(employee);

        saveNewEmployee(employee);
    }

    private void saveNewEmployee(Employee employee) {
        try {
            //step1: load driver class
            Class.forName("com.mysql.jdbc.Driver");

            //step2: establish a connection by providing connection url, username and password.
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mycompany", "root", "root");

            String insertStmt = "insert into employee values(?,?,?,?,?,?)";

            //step3: create a statement object on connection obj
            PreparedStatement stmt = con.prepareStatement(insertStmt);

            // initialize a Random object somewhere; you should only need one
            Random random = new Random();
            // generate a random integer from 0 to 899, then add 100
            int x = random.nextInt(900) + 100;
            stmt.setInt(1, x);

            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getCity());
            stmt.setInt(4, employee.getSalary());
            stmt.setDate(5, new java.sql.Date(employee.getJoinDate().getTime()));
            stmt.setString(6, employee.getPhoneNumber());


            stmt.execute();

            //step6: close the connection obj
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found : "+e);
        } catch (SQLException e) {
            System.out.println("SQL Exception : "+ e);
        }
    }
}


