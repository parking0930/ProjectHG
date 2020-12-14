package Dao;

import Dto.UserDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Connection conn;
    
    public UserDAO() {
        try {
            String schema = "javahg" ; // 본인 스키마 입력
            String dbURL = "jdbc:mysql://127.0.0.1:3306/"+schema+"?serverTimezone=UTC";
            String dbID = "root";
            String dbPassword = "wogus4735"; // 본인 패스워드 입력
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void close(){
        try{
            pstmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    // ID, PW 받아서 맞으면 True 틀리면 false 반환
    public boolean login(String id, String pwd) {
        String sql = "select password from member where id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).equals(pwd)) {
                    rs.close();
                    return true;
                } else {
                    rs.close();
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public UserDTO getUserData(String id) {
        String sql = "select id, nickname, win, lose, point, date from member where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            
            UserDTO userinfo = new UserDTO();
            userinfo.setId(rs.getString(1));
            userinfo.setNickname(rs.getString(2));
            userinfo.setWin(rs.getInt(3));
            userinfo.setLose(rs.getInt(4));
            userinfo.setPoint(rs.getInt(5));
            userinfo.setDate(rs.getString(6).split(" ")[0]);
            rs.close();
            return userinfo;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
   
    public boolean getIDExist(String id){ 
        try {
            pstmt = conn.prepareStatement("select * from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                rs.close();
                return true;
            }else{
                rs.close();
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean getNicknameExist(String nickname){ 
        try {
            pstmt = conn.prepareStatement("select * from member where nickname = ?");
            pstmt.setString(1, nickname);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                rs.close();
                return true;
            }else{
                rs.close();
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public void singUpInsert(String id, String pwd, String nickname) {
        try {
            String sql = "insert into member(id, password, nickname) values(?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, nickname);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
        //비밀번호 변경 // 찾을 id, 변경할 pwd 인수
    public void myPagePwdUpdate(String id, String pwd){
        String sql = "update member set password = ? where id = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pwd);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void winUpdate(String id){
        String sql = "update member set point=point+100, win=win+1 where id = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void loseUpdate(String id){
        String sql = "update member set point=point+50, lose=lose+1 where id = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
