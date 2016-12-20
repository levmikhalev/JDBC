package servlets;

import ru.connection.db.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("DelPage.jsp");
        dispatcher.include(req, resp);

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            Class.forName("com.mysql.jdbc.Driver");

            DataBaseConnection dbc = new DataBaseConnection();
            dbc.delUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
