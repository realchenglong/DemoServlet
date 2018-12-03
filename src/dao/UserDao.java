package dao;

import bean.User;
import util.DBHelper;

import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class UserDao {

    public User CheckPassword(String email,String password){
        User user = null;
        Map<String,Object> map = new HashMap<String, Object>();
        List<Object> listParam = new LinkedList<Object>();
        listParam.add(email);
        listParam.add(password);
        try{
            String sql="select * from d_user where email=? and password=?";
            map=DBHelper.findSingleObject(sql,listParam);
            if(map.size() > 0)
            {
                user=new User();
                user.setId((int)map.get("id"));
                user.setEmail((String)map.get("email"));
                user.setNickname((String)map.get("nickname"));
                user.setPassword((String)map.get("password"));
            }
//            if(rs.next()){
//                user=new User();
//                user.setId(rs.getInt("id"));
//                user.setEmail(rs.getString("email"));
//                user.setNickname(rs.getString("nickname"));
//                user.setPassword(rs.getString("password"));
//            }
        }catch(Exception e){
            e.printStackTrace();;
        }
        return user;
    }
}
