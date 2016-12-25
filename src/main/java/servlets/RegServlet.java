package servlets;

import ru.connection.db.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("Registration.jsp");
        dispatcher.include(req, resp);

        HttpSession session = req.getSession(false);
        session.getAttribute("log");
        session.getAttribute("log");

        try {
            String name = req.getParameter("name");
            String age = String.valueOf(req.getParameter("age"));
            String email = req.getParameter("email");

            //вариант работы с БД через объект и вызываемый на нём метод другого класса
            DataBaseConnection dbc = new DataBaseConnection();
            dbc.addUser(name, age, email);

            //вариант работы с БД через объект другого класса
            /*DataBaseConnection dbc = new DataBaseConnection();
            PreparedStatement statement = dbc.getConnection().prepareStatement("INSERT INTO users (name, age, email) VALUES ('"+name+"','"+age+"','"+email+"')");
            statement.executeUpdate();
            statement.close();*/

            //вариант работы с БД без создания объекта другого класса
            /*Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, age, email) VALUES ('"+name+"','"+age+"','"+email+"')");
            statement.executeUpdate();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}