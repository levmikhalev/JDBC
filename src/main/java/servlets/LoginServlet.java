package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String log = req.getParameter("login");
            String pas = req.getParameter("password");

            if("admin".equals(log) && "admin".equals(pas))
                {
                    resp.sendRedirect("Registration.jsp");

                } else {
                String varTextA = "Неправильный логин или пароль!";
                req.setAttribute("textA", varTextA);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
        dispatcher.include(req, resp);
    }
}
