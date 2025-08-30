package cn.jiruan.service.Impl;

import cn.jiruan.dao.*;
import cn.jiruan.dao.Impl.*;
import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.PLinkI;
import cn.jiruan.pojo.Product;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.service.IInventoryMService;
import cn.jiruan.util.PageHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryMServiceImpl implements IInventoryMService {
    IInventoryDao inventoryDao = new InventoryDaoImpl();


    IProductDao iprd = new ProductDaoImpl();
    IPLinkIDao ipld = new PLinkIDaoImpl();





    //分页查询
    /*获取符合条件的数据数量*/
    @Override
    public Integer queryInventoryCount(Inventory inventory) {    // IInventoryDao inventoryDao = new InventoryDaoImpl();
        return inventoryDao.selectInventoryCount(inventory);
    }
    /*获取对应页码的数据集合*/



    @Override
    public Map<WareHouse,Inventory> queryInventory(Inventory inventory, PageHelper page) {


        return inventoryDao.selectByInventory(inventory, page);


    }


//入库===================================
    /*
     *  <--------困难--------->
     *  @1. 输入产品编号、数量，根据产品编号和数量(该数量为用户要存放多少产品)查询可以存放产品的库存，
     *  @2. 选择要存放的库存，
     *  @3. 将产品存入仓库。
     *  *产品数据不需要系统维护，从产品表中获取。
     *  *注意：存入产品要根据类型校验库存是否可以存放该产品。
     *   例如，冰淇淋不能存放在常温仓库中。
     *  *同样产品数量和库存容量也要做校验。
     *
     *  1. 首先要将用户输入的产品数据 打包成Product对象 与产品入库数量 一同传入 queryInWareHouse方法中
     *  2. queryInWareHouse方法首先调用 dao层sql语句 在产品库存关联表(PLinkI) 中
     *       2.1 先根据产品数据 找到 对应产品数据主键
     *       2.2 再根据产品数据主键 在 产品库存关联表(PLinkI)中找到所有对应着产品数据主键的库存数据
     *           并以集合形式返回到 queryInWareHouse 方法中 -> 以集合形式存储(arrTemp)
     *  3. 再根据 产品入库数量(要计算产品数量加上库存已用容量 是否大于库存最大容量，若大于则不满足要求) 将
     *     arrTemp 中的数据进行二次筛选 找到所有符合条件的库存
     *       3.1 得到一个 由满足条件的 库存对象 所组成的一个集合
     *       3.2 返回到用户层 让用户做下一步选择
     *  4. 用户做出选择后 将用户所选择的库存编号 打包成Inventory对象 与 打包成Product对象的产品数据
     *     和 产品入库数量 一同传入 addProduceInWareHouse 中
     *  5. addProduceInWareHouse方法首先调用 dao层sql语句 根据库存主键 在 库存表(Inventory) 中 找到对应的库存
     *     数据和仓库数据(通过库存数据中的主键找)*
     *       5.1 先判断仓库数据中的容量加上产品入库容量是否大于仓库总容量
     *               -> 大于总容量 -> 返回false
     *  6. 使用 dao层sql语句 对 库存表(Inventory)中的 对应库存数据进行修改(当前容量加上产品入库数量)
     *  7. 使用 dao层sql语句 对 仓库表(Warehouse)中的 对应仓库数据[通过库存表中的仓库主键找到仓库表中数据]
     *     进行修改(当前容量加上产品入库容量)
     *  8. 再计算 库存对应仓库 加上产品入库数量 是否满足： 仓库当前容量 加上 入库数量 是否大于总容量
     *            -> 若大于 则不计入返回集合
     *            -> 若不大于 则计入返回集合
     *            8.1 得到一个 由满足条件的 库存对象 所组成的一个集合
     *            8.2 返回到用户层 让用户做下一步选择
     * */

    //入库===================================
    //1.打印可入库列表
    /*根据产品编号和 产品数量*/
    @Override
    public ArrayList<Inventory> queryInWareHouse(Product product, int num) {    //num  产品数量


        int key = iprd.selectProductPrimaryKey(product);  //产品编号找产品主键
        //将主键存入对象
        product.setProductPrimaryKey(key);


        // 检查产品是否有关联记录
        List<PLinkI> pLinkIs = ipld.selectByProducePrimaryKey(product);
        if (pLinkIs == null || pLinkIs.isEmpty()) {
            System.out.println("我是空加");
            return new ArrayList<>();  // 返回空列表，避免空指针异常
        }

        ArrayList<Inventory> arrTemp = new ArrayList<>();  //创建一个空的库存列表
        for (PLinkI pLinkI : pLinkIs) {

            Integer inventory=pLinkI.getInventoryPrimaryKey();
            arrTemp.add(inventoryDao.selectInventoryByIdKey(inventory));//将库存数据存到arrtemp

        }


        return arrTemp;   //inventory类型  产品编号对应仓库

    }





    //2.产品入库
    //-> 把产品加入到选择后的库存对应的仓库中
    @Override
    public boolean addProduceInWareHouse(Product product, int num, Inventory inventory) {

        ArrayList<Inventory> arrTemp=queryInWareHouse(product,num);   //ArrayList<Inventory> queryInWareHouse
        if (arrTemp == null || arrTemp.isEmpty() || arrTemp.getFirst().getInventoryPrimaryKey() == null) {
            return false;   //进行容量判断
        }

        else if ((arrTemp.getFirst().getInventoryUseCapacity() + num) > arrTemp.getFirst().getInventoryAllCapacity()) {
            return false;

    }

     //通过产品编号，得出库存


        //根据库存主键 找到库存数据
        Inventory id=inventoryDao.selectInventoryByIdKey(inventory.getInventoryPrimaryKey());

        id.setInventoryUseCapacity(id.getInventoryUseCapacity()+num);


        return inventoryDao.updateInventory(id)>0;
    }




    //出库===================================
    /*
     *  <--------困难--------->
     *  @1. 输入产品编号、数量(库存剩余数量要大于等于出库数量)，根据产品编号和数量查询满足条件的库存，@
     *  @2. 选择库存，
     *  @3. 将产品出库。
     *
     *  1. 首先要将用户输入的产品数据 打包成Product对象 与产品出库数量 一同传入 queryOutWareHouse方法中
     *  2. queryInWareHouse方法首先调用 dao层sql语句 在产品库存关联表(PLinkI) 中
     *          2.2 先根据产品数据 找到 对应产品(返回有全部产品信息的Product对象)
     *          2.1 再根据产品 找到 对应产品数据主键
     *          2.2 再根据产品数据主键 在 产品库存关联表(PLinkI)中找到所有对应着产品数据主键的库存数据
     *              并以集合形式返回到 queryOutWareHouse 方法中 -> 以集合形式存储(arrTemp)
     *  3. 再根据 产品数量(要计算库存已用容量减去出库数量 是否大于等于0，若小于0则不满足要求) 与 产品类型
     *     (产品类型与库存类型一一对应 EG: 冷冻产品-冷冻仓库、高温产品-高温仓库、常温产品-常温仓库) 将
     *     arrTemp 中的数据进行二次筛选
     *          3.1 得到一个 由满足条件的 库存对象 所组成的一个集合
     *          3.2 返回到用户层 让用户做下一步选择
     *  4. 用户做出选择后 将用户所选择的库存编号 打包成Inventory对象 与 打包成Product对象的产品数据
     *     和 产品数量 一同传入 outProduceInWareHouse 中
     *  5. outProduceInWareHouse方法首先调用 dao层sql语句 在 库存表(Inventory) 中 找到对应的库存
     *     数据 和 仓库数据(通过库存数据中的主键找)
     *  6. 使用 dao层sql语句 对 库存表(Inventory)中的 对应库存数据进行修改(当前容量减去产品数量)
     *  7. 使用 dao层sql语句 对 6.中 找到的库存表 对应的 仓库数据 进行修改(当前容量减去产品容量)
     * */
    //1.打印可出库列表
    /*根据产品编号和 产品数量*/
    @Override
    public ArrayList<Inventory> queryOutWareHouse(Product product, int num) {
        int key = iprd.selectProductPrimaryKey(product);  //产品编号找产品主键
        //将主键存入对象

        product.setProductPrimaryKey(key);  //将product主键存入对象

        ArrayList<PLinkI> pLink= ipld.selectByProducePrimaryKey(product);  //根据产品主键找库存主键


        if (pLink==null|| pLink.isEmpty() || pLink.getFirst().getInventoryPrimaryKey() == null) {
            return new ArrayList<>();  // 返回空列表，避免空指针异常
        }

        ArrayList<Inventory> arrTemp = new ArrayList<>();  //创建一个空的库存列表
        for (PLinkI pLinkI : pLink) {
            Integer inventory=pLinkI.getInventoryPrimaryKey();
            arrTemp.add(inventoryDao.selectInventoryByIdKey(inventory));//将库存数据存到arrtemp
        }return arrTemp;   //得到产品的关联的库存对象

    }


    //2.产品出库
    @Override
    public boolean outProduceInWareHouse(Product product, int num, Inventory inventory) {
        ArrayList<Inventory> arrTemp=queryOutWareHouse(product,num);   //ArrayList<Inventory> queryOutWareHouse
        if (arrTemp == null ||  arrTemp.isEmpty() || arrTemp.getFirst().getInventoryPrimaryKey() == null) {
            return false;   //进行容量判断
        }
        else if ((arrTemp.getFirst().getInventoryUseCapacity() - num) < 0) {
            return false;
        }//通过产品编号，得出库存
        //根据库存主键 找到库存数据
        Inventory id=inventoryDao.selectInventoryByIdKey(inventory.getInventoryPrimaryKey());
        id.setInventoryUseCapacity(id.getInventoryUseCapacity()-num);
        //        inventory.setInventoryUseCapacity( id.getInventoryUseCapacity()- num);
        return inventoryDao.updateInventory(id)>0;
    }



    //调拨
    /*两个仓库之间修改容量, 一个减少，一个增加*/
    /*  @1. 输入产品编号、数量，
     *   @2. 根据产品编号和数量查询满足条件的库存，选择库存，
     *   @3. 再查询可以存放产品的库存，
     *   @4. 进行产品调拨。
     *
     *  {-------------->打印可出库列表
     *   1. 首先要将用户输入的产品数据 打包成Product对象 与产品出库数量 一同传入 queryOutWareHouse方法中
     *   2. queryInWareHouse方法首先调用 dao层sql语句 在产品库存关联表(PLinkI) 中
     *          2.2 先根据产品数据 找到 对应产品(返回有全部产品信息的Product对象)
     *          2.1 再根据产品 找到 对应产品数据主键
     *          2.2 再根据产品数据主键 在 产品库存关联表(PLinkI)中找到所有对应着产品数据主键的库存数据
     *              并以集合形式返回到 queryOutWareHouse 方法中 -> 以集合形式存储(arrTemp)
     *   3. 再根据 产品数量(要计算库存已用容量减去出库数量 是否大于等于0，若小于0则不满足要求) 与 产品类型
     *      (产品类型与库存类型一一对应 EG: 冷冻产品-冷冻仓库、高温产品-高温仓库、常温产品-常温仓库)
     *      将arrTemp 中的数据进行二次筛选
     *           3.1 得到一个 由满足条件的 库存对象 所组成的一个集合
     *           3.2 返回到用户层 让用户做下一步选择
     *  }
     *
     *   4. 用户做出选择后 将用户所选择的库存编号 打包成Inventory对象(inventoryOut) 存放 在用户层中
     *
     *  {-------------->打印可入库列表
     *   5. 再将用户第一次输入的产品数据 打包成Product对象 与产品入库数量 一同传入 queryInWareHouse方法中
     *   6. queryInWareHouse方法首先调用 dao层sql语句 在产品库存关联表(PLinkI) 中
     *           6.1 先根据产品数据 找到 对应产品(返回有全部产品信息的Product对象)
     *           6.2 再根据产品 找到 对应产品数据主键
     *           6.3 再根据产品数据主键 在 产品库存关联表(PLinkI)中找到所有对应着产品数据主键的库存数据
     *            并以集合形式返回到 queryInWareHouse 方法中 -> 以集合形式存储(arrTemp)
     *   7. 再根据 产品入库数量(要计算产品数量加上库存已用容量 是否大于库存最大容量，若大于则不满足要求) 与
     *      产品类型(产品类型与库存类型一一对应 EG: 冷冻产品-冷冻仓库、高温产品-高温仓库、常温产品-常温仓库)
     *      将 arrTemp 中的数据进行二次筛选 找到所有符合条件的库存
     *   8. 再计算 库存对应仓库 加上产品入库数量 是否满足： 仓库当前容量 加上 入库数量 是否大于总容量
     *           -> 若大于 则不计入返回集合
     *           -> 若不大于 则计入返回集合
     *           8.1 得到一个 由满足条件的 库存对象 所组成的一个集合
     *          8.2 返回到用户层 让用户做下一步选择
     *  }
     *
     *   8. 用户做出选择后 将用户所选择的库存编号 打包成Inventory对象(inventoryIn) 存放 在用户层中
     *   9. 将用户层存放的两个 Inventory对象(inventoryOut 和 inventoryIn) 以及 要调拨的数量(num)
     *      传入到方法： allocation 中
     *   9. allocation方法 首先使用 dao层sql指令 分别在 仓库表(Inventory) 中 找到对应的
     *      出库对象(inventoryOut) 和 入库对象(inventoryIn)
     *   10. 最后将出库对象的 已用容量 做修改 改为 已用容量-调拨数量(num)
     *       将入库对象的 已用容量 做修改 改为 已用容量+调拨数量(num)
     * */
    @Override           //传入了要入库的仓库主键，出库的出库主键   要出库的数量
    public boolean allocation(Inventory inventoryOut, Inventory inventoryIn, int num) {
                         Inventory inventoryo=inventoryDao.selectInventoryByIdKey(inventoryOut.getInventoryPrimaryKey()) ;      //   要出库的
                         Inventory inventoryi=inventoryDao.selectInventoryByIdKey(inventoryIn.getInventoryPrimaryKey());      //   要入库的
        if (inventoryo.getInventoryUseCapacity()-num<0||inventoryi.getInventoryUseCapacity()+num>inventoryi.getInventoryAllCapacity()){  //判断情况
            return false;
        }
        inventoryo.setInventoryUseCapacity(inventoryo.getInventoryUseCapacity()-num);  //给出库对象 的对应的数据库数据赋值准备
        inventoryi.setInventoryUseCapacity(inventoryi.getInventoryUseCapacity()+num);  //给入库对象 的对应的数据库数据赋值准备
        return inventoryDao.updateInventory(inventoryo)>0&&inventoryDao.updateInventory(inventoryi)>0;  //判断并 处理出库 和 入库

    }

}
