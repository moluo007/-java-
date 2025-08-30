package cn.jiruan.dao.Impl;

import cn.jiruan.dao.IUserDao;
import cn.jiruan.pojo.User;
import cn.jiruan.util.DBHelper;


import java.util.ArrayList;

public class UserDaoImpl implements IUserDao {


    @Override
    public int insertUser(User user) {

        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";

        return DBHelper.currencySqlUpdate(sql, user.getUserName(), user.getPassword());
    }


    @Override
    public User getUserByName(String username) {

        String sql = "SELECT * FROM user WHERE userName = ?";
        ArrayList<Object> users = DBHelper.currencySqlQuery(User.class, sql, username);



        ArrayList<User> userList = new ArrayList<>();
        if (users != null) {
            for (Object o : users) {
                if (o instanceof User) {
                    userList.add((User) o);
                }
            }
        }

        return  userList.isEmpty() ? null :userList.getFirst();
    }


}

