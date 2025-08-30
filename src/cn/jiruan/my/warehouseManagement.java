package cn.jiruan.my;

import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.service.IWarehouseMService;
import cn.jiruan.service.IWarningService;
import cn.jiruan.service.Impl.WarehouseMServiceImpl;
import cn.jiruan.service.Impl.WarningServiceImpl;
import cn.jiruan.util.PageHelper;

import java.util.*;

public class warehouseManagement {
    static Scanner sc=new Scanner(System.in);
    static final IWarehouseMService wms=new WarehouseMServiceImpl();
    static final IWarningService ws=new WarningServiceImpl();



    //1.仓库创建
    public void createWareHouse() {


        System.out.println("=============新建仓库==============");
        System.out.print("请输入你想要创建的编号:  ");
        Integer wareHouseId=Integer.parseInt(sc.next());
        System.out.print("请输入您要创建的仓库名称:");
        String wareHouseName = sc.next();
        System.out.print("请输入您要创建的仓库容量:");
        Integer wareHouseCapacity = Integer.parseInt(sc.next());
        System.out.print("请输入您要创建的仓库地址:");
        String wareHouseAddress = sc.next();

        WareHouse wh=new WareHouse(wareHouseId,wareHouseName,wareHouseCapacity,wareHouseAddress);

        if (wms.addWareHouse(wh)){
            System.out.println("=============新建仓库成功==============");
            System.out.println("\t\t"+wh.getWareHouseId()+" "+wh.getWareHouseName()+
                    " 容量："+wh.getWareHouseCapacity()+" 地址:"+wh.getWareHouseAddress()+" 成功创建");
        }else {
            System.out.println("创建失败");
        }
    }






 //2.仓库查询
    public  void query(){
        WareHouse wh=new WareHouse();
        PageHelper ph=new PageHelper();

        System.out.println("=============查询仓库==============");
        System.out.println("==============输入================");
        System.out.print("N：仓库名称：  I：仓库编号:  输入其他全部查询 \n\t\t\t");
        System.out.println("请输入");
        String str=sc.next();
        if (str.equalsIgnoreCase("N")){
            System.out.println("输入仓库名称");

            try {
                wh.setWareHouseName(sc.next());
                System.out.println("正在查询中===============");

            }catch (Exception e){
                System.out.println("输入名称不合法错误");
                System.out.println("自动为你查询全部");
            }

        }else if (str.equalsIgnoreCase("I")){
            System.out.println("输入仓库编号");
            try {
                wh.setWareHouseId(Integer.parseInt(sc.next()));
                System.out.println("正在查询中===============");

            }catch (Exception e){
                System.out.println("输入编号不合法错误");
                System.out.println("自动为你查询全部");
            }
        }else {
            System.out.println("自动为你查询全部");
            System.out.println("正在查询中===============");
        }

        ph.setDateCount(wms.queryWareHouseCount(wh));   //获取ph总页数
        System.out.printf("", "-".repeat(100));

        //打印列表
        printList((wms.queryWareHouse(wh,ph)));//获取 页面 查询到对应的数据   并进行打印

        capacityWarning();   //库存预警
        while (true){
            System.out.println("================================");
            System.out.println("========1.上一页[-1] 当前页：+"+ph.getPageIndex() +"  2.下一页[+1] 总页为"+ph.getPageCount() +" 按键3.退出=");
            System.out.println("===================================");
            System.out.println("===1.修改仓库===2.删除仓库===3.添加库存===输入其它退出");
            System.out.print("选择 -1 / 1 / 2 /3 /+1 ： ");
            String choice=sc.next();
            ph=tools.pageChange(choice,ph,"-1","+1");
            switch (choice){
                case "-1","+1":
                    printList((wms.queryWareHouse(wh,ph)));break;  //将page加减，以及第一页和最后一页情况

                    case "1":updateWareHouse(wh,ph);break;
                    case "2":deleteWareHouse(wh,ph);break;
                    case "3":addInventory(wh,ph);break;
                    default: return;

            }


        }




    }



    public void addInventory(WareHouse userWareHouse, PageHelper ph){
        ArrayList<WareHouse> list = wms.queryWareHouse(userWareHouse, ph); //获取页面查询到的数据


        WareHouse userInputwareHouse = new WareHouse();
        Inventory userInputInventory = new Inventory();

        System.out.println("=============选择仓库==============");
        System.out.print("选择你想要添加库存的仓库编号:  ");
        Integer wareHouseId=tools.safeIdInput(list);
        userWareHouse.setWareHouseId(wareHouseId);
        System.out.println("=============添加库存==============");
        int inventoryCapacity=tools.format("输入要添加的库存容量");
        int inventoryUseCapacity=0;
        int inventoryWarningCapacity=tools.format("输入要添加的库存预警容量");
        System.out.println("请输入您要添加的库存类型(请输入[常温/冷冻/水产]):");
        String inventoryType = sc.next();
        while (!"常温".equals(inventoryType) && !"冷冻".equals(inventoryType) && !"水产".equals(inventoryType)){
            System.out.println("您输入的不符合要求,请重新输入库存类型(请输入[常温/冷冻/水产]):");
            inventoryType = sc.next();
        }
        inventoryType += "仓库";
        userInputInventory.setInventoryType(inventoryType);
        userInputInventory.setInventoryAllCapacity(inventoryCapacity);
        userInputInventory.setInventoryUseCapacity(inventoryUseCapacity);
        userInputInventory.setInventoryWarnCapacity(inventoryWarningCapacity);
        if (wms.addInventory(userInputwareHouse, userInputInventory)) {
            System.out.println("==================================================");
            System.out.println("添加成功! #"+wareHouseId+ "-" + "添加了新的库存: #"+
                    inventoryType + "-容量:" +
                    inventoryCapacity + "-已用容量:" +
                    inventoryUseCapacity + "-警告容量:" +
                    inventoryWarningCapacity);
            printList(wms.queryWareHouse(userWareHouse, ph));
        } else {
            System.out.println("==================================================");
            System.out.println("===================添加失败....====================");
            printList(wms.queryWareHouse(userInputwareHouse, ph));
        }


    }



        //4.仓库删除
    public void deleteWareHouse(WareHouse userWareHouse, PageHelper ph){
        ArrayList<WareHouse> list = wms.queryWareHouse(userWareHouse, ph); //获取页面查询到的数据
        System.out.println("=============删除仓库==============");
        System.out.print("选择你想要删除的仓库编号:  ");
        WareHouse wh=new WareHouse();
        wh.setWareHouseId(tools.safeIdInput(list));
        if (wms.deleteWareHouse(wh)){
            System.out.println("===================================");
            System.out.println("删除成功! #"+wh.getWareHouseId()+" 已删除");
            System.out.println("===================================");
            printList(wms.queryWareHouse(userWareHouse,ph));
        }else {
            System.out.println("=============删除仓库失败==============");
            printList(wms.queryWareHouse(userWareHouse,ph));
        }
    }



    //3.仓库修改
    public void updateWareHouse(WareHouse userWareHouse, PageHelper ph){
        WareHouse userChangeWaraHouse=new WareHouse();

        ArrayList<WareHouse> list = wms.queryWareHouse(userWareHouse, ph);

        System.out.println("=============修改仓库==============");
        System.out.print("选择你想要修改的仓库编号:  ");
        Integer wareHouseId=tools.safeIdInput(list);
        userChangeWaraHouse.setWareHouseId(wareHouseId);
        System.out.print("请输入你想要修改的仓库名称:  ");
        String wareHouseName=sc.next();
        System.out.print("请输入你想要修改的仓库地址:  ");
        String wareHouseAddress=sc.next();
//        System.out.print("请输入你想要修改的仓库容量:  ");
        Integer wareHouseCapacity=tools.format("输入要修改的仓库容量");


        userChangeWaraHouse.setWareHouseName(wareHouseName);
        userChangeWaraHouse.setWareHouseAddress(wareHouseAddress);
        userChangeWaraHouse.setWareHouseCapacity(wareHouseCapacity);

        if (wms.changeWareHouse(userChangeWaraHouse)){
            System.out.println("修改成功! #"+userChangeWaraHouse.getWareHouseId()+" 已改为" +
                    wareHouseName + "-" + wareHouseCapacity + "-" + wareHouseAddress);

            printList(wms.queryWareHouse(userWareHouse,ph));

        }else {
            System.out.println("=============修改仓库失败==============");
            printList(wms.queryWareHouse(userWareHouse,ph));
        }



    }














//    打印列表  对仓库和库存进行打印
    public void printList(ArrayList<WareHouse> arr){
        System.out.println("===============仓库查询===============\n ");
        System.out.printf("%-10s%-10s%-10s%-10s\n","仓库编号","仓库名称","仓库容量","仓库地址");
        for (WareHouse wh:arr){
            System.out.printf("%-10d%-10s%-10d%-10s\n",wh.getWareHouseId(),wh.getWareHouseName(),wh.getWareHouseCapacity(),wh.getWareHouseAddress());
        }
    }




     //库存预警
    public static void capacityWarning(){
        Map<WareHouse, Inventory> map = ws.qualityWarning();
        System.out.println("===============容量预警===============");

        Set<Integer> arr=new HashSet<>();
        if (!map.isEmpty()){
            for (Map.Entry<WareHouse, Inventory> entry : map.entrySet()) {
                if (arr.add(entry.getValue().getInventoryPrimaryKey())){
                    System.out.println(entry.getKey().getWareHouseName() + "仓库容量预警,库存" + entry.getValue().getInventoryPrimaryKey() + "不足");
                }


            }
        }else {
            System.out.println("没有容量预警");
        }
    }



}
