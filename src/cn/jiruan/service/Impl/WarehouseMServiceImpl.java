package cn.jiruan.service.Impl;

import cn.jiruan.dao.*;
import cn.jiruan.dao.Impl.*;
import cn.jiruan.pojo.*;
import cn.jiruan.service.IWarehouseMService;
import cn.jiruan.util.PageHelper;

import java.util.ArrayList;

public class WarehouseMServiceImpl implements IWarehouseMService {



    IInventoryDao iinvd = new InventoryDaoImpl();
    IWareHouseDao iwh=new WareHouseDaoImpl();
    /*
     * 新建仓库:
     *
     * 新建一个未存在的仓库
     *
     * 1.将用户输入的信息 打包成WareHouse对象 传入本方法中
     * 2.本方法调用dao层sql来根据用户输入参数查询WareHouse是否已经存在
     * 3.若查询到WareHouse -> 新建失败，已经存在 -> 返回false
     * 4.若未查询到 -> 调用dao层sql添加新的WareHouse到WareHouse表 -> 新建成功 -> 返回true
     * */
    @Override
    public boolean addWareHouse(WareHouse wareHouse) {
        if (iwh.selectWareHouseExist(wareHouse) > 0) {
            return false;
        } else {
            iwh.insertWareHouse(wareHouse);
            return true;
        }
    }

    /*
     * 查询仓库:
     *
     * 根据用户输入的数据按照仓库名称或仓库类型查询仓库。分页仓库数据，每页10条数据。
     *
     * 展示项包括：仓库标识、仓库名称、仓库容量、仓库地址
     * 1.将用户输入的仓库数据 打包成WareHouse对象 以及查询页码 传入本方法中
     * 2.本方法首先调用dao层sql语句 根据仓库数据和页码 查找符合条件的WareHouse对象 以集合形式返回
     * 3.最后将该集合返回给 用户层
     * */



    //获取总条数
    @Override
    public Integer queryWareHouseCount(WareHouse wareHouse) {
        return iwh.selectWareHouseCount(wareHouse);
    }



    /**
     * 查询仓库信息的方法
     * @param wareHouse 仓库对象，包含查询条件
     * @param ph 分页助手对象，用于分页查询
     * @return 返回符合条件的仓库列表
     */
    @Override
    public ArrayList<WareHouse>    queryWareHouse(WareHouse wareHouse, PageHelper ph) {
        return iwh.selectWareHouse(wareHouse,ph);
    }

    /*
     * 修改仓库:
     *
     * 首先在仓库列表中选中仓库，然后对仓库数据进行修改
     * 输入项：仓库名称、仓库容量、仓库地址。
     *
     * 注意：修改容量要判断当前仓库存放的货物容量是否充足。
     * 1. 将用户输入的仓库数据 打包成WareHouse对象 传入本方法中
     * 2. 本方法首先调用dao层sql语句 根据仓库数据 精准修改对应数据
     * 3. 修改成功 -> 返回true
     * 4. 修改失败 -> 返回false
     * */
    @Override
    public boolean changeWareHouse(WareHouse wareHouse) {


        return iwh.updateWareHouse(wareHouse) > 0;
    }


    /*
     * 删除仓库:
     *
     * 删除在列表中选中的仓库。
     * 注意：删除仓库要判断仓库是否有货物，如果有货物不允许删除。
     *
     * 1. 将用户输入的仓库数据 打包成WareHouse对象 传入本方法中
     * 2. 本方法首先调用dao层sql语句 根据 仓库数据 在 仓库表 中找到 对应 仓库数据 的 主键
     * 3. 再根据获取到的主键 在 产品仓库关联表(PLinkW) 中 查询仓库是否有与产品建立的关联数据
     *       如果查询结果为 有 -> 则不允许删除 -> 返回false
     * 4. 如果查询结果为 无 -> 则允许删除 -> 使用dao层sql语句删除对应数据 -> 删除成功 -> 返回true
     *                                                            -> 删除失败 -> 返回false
     * */
    @Override
    public boolean deleteWareHouse(WareHouse wareHouse) {
//       WareHouse wh=iwh.selectWareHouseByPrimaryKey(iwh.selectWareHousePrimaryKey(wareHouse));  //根据名字/编号找主键，主键找仓库对象数据

//        int productKey=plwd.selectByWareHousePrimaryKey(wh).getFirst().getProductPrimaryKey();

        return iwh.deleteWareHouse(wareHouse) > 0;
    }


    /*
     * 添加!!库存!! ( 注意是库存，不是仓库!! )
     *
     * 首先选择仓库，添加库存。
     * 输入项：库存容量、库存已用容量、库存预警容量、库存类型。
     * 注意：要校验库存容量是否超过仓库容量。
     *
     * 1. 将用户选择的仓库编号数据 打包成WareHouse对象; 将用户输入的库存数据 打包成Inventory对象;
     * 2. 将上述两条数据打包成的对象 传入本方法中
     * 3. 本方法首先 根据用户传入的 WareHouse 对象 使用dao层sql语句 在 仓库表(WareHouse) 中 找到
     *    对应的 WareHouse数据的 主键
     * 4. 再 根据 用户传入的 Inventory 对象 在 库存表(Inventory) 中 添加新的Inventory数据
     * *****注意： 添加的新的Inventory数据中的 仓库主键 为 第三步中 获取到的 wareHouse数据的 主键
     * */

    @Override
    public boolean addInventory(WareHouse wareHouse, Inventory inventory) {
        Integer primaryKey =iwh.selectWareHousePrimaryKey(wareHouse);//通过参数找仓库主键(一开始没有不知道,后来问组长知道了)


        WareHouse wareHouse1 = iwh.selectWareHouseByPrimaryKey(primaryKey);//通过主键找warehouse
        /*System.out.println(wareHouse1.getWareHouseName());*/

        /*防止空指针,比较查找和输入用户名和密码是否相同(出现过空指针异常和密码不同也可以登录的问题)*/
        if (wareHouse1 != null && iwh.selectWareHouseCapacity(wareHouse1) < wareHouse1.getWareHouseCapacity()) {
            /*int i = iwhd.selectWareHousePrimaryKey(wareHouse);*/
            inventory.setWareHousePrimaryKey(primaryKey);
            iinvd.insertInventory(primaryKey, inventory);
            return true;
        } else {
            return false;
        }
    }
}












//
//@Override
//public boolean addProduceInWareHouse(Product product, int num, Inventory inventory) {
//    //得到当前用户选中的库存
//    Inventory selectedInventory = inventoryDao.selectInventoryByPrimaryKey(inventory.getInventoryPrimaryKey());
//    if(selectedInventory==null){
//        System.out.println("老子又为空啦哈哈哈哈哈");
//    }
//    //判断是否已经存在关联
//    Product productTemp = productDao.selectProductById(product);
//    ArrayList<PLinkI> arrLink = pLinkIDao.selectByProducePrimaryKey(productTemp);
//    boolean judge = false;
//    for(PLinkI link : arrLink){
//        if(link.getInventoryPrimaryKey().equals(selectedInventory.getInventoryPrimaryKey())){
//            //存在关联
//            judge = true;
//        }
//    }
//    if(judge == false){
//        //不存在关联 - 建立关联
//        //1.建立 当前产品 与 库存之间的关联
//        //2. 建立当前产品 与 仓库之间的关联
//        /// //////
//        PLinkI linkI = new PLinkI();
//        linkI.setInventoryPrimaryKey(selectedInventory.getInventoryPrimaryKey());
//        linkI.setProductPrimaryKey(productTemp.getProductPrimaryKey());
//        PLinkW linkW = new PLinkW();
//        linkW.setWareHousePrimaryKey(selectedInventory.getWareHousePrimaryKey());
//        linkW.setProductPrimaryKey(productTemp.getProductPrimaryKey());
//        if( pLinkIDao.insertPLinkI(linkI) > 0){
//            if(plinkWDao.insertPLinkW(linkW) > 0){
//                //对 - 库存 - 的容量进行修改
//                selectedInventory.setInventoryUseCapacity(selectedInventory.getInventoryUseCapacity() + num);
//                return inventoryDao.updateInventory(selectedInventory) > 0;
//            }
//            return false;
//        }
//        return false;
//    }
//    return false;
//}