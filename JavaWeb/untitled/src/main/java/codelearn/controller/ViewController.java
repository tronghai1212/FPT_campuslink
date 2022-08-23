package codelearn.controller;

import codelearn.entity.ContentEnity;
import codelearn.service.ContentService;
import codelearn.service.MemberService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/view")
public class ViewController extends HttpServlet {
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute("email");
        if (obj != null) {
            request.getRequestDispatcher("./template/html/view.jsp").forward(request, response);
        } else {
            response.sendRedirect("/untitled/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        MemberService memberService = new MemberService();
        try {
            memberService.editProfile(request,response);
            response.sendRedirect("/untitled/view");
        } catch (SQLException throwables) {
            response.sendRedirect("/untitled/view");
            throwables.printStackTrace();
        }

    }

}
