package cn.jiruan.service.Impl;

import cn.jiruan.dao.*;
import cn.jiruan.dao.Impl.*;
import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.Product;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.service.IWarningService;

import java.util.HashMap;
import java.util.Map;

public class WarningServiceImpl implements IWarningService {


    IPLinkWDao pwd = new PLinkWDaoImpl();
    IPLinkIDao pid = new PLinkIDaoImpl();
    IProductDao pd = new ProductDaoImpl();

    IWareHouseDao wdao = new WareHouseDaoImpl();
    IInventoryDao iid = new InventoryDaoImpl();


    //质量预警
    /*
     * 查询仓库或库存时，根据产品保质期提示10天内要过期的产品，并显示所在仓库和库存。
     *
     * 1. 首先查询获取所有产品对象以及对应的剩余天数Map集合
     * 2. 遍历集合 -> 将所有剩余天数 < 10 的数据对应的产品对象存到一个ArrayList集合中
     * 3. 返回这个ArrayList集合
     * */
    @Override
    public Map<WareHouse, Inventory> qualityWarning() {
//        ArrayList<Product> arrayListProduct = new ArrayList<>();//先创建要存放的Product对象

        Map<Object, String> map = pd.selectRemainingDates();  //获得数据库产品的map集合


        Map<WareHouse, Inventory> warningMap = new HashMap<>();
        for (Map.Entry<Object, String> productDate : map.entrySet()) {
//            System.out.println(productDate.getValue());

            int wareHousePrimary = pwd.selectByProducePrimaryKey((Product)
                    productDate.getKey()).getFirst().getWareHousePrimaryKey();  //获取仓库主键

            int inventoryPrimary = pid.selectByProducePrimaryKey((Product)
                    productDate.getKey()).getFirst().getInventoryPrimaryKey();

            //预防产品获得的对应仓库，库存主键在仓库，库存表没有对应主键从而null
            WareHouse warehouse = wdao.selectWareHouseByPrimaryKey(wareHousePrimary);
            Inventory inventory = iid.selectInventoryByIdKey(inventoryPrimary);

            if (warehouse != null && inventory != null  ) {

                if (0 < Integer.parseInt(productDate.getValue()) && Integer.parseInt(productDate.getValue()) <= 10) {  //存放<10 的产品数据
                    //获取库存主键

                    warningMap.put(warehouse,inventory);//根据关联表获取 仓库 ，库存对象，在warningMap进行添加


                } else if (Integer.parseInt(productDate.getValue()) <= 0) {
                    System.out.println(((Product) productDate.getKey()).getProductId() + "的" + ((Product) productDate.getKey()).getProductName() + "该产品已过期");
                    warningMap.put(warehouse, inventory);
                }

            }
        }

//        for (Map.Entry<Inventory, WareHouse> entry : warningMap1.entrySet()) {
//            warningMap.put(entry.getValue(), entry.getKey());
//            System.out.println(entry.getValue()+""+entry.getKey());
//        }

        return warningMap;




        //打印库存对应仓库列表
//        Map<WareHouse,Inventory> warningMap1=new HashMap<>();
//        for(Inventory i:warningMap.values()){
//            for (WareHouse wh:warningMap.keySet()) {
//                if (Objects.equals(wh.getWareHousePrimaryKey(),i.getWareHousePrimaryKey())){
//                    warningMap1.put(wh,i);
//                   break;
//                }
//            }
//
//        }

//        优化系列  通过得到get方法从键找值，666
//        Map<Integer, WareHouse> warningPrimaryTemp = new HashMap<>();
//        for (WareHouse wh : warningMap.keySet()) {
//            warningPrimaryTemp.put(wh.getWareHousePrimaryKey(), wh);
//        }
//
//
//        Map<WareHouse, Inventory> warningMap1 = new HashMap<>();
//        for (Inventory i : warningMap.values()) {
//            WareHouse whTemp = warningPrimaryTemp.get(i.getWareHousePrimaryKey());
//            warningMap1.put(whTemp, i);
//        }


//        return warningMap;

    }
}