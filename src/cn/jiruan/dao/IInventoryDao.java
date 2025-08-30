package cn.jiruan.dao;

import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.Product;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.util.PageHelper;

import java.util.ArrayList;
import java.util.Map;

public interface IInventoryDao {
    //////新增////////////////////
    int insertInventory(int wHPrimaryKey, Inventory inventory);
    //////查找///////////////////
    //通过产品条件和分页工具类返回查询结果
    /*本方法调用dao层sql语句 返回所有符合条件的Inventory数据的数量*/
    Integer selectInventoryCount(Inventory inventory);

    /*本方法对应首先调用dao层sql语句 根据库存数据和页码 查找符合条件的Inventory对象 以集合形式返回*/
    Map<WareHouse,Inventory> selectByInventory(Inventory inventory, PageHelper pageHelper);

    //查询所有的库存,以及库存所对应的仓库,以键值对形式返回
    Map<WareHouse,Inventory> selectAllInventory();


    //通过主键在 库存表中 精准的找到对应库存
    /* addProduceInWareHouse方法首先调用 dao层sql语句 根据库存主键 在 库存表(Inventory) 中 找到对应的库存
     *  数据*/
    Inventory selectInventoryByIdKey(Integer inventoryPrimaryKey);
    /// //修改//////////////////
    /* 使用 dao层sql语句 对 库存表(Inventory)中的 对应库存数据进行修改*/
    int updateInventory(Inventory inventory);
}
