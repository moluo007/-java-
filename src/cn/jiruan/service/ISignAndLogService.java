package cn.jiruan.service;

import cn.jiruan.pojo.User;

public interface ISignAndLogService {

    /*
    * 注册:
    *       1.main包中用户输入的用户名与密码打包成User对象传入本方法
    *       2.本方法要通过dao层获取到数据库中对应数据
    *       3.如果获取(即查询)到了，则注册失败 -> 返回false
    *       4.如果没获取到，则注册 -> 在数据库中添加对应用户 -> 注册成功 -> 返回true
    * */
    boolean register(User user);    //注册



    /*
    * 登陆：
    *       1.main包中用户输入的用户名与密码打包成User对象传入本方法
    *       2.本方法要通过dao层获取到数据库中对应数据
    *       3.如果获取(即查询)到了，则登陆成功 -> 返回true
    *       4.如果没获取到，则登陆失败 -> 返回false
    * */
    boolean login(User user);       //登陆

}
