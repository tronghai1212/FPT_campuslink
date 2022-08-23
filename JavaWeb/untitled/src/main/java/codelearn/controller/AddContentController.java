package codelearn.controller;

import codelearn.service.ContentService;
import codelearn.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/content")
public class AddContentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute("email");
        if (obj != null){
            request.getRequestDispatcher("./template/html/content.jsp").forward(request,response);
        }else {
            response.sendRedirect("/untitled/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ContentService contentService = new ContentService();
        try {
            contentService.addContent(request,response);
            response.sendRedirect("/untitled/view");
        } catch (SQLException throwables) {
//            response.sendRedirect("/untitled/view");
            throwables.printStackTrace();
        }

    }
}
