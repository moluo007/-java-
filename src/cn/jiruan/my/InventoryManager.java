package cn.jiruan.my;

import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.service.IInventoryMService;
import cn.jiruan.service.Impl.InventoryMServiceImpl;
import cn.jiruan.util.PageHelper;

import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    private static final Scanner input = new Scanner(System.in);
    private static final IInventoryMService iInventoryMService =  new InventoryMServiceImpl();
    private static final InventoryFunction inventoryFunction = new InventoryFunction();

    public static void inventoryManager(){
        System.out.println("======================[库存管理]=====================");
        System.out.print("1.库存查询\n输入其它键退出\n请选择：");
        String choice = input.next();
        try{
            if (choice.equals("1")) {//库存查询
//                Thread.sleep(1000);
                queryInventory();
            }
        }catch(Exception ignored){}
    }

    @SuppressWarnings("all")
    //库存查询
    private static void queryInventory(){
        PageHelper ph = new PageHelper();
        ph.setDateCount(iInventoryMService.queryInventoryCount(new Inventory()));
        Map<WareHouse, Inventory> printMap = iInventoryMService.queryInventory(new Inventory(), ph);   //根据库存 找到对应仓库
        System.out.println("======================[库存查询]=====================");
        try{
            System.out.println("==正在查询.....");
//            Thread.sleep(1500);
            //默认打印第一页
            inventoryFunction.printInventoryArr(printMap);
            while (true) {
                //库存预警
                warehouseManagement.capacityWarning();
                //
                System.out.println("==================================================");
                System.out.println("===上一页[-1]==|当前是第[" + ph.getPageIndex() + "/" + ph.getPageCount() + "]页|==下一页[+1]===");
                System.out.println("==================================================");
                System.out.println("===1.产品入库\t===2.产品出库\t===3.产品调拨\t===输入其它退出");
                System.out.print("===请选择(+1/-1/1/2/3):");
                String choice = input.next();
//                PrintTools.judgePage(choice, ph, "-1", "+1");
                ph=tools.pageChange(choice,ph,"-1","+1");  //改变page索引
                switch (choice) {
                    case "+1":
                    case "-1":
                        if("+1".equals(choice) || "-1".equals(choice)){
                            inventoryFunction.printInventoryArr(iInventoryMService.queryInventory(new Inventory(), ph));
                        }
                        break;
                    case "1":
                        //产品入库
//                        Thread.sleep(1000);
                        inventoryFunction.inInventory();
                        break;
                    case "2":
                        //产品出库
//                        Thread.sleep(1000);
                        inventoryFunction.outInventory();
                        break;
                    case "3":
                        //产品调拨
//                        Thread.sleep(1000);
                        inventoryFunction.productAllocation();
                        break;
                    default:
                        //退出库存查询
                        return;
                }
            }
        }catch(Exception ignored){
            System.out.println(" queryInventory  出异常了");
        }
    }
}
