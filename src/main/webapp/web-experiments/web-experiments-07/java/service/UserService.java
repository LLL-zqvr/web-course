package service;

import com.entity.User;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserService {
    public static List<User> listUsers(){
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        //资源要关闭，所以放在try（）里头
        try(
                Connection conn = DataSourceUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
               //结果集
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setInsertTime(rs.getObject("insert_time", LocalDateTime.class));
                user.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
