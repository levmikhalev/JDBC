package servlets;

import ru.connection.db.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("MyPage.jsp");
        dispatcher.include(req, resp);

        DataBaseConnection dbc = new DataBaseConnection();
        try {
            String name = req.getParameter("name");
            String age = req.getParameter("age");
            String email = req.getParameter("email");

            Statement statement = dbc.getConnection().createStatement();

            int i = statement.executeUpdate("INSERT INTO users VALUES ('"+name+"','"+age+"','"+email+"')");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить драйвер!");
        }
    }
}