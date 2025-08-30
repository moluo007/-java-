package cn.jiruan.my;

import cn.jiruan.pojo.User;
import cn.jiruan.service.ISignAndLogService;
import cn.jiruan.service.Impl.SignAndLogServiceImpl;

import java.util.Scanner;

public class login {

    static ISignAndLogService sals = new SignAndLogServiceImpl();
    static Scanner sc = new Scanner(System.in);

    public static void enter() {
        System.out.println("=================================");
        System.out.println("=======这是仓库管理系统=============");
        System.out.println("================================= ");

        System.out.println("要使用的话按 “i”  ,退出瞎按即可 ");
        String choice = sc.next();
        if (choice.equalsIgnoreCase("i")) {
           boolean b= new login().useSystem();
           if (b==true){

               warehouseClass.wareManager();
           }
        } else {
            System.out.println("欢迎下次的使用  ，朋友   --------------");
            System.exit(0);
        }


    }


    public boolean useSystem() {
        System.out.println("这是界面=================================");
        System.out.println("注册 为 1 ，登录 为 2, 退出 为 3:");
        System.out.print("请输入：");

        while (true) {
            String choice = sc.next();
            if (choice.equals("1")) {
                return register();
            } else if (choice.equals("2")) {
                return login();
            } else if (choice.equals("3")) {
                System.exit(0);
            } else {
                System.out.println("真不小心啊 == 少年郎,再次输入吧");
            }
        }
    }


    public boolean register() {
        System.out.println("注册界面==================================");
        System.out.print("输入你的用户名:");
        String username = sc.next();
        System.out.print("输入你的密码:");
        String password_1 = sc.next();
        System.out.println("请再次确认你的密码");
        String password_2;
        do {
            password_2 = sc.next();
            if (!(password_1.equals(password_2))) {
                System.out.println("===========================");
                System.out.println("两次输入的密码不一致，请重新输入");
                System.out.println("===========================");
                System.out.println("可输入 ~ 退出本次注册=========");
                if (password_2.equals("~")) {
                    return false;
                }
            }
        } while (!(password_1.equals(password_2)));

        User user = new User(username, password_1);

        if (sals.register(user)) {
            System.out.println("注册成功======================");
            System.out.println("本次注册为您自动登录============");
            System.out.println("=============================");
            return true;
        } else {
            System.out.println("已存在相同用户名，注册失败========");
            return false;
        }

    }

    public boolean login() {
        System.out.println("登录界面==================================");
        while (true){
            System.out.print("输入你的用户名:");
            String username = sc.next();
            System.out.print("输入你的密码:");
            String password = sc.next();
            User user = new User(username, password);
            if (sals.login(user)) {
                System.out.println("登录成功======================");
                System.out.println("欢迎您，朋友==================");
                System.out.println("=============================");
                return true;
            } else {
                System.out.println("用户名或密码错误，登录失败========");
                System.out.println("可输入 ~ 退出本次登录=========");

                if (password.equals("~")) {
                    return false;

                }
            }
        }

    }


}
