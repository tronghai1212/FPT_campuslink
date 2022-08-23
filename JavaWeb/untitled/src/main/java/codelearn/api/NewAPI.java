package codelearn.api;

import codelearn.entity.ContentEnity;
import codelearn.service.ContentService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/get-list")
public class NewAPI extends HttpServlet {
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ContentService contentService = new ContentService();
            List<ContentEnity> list;
            list = contentService.getListContent();
            String listContent = this.gson.toJson(list);
            out.print(listContent);
            out.flush();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
