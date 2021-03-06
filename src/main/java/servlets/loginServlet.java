package servlets;

import classes.User;
import services.DaoService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("uname");
        String password = req.getParameter("psw");

        User user = DaoService.userDAO.findByLogin(login);;

        if(user!=null&&user.getPassword().equals(password)){
            req.setAttribute("role",user.getRole());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
