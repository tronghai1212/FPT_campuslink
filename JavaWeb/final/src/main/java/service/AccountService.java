package service;

import connection.ConnectionJBDC;
import entities.AccountEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    public Connection connect = ConnectionJBDC.getConnection();
    public Boolean login(HttpServletRequest request) throws Exception {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        AccountEntity entity = new AccountEntity();
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Account WHERE account = '" + account+"'");
        if (rs.next()){
            entity.setAccount(rs.getString("account"));
            entity.setPassword(rs.getString("passWord"));
        }
        if(entity.getAccount() == null){
            throw new Exception("ko ton tai account");
        }
        if (entity.getAccount().equals(account) && entity.getPassword().equals(password)){
            return true;
        }else return false;

    }

    public AccountEntity getAccountReceive(String accountReceive) throws SQLException {
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Account WHERE account = '" + accountReceive+"'");
        if (rs.next()){
            return new AccountEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4));
        }
        return null;
    }

    public Boolean updateAccount(AccountEntity account) {
        try (Connection connection = ConnectionJBDC.getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE Account SET balance = ? WHERE account = ?");
            statement.setLong(1, account.getBalance());
            statement.setString(2, account.getAccount());
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<AccountEntity> getAccounts(AccountEntity account) throws SQLException {
        List<AccountEntity> list = new ArrayList<>();
//        HttpSession httpSession = request.getSession();
//        Object obj = httpSession.getAttribute("account");
//        String account = String.valueOf(obj);
        Statement statement = connect.createStatement();
        String sql = "SELECT * FROM Account WHERE account != '" +account.getAccount()+"'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new AccountEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4)));
        }
        return list;
    }
}
