package cn.jiruan.dao;

import cn.jiruan.pojo.User;

import java.util.ArrayList;

public interface IUserDao {
    //Service层注册与登陆功能
    /*
     * 注册:
     *       1.main包中用户输入的用户名与密码打包成User对象传入本方法
     *       2.本方法要通过dao层获取到数据库中对应数据
     *       3.如果获取(即查询)到了，则注册失败 -> 返回false
     *       4.如果没获取到，则注册 -> 在数据库中添加对应用户 -> 注册成功 -> 返回true
     * */
    /*
     * 登陆：
     *       1.main包中用户输入的用户名与密码打包成User对象传入本方法
     *       2.本方法要通过dao层获取到数据库中对应数据
     *       3.如果获取(即查询)到了，则登陆成功 -> 返回true
     *       4.如果没获取到，则登陆失败 -> 返回false
     * */

    /// ////////////////////////////////////////////////////////////////////////
    //增
    /*
    *  sql语句:  insert into 用户表 values(null,?,?)
    *
    *           在用户表中 新增一个用户的 用户名 和 密码
    * */
    int insertUser(User user);

    //查
    /*sql语句：
    *        1.通过username 在 用户表 中 查询到对应用户的 用户名 与 密码
    *        2.将用户名与密码打包成User对象返回给Service层
    * */
    User getUserByName(String username);
}
