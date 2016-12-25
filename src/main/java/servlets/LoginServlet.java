package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        try {
            String log = req.getParameter("login");
            String pas = req.getParameter("password");

            if("admin".equals(log) && "admin".equals(pas))
                {
                    HttpSession session = req.getSession();
                    session.setAttribute("log", log);
                    session.setAttribute("pas", pas);

                    RequestDispatcher dispatcher = req.getRequestDispatcher("Registration.jsp");
                    dispatcher.forward(req, resp);
                } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
                dispatcher.include(req, resp);

                String varTextA = "Неправильный логин или пароль!";
                req.setAttribute("textA", varTextA);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
