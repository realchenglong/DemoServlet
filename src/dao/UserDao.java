package dao;

import bean.User;
import util.DBHelper;

import java.awt.*;
import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    public User CheckPassword(String email,String password){
        User user = null;
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            List<Object> list = new List();
            String sql="select * from d_user where email=? and password=?";
            map=DBHelper.findSingleObject(sql,);
            prep.setString(1, email);
            prep.setString(2, password);
            ResultSet rs=prep.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
            }
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
}
