package cn.jiruan.my;

import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.Product;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.service.IInventoryMService;
import cn.jiruan.service.Impl.InventoryMServiceImpl;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InventoryFunction {
    private final Scanner input = new Scanner(System.in);
    private final IInventoryMService iInventoryMService =  new InventoryMServiceImpl();

    //入库
    public void inInventory() {
        Product inputProduct = new Product();
        //输入产品编号、数量，根据产品编号和数量查询可以存放产品的库存，选择要存放的库存，将产品存入仓库。
        System.out.println("======================[产品入库]=====================");
        System.out.print("请输入要存放的产品编号:");
        Integer productId = Integer.parseInt(input.next());
        System.out.print("请输入要存放的产品数量:");
        int productNum = Integer.parseInt(input.next());
        inputProduct.setProductId(productId);
        //查询可存放的库存列表
        Inventory inputInventory = new Inventory();
        ArrayList<Inventory> queriedList = iInventoryMService.queryInWareHouse(inputProduct, productNum);
        printInventoryArr(queriedList);
        System.out.print("请选择您要存放的库存id: ");
        int inventoryId = Integer.parseInt(input.next());
        inputInventory.setInventoryPrimaryKey(inventoryId);
        if (iInventoryMService.addProduceInWareHouse(inputProduct, productNum, inputInventory)) {
            System.out.println("==================================================");
            System.out.println("=====================入库成功!=====================");
        } else {
            System.out.println("==================================================");
            System.out.println("====================入库失败....===================");
        }
    }



    //出库
    public void outInventory() {
        Product inputProduct = new Product();
        //输入产品编号、数量，根据产品编号和数量查询满足条件的库存，选择库存，将产品出库。
        System.out.println("======================[产品出库]=====================");
        System.out.print("请输入要出库的产品编号:");
        Integer productId = Integer.parseInt(input.next());
        System.out.print("请输入要出库的产品数量:");
        int productNum = Integer.parseInt(input.next());
        inputProduct.setProductId(productId);
        //查询可出库的库存列表
        Inventory inputInventory = new Inventory();
        ArrayList<Inventory> queriedList = iInventoryMService.queryOutWareHouse(inputProduct, productNum);
        printInventoryArr(queriedList);
        System.out.print("请选择您要出库的库存id: ");
        int inventoryId = Integer.parseInt(input.next());
        inputInventory.setInventoryPrimaryKey(inventoryId);
        if (iInventoryMService.outProduceInWareHouse(inputProduct, productNum, inputInventory)) {
            System.out.println("==================================================");
            System.out.println("======================出库成功!====================");
        } else {
            System.out.println("==================================================");
            System.out.println("=====================出库失败....==================");
        }
    }

    //调拨
    public void productAllocation() {
        Product inputProduct = new Product();
        //输入产品编号、数量，根据产品编号和数量查询满足条件的库存，选择库存，再查询可以存放产品的库存，进行产品调拨。
        System.out.println("======================[产品调拨]=====================");
        System.out.print("请输入要调拨的产品编号:");
        Integer productId = Integer.parseInt(input.next());
        System.out.print("请输入要调拨的产品数量:");
        int productNum = Integer.parseInt(input.next());
        inputProduct.setProductId(productId);
        //查询可调出的库存列表 - 并做出选择
        Inventory inputOutInventory = new Inventory();
        ArrayList<Inventory> queriedListOut = iInventoryMService.queryOutWareHouse(inputProduct, productNum);
        printInventoryArr(queriedListOut);
        System.out.print("请选择您要调出产品的库存id: ");

        int inventoryOutId = Integer.parseInt(input.next());  //要调用的库存主键

        inputOutInventory.setInventoryPrimaryKey(inventoryOutId);

        //查询可调入的库存列表 - 并做出选择
        Inventory inputInInventory = new Inventory();


        ArrayList<Inventory> queriedListIn = iInventoryMService.queryOutWareHouse(inputProduct, productNum);
        printInventoryArr(queriedListIn);
        System.out.print("请选择您要调入产品的库存id: ");
        int inventoryInId = Integer.parseInt(input.next());
        inputInInventory.setInventoryPrimaryKey(inventoryInId);

        //调拨
        if(iInventoryMService.allocation(inputOutInventory,inputInInventory,productNum)){
            System.out.println("==================================================");
            System.out.println("=====================调拨成功!=====================");
        }else{
            System.out.println("==================================================");
            System.out.println("====================调拨失败....===================");
        }

    }

    /// //////两种打印方法

    public void printInventoryArr(Map<WareHouse, Inventory> printList) {
        //默认打印库存第一页
        //库存标识、仓库名称、库存类型、库存最大容量、库存已用容量、预警容量、仓库地址。
//        System.out.println("-----------------------------------------------");
//        System.out.println("%-8s%-8s%-8s%-8s%-8s%-8s%-8s"+
//                "库存标识    " +
//                        "仓库名称    " +
//                        "库存类型    " +
//                        "库存最大容量    " +
//                        "库存已用容量    " +
//                        "预警容量    " +
//                        "仓库地址    ");
//        Set<Map.Entry<WareHouse, Inventory>> entrySet = printList.entrySet();
//        for (Map.Entry<WareHouse, Inventory> entry : entrySet) {
//            WareHouse tempWareHouse = entry.getKey();
//            Inventory tempInventory = entry.getValue();
//            System.out.printf("%-8s%-8s%-8s%-8s%-8s%-8s%-8s"+
//                    tempInventory.getInventoryPrimaryKey() +
//                            tempWareHouse.getWareHouseName()  +
//                            tempInventory.getInventoryType()  +
//                            tempInventory.getInventoryUseCapacity()+
//                            tempInventory.getInventoryWarnCapacity() +
//                            tempWareHouse.getWareHouseAddress()
//
//            );
////            PrintTools.judgeWei(tempInventory.getInventoryAllCapacity(),3,2,3);
////            System.out.print(tempInventory.getInventoryUseCapacity());
////            PrintTools.judgeWei(tempInventory.getInventoryUseCapacity(),3,2,3);
////            System.out.print(tempInventory.getInventoryWarnCapacity());
////            PrintTools.judgeWei(tempInventory.getInventoryWarnCapacity(),3,2,3);
////            System.out.println(tempWareHouse.getWareHouseAddress());
//        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s%-8s%-10s%-12s%-12s%-8s%-10s%n",
                "库存标识", "仓库名称", "库存类型",
                "库存最大容量", "库存已用容量", "预警容量", "仓库地址");
        System.out.println("---------------------------------------------------------------");

        // 遍历Map中的键值对
        Set<Map.Entry<WareHouse, Inventory>> entrySet = printList.entrySet();
        for (Map.Entry<WareHouse, Inventory> entry : entrySet) {
            WareHouse tempWareHouse = entry.getKey();
            Inventory tempInventory = entry.getValue();

            // 数据行：用printf统一输出所有字段，确保在同一行且对齐
            System.out.printf("%-8d%-8s%-10s%-12d%-12d%-8d%-10s%n",
                    tempInventory.getInventoryPrimaryKey(),  // 库存标识（整数）
                    tempWareHouse.getWareHouseName(),         // 仓库名称（字符串）
                    tempInventory.getInventoryType(),         // 库存类型（字符串）
                    tempInventory.getInventoryAllCapacity(),  // 最大容量（整数）
                    tempInventory.getInventoryUseCapacity(),  // 已用容量（整数）
                    tempInventory.getInventoryWarnCapacity(), // 预警容量（整数）
                    tempWareHouse.getWareHouseAddress()       // 仓库地址（字符串）
            );
        }
    }

    public void printInventoryArr(ArrayList<Inventory> printList) {
        System.out.println("-----------------------------------------------");
        System.out.printf("%-8s%-8s%-8s%-8s%-8s%n",
                        "库存编号" ,
                        "库存类型" ,
                        "库存最大容量" ,
                        "库存已用容量 " ,
                        "预警容量 ");
        for (Inventory inventory : printList) {
            System.out.printf("%-8s%-8s%-8s%-8s%-8s%n",
                    inventory.getInventoryPrimaryKey() ,
                            inventory.getInventoryType()  ,
                            inventory.getInventoryAllCapacity() ,
                            inventory.getInventoryUseCapacity(),
                            inventory.getInventoryWarnCapacity()
            );
//            PrintTools.judgeWei(inventory.getInventoryAllCapacity(),3,2,3);
//            System.out.print(inventory.getInventoryUseCapacity());
//            PrintTools.judgeWei(inventory.getInventoryUseCapacity(),3,2,3);
//            System.out.println(inventory.getInventoryWarnCapacity());
        }
    }
}
