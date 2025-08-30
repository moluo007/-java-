package cn.jiruan.dao;

import cn.jiruan.pojo.WareHouse;
import cn.jiruan.util.PageHelper;

import java.util.ArrayList;

public interface IWareHouseDao {
    //新增
    int insertWareHouse(WareHouse wareHouse);
    //删除
    /*使用dao层sql语句删除对应数据*/
    int deleteWareHouse(WareHouse wareHouse);
    //修改
    /*本方法首先调用dao层sql语句 根据仓库数据 精准修改对应数据*/
    int updateWareHouse(WareHouse wareHouse);
    //查询
    /*本方法调用dao层sql来根据用户输入参数查询WareHouse是否已经存在*/
    int selectWareHouseExist(WareHouse wareHouse);
    /*本方法调用dao层sql来获取所有符合条件的warehouse数据数量*/
    int selectWareHouseCount(WareHouse wareHouse);
    /*本方法首先调用dao层sql语句 根据仓库数据和页码 查找符合条件的WareHouse对象 以集合形式返回*/
    ArrayList<WareHouse> selectWareHouse(WareHouse wareHouse, PageHelper pageHelper);
    /*本方法根据仓库编号获取仓库已用容量*/
    int selectWareHouseCapacity(WareHouse wareHouse);

/**
 * 根据主键查询仓库信息
 * @param wareHouseInteger 仓库主键ID
 * @return 返回对应的仓库对象，如果未找到则返回null
 */
    WareHouse selectWareHouseByPrimaryKey(Integer wareHousePrimaryKey);
    //主键获取
    /*2. 本方法首先调用dao层sql语句 根据 仓库数据 在 仓库表 中找到 对应 仓库数据 的 主键*/
    /*主键为 Integer 或者 int 类型*/
    int selectWareHousePrimaryKey(WareHouse wareHouse);


}
