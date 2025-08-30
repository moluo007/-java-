package cn.jiruan.my;

import java.util.Scanner;

public class warehouseClass {

    static Scanner sc = new Scanner(System.in);

    public static void wareManager() {
        System.out.println("这是界面");
        System.out.println("这是仓库管理系统==================" + "======================" );
        warehouseClass wc=new warehouseClass();
        while (true) {
            System.out.print("请输入你的选择   朋友\n老规矩，\n 1.仓库管理\t\t2.库存管理\t\t 3.键退出 : ");
            String choice = sc.next();
            switch (choice) {
                case "1":
                   wc.wareHouseManager();
                    break;
                case "2":
                    InventoryManager.inventoryManager();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }


    }




    public void wareHouseManager() {
       while (true){
           System.out.println("这是仓库管理界面");
           System.out.println("==============仓库管理==============");
           System.out.println("1.新建仓库\t\t 2.仓库查询\t\t 3.退出系统 \t\t其他键返回");
           System.out.print("请输入你的选择");
           warehouseManagement wm=new warehouseManagement();
           String choice = sc.next();
           switch (choice) {
               case "1":
                   wm.createWareHouse();
                   break;
               case "2":
                   wm.query();
                   break;
               case "3":System.exit(0);
               default: return;
           }
       }
    }




}
