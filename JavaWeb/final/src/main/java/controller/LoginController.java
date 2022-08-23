package controller;

import entities.AccountEntity;
import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("./template/html/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        AccountService service = new AccountService();
        HttpSession session = request.getSession();
        AccountEntity account = null;
        try {
            account = service.getAccountReceive(request.getParameter("account"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            boolean check = false;
            check = service.login(request);
            if (check==true){
                session.setAttribute("account",account);
                response.sendRedirect("/final/transaction");
            }else {
                session.setAttribute("message","login failed");
                response.sendRedirect("/final/login");
            }
        } catch (Exception throwables) {
            response.sendRedirect("/final/login");
            throwables.printStackTrace();
        }
    }
}
