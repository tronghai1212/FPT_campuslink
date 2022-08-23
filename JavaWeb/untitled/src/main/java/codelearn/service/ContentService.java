package codelearn.service;

import codelearn.connection.ConnectionJBDC;
import codelearn.entity.ContentEnity;
import codelearn.entity.MemberEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContentService {
    public Connection connect = ConnectionJBDC.getConnection();
    Date now = new Date(System.currentTimeMillis());
    public ContentEnity addContent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ContentEnity entity = new ContentEnity();
        MemberEntity memberEntity = new MemberEntity();
        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute("email");
        String email = String.valueOf(obj);
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Member WHERE Email = '" + email+"'");
        if (rs.next()){
            memberEntity.setId(rs.getInt("id"));
        }
        entity.setTitle(request.getParameter("title"));
        entity.setBrief(request.getParameter("brief"));
        entity.setContent(request.getParameter("content"));
        PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Content(Title, Brief, Content,CreateDate, AuthorId) VALUES(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setString(2, entity.getBrief());
        preparedStatement.setString(3, entity.getContent());
        preparedStatement.setDate(4, now);
        preparedStatement.setInt(5, memberEntity.getId());
        preparedStatement.executeUpdate();
        return  entity;
    }

    public List<ContentEnity> getListContent() throws SQLException {
        List<ContentEnity> list = new ArrayList<>();
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Content");
        while (rs.next()){
            ContentEnity enity = new ContentEnity();
            enity.setId(rs.getInt("id"));
            enity.setContent(rs.getString("Content"));
            enity.setBrief(rs.getString("Brief"));
            enity.setTitle(rs.getString("Title"));
            enity.setAuthorId(rs.getString("AuthorId"));
            enity.setCreatedDate(rs.getDate("CreateDate"));
            list.add(enity);
        }
        return list;
    }
}
