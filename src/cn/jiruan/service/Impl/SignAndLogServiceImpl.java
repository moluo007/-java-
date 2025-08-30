package cn.jiruan.service.Impl;

import cn.jiruan.dao.*;
import cn.jiruan.dao.Impl.*;
import cn.jiruan.pojo.User;
import cn.jiruan.service.ISignAndLogService;

public class SignAndLogServiceImpl implements ISignAndLogService {
    IUserDao iud = new UserDaoImpl();



    /*
     * 注册:
     *       1.main包中用户输入的用户名与密码打包成User对象传入本方法
     *       2.本方法要通过dao层获取到数据库中对应数据
     *       3.如果获取(即查询)到了，则注册失败 -> 返回false
     *       4.如果没获取到，则注册 -> 在数据库中添加对应用户 -> 注册成功 -> 返回true
     * */
    @Override
    public boolean register(User user) {
        User u=iud.getUserByName(user.getUserName());
        if (u==null)return iud.insertUser(user)>0;

        else if( u.getUserName().equals(user.getUserName())) return false;    //查重用户名，以及判断是否为null
        return false;

    }

    /*
     * 登陆：
     *       1.main包中用户输入的用户名与密码打包成User对象传入本方法
     *       2.本方法要通过dao层获取到数据库中对应数据
     *       3.如果获取(即查询)到了，则登陆成功 -> 返回true
     *       4.如果没获取到，则登陆失败 -> 返回false
     * */
    @Override
    public boolean login(User user) {   //逻辑通过username 获得数据库对应数据

        User u=iud.getUserByName(user.getUserName());

//这里巧妙运用是否有用户名
        return u != null && u.getPassword().equals(user.getPassword());


    }
}
