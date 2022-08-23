package API;

import com.google.gson.Gson;
import entities.AccountEntity;
import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
@WebServlet(urlPatterns = "/get-list")
public class ListAccountReceive extends HttpServlet {
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            AccountService accountService = new AccountService();
            List<AccountEntity> list;

            AccountEntity entity = (AccountEntity)request.getSession().getAttribute("account");
            list = accountService.getAccounts(entity);
            String listContent = this.gson.toJson(list);
            out.print(listContent);
            out.flush();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
