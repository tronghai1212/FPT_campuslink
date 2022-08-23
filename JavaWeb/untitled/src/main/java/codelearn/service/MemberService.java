package codelearn.service;

import codelearn.connection.ConnectionJBDC;
import codelearn.entity.MemberEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class MemberService extends HttpServlet {
    public Connection connect = ConnectionJBDC.getConnection();
    Date now = new Date(System.currentTimeMillis());
    public MemberEntity register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        MemberEntity entity = new MemberEntity();
        String msg = null;
        entity.setUserName(request.getParameter("username"));
        entity.setEmail(request.getParameter("email"));
        entity.setPassWord(request.getParameter("password"));
        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Member(Username, Email, Password,CreatedDate) VALUES(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getUserName());
        preparedStatement.setString(2, entity.getEmail());
        preparedStatement.setString(3, entity.getPassWord());
        preparedStatement.setDate(4, now);
        preparedStatement.executeUpdate();
        request.setAttribute("msg",msg);
        return  entity;
    }

    public Boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        MemberEntity entity = new MemberEntity();
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Member WHERE Email = '" + email+"'");
        if (rs.next()){
            entity.setEmail(rs.getString("Email"));
            entity.setPassWord(rs.getString("passWord"));
        }
        if(entity.getEmail()== null){
            throw new Exception("ko ton tai email");
        }
        if (entity.getEmail().equals(email) && entity.getPassWord().equals(password)){
            return true;
        }else return false;

    }

    public void editProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String description = request.getParameter("description");
        String oldEmail = String.valueOf(obj);
        PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Member SET Firstname = ?, Lastname = ?, Email = ? ,Phone =?, Description=?, UpdateTime=? WHERE Email = ?",
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, phone);
        preparedStatement.setString(7, oldEmail);
        preparedStatement.setString(5, description);
        preparedStatement.setDate(6, now);
        preparedStatement.executeUpdate();
    }

}
