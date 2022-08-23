package controller;

import entities.AccountEntity;
import entities.TransactionHistoryEntity;
import service.AccountService;
import service.TransferService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/transaction")
public class TransferController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession httpSession = request.getSession();
        AccountEntity obj = (AccountEntity) httpSession.getAttribute("account");
        if (obj != null) {
            request.getRequestDispatcher("./template/html/transaction.jsp").forward(request, response);
        } else {
            response.sendRedirect("/final/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
//        AccountService service = new AccountService();
        try {
            transfer(request,response);
            response.sendRedirect("/final/transaction");
        } catch (SQLException throwables) {
            response.sendRedirect("/final/transaction");
            throwables.printStackTrace();
        }

    }

    private void transfer(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        AccountService accountService = new AccountService();
        TransferService transferService = new TransferService();
        Long amount = Long.parseLong(request.getParameter("amount"));
        String accountReceive = request.getParameter("accountReceive");
        String description = request.getParameter("note");

        AccountEntity accountTransferEntity = (AccountEntity) request.getSession().getAttribute("account");
        AccountEntity accountReceiveEntity = accountService.getAccountReceive(accountReceive);


        Long balanceTransfer = accountTransferEntity.getBalance();
        Long balanceReceive = accountReceiveEntity.getBalance();

        TransactionHistoryEntity tran = new TransactionHistoryEntity(amount, description, accountReceive, accountTransferEntity);
        try {
            boolean result = transferService.addTransaction(tran);
            if (result == true) {
                accountTransferEntity.setBalance(balanceTransfer - amount);
                accountReceiveEntity.setBalance(balanceReceive + amount);

                accountService.updateAccount(accountTransferEntity);
                accountService.updateAccount(accountReceiveEntity);

                request.getSession().setAttribute("account", accountTransferEntity);
                request.setAttribute("NOTIFICATION", "Transfer Successfully!");
            } else {
                request.setAttribute("NOTIFICATION", "Transfer Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("./template/html/transaction.jsp").forward(request,response);

    }

}
