package entities;

public class AccountEntity {
    private String account;
    private String password;
    private String phone;
    private long balance;

    public AccountEntity(String account, String password, String phone, long balance) {
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
    }

    public AccountEntity() {

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
