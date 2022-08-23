package codelearn.controller;

import codelearn.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("./template/html/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        MemberService memberService = new MemberService();
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        try {
            boolean check = false;
            check = memberService.login(request,response);
            if (check==true){
                session.setAttribute("email",email);
                response.sendRedirect("/untitled/profile");
            }else {
                response.sendRedirect("/untitled/login");
            }
        } catch (Exception throwables) {
            response.sendRedirect("/untitled/login");
            throwables.printStackTrace();
        }
    }
}
