package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("MyPage.jsp");
        dispatcher.include(req, resp);

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT (id, name, age, email) FROM users");

            while(resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String age = resultSet.getString(3);
                String email = resultSet.getString(4);

                req.setAttribute(id, "id1");
                req.setAttribute(name, "name1");
                req.setAttribute(age, "age1");
                req.setAttribute(email, "email1");
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}