package entities;

public class TransactionHistoryEntity {
    private int transaction_id;
    private long amount;
    private String transaction_note;
    private String account_receive;
    private AccountEntity account_transfer;

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTransaction_note() {
        return transaction_note;
    }

    public void setTransaction_note(String transaction_note) {
        this.transaction_note = transaction_note;
    }

    public String getAccount_receive() {
        return account_receive;
    }

    public void setAccount_receive(String account_receive) {
        this.account_receive = account_receive;
    }

    public AccountEntity getAccount_transfer() {
        return account_transfer;
    }

    public void setAccount_transfer(AccountEntity account_transfer) {
        this.account_transfer = account_transfer;
    }

    public TransactionHistoryEntity() {
    }

    public TransactionHistoryEntity( long amount, String transaction_note, String account_receive, AccountEntity account_transfer) {
        this.amount = amount;
        this.transaction_note = transaction_note;
        this.account_receive = account_receive;
        this.account_transfer = account_transfer;
    }
}
