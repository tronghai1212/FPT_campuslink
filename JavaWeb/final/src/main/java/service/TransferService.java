package service;

import connection.ConnectionJBDC;
import entities.TransactionHistoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransferService {
    public boolean addTransaction(TransactionHistoryEntity tran) {
        try (Connection connection = ConnectionJBDC.getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO TransactionHistory(amount, transaction_note, "
                    + "account_receive, account_transfer) VALUES(?, ?, ?, ?)");

            statement.setLong(1, tran.getAmount());
            statement.setString(2, tran.getTransaction_note());
            statement.setString(3, tran.getAccount_receive());
            statement.setString(4, tran.getAccount_transfer().getAccount());

            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
