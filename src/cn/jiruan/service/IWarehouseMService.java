package cn.jiruan.service;

import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.util.PageHelper;

import java.util.ArrayList;

public interface IWarehouseMService {

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
    boolean addWareHouse(WareHouse wareHouse);

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

    Integer queryWareHouseCount(WareHouse wareHouse);  //返回总条数
/**
 * 查询仓库信息的方法
 * @param wareHouse 仓库对象，包含查询条件
 * @param ph 分页助手对象，用于分页查询
 * @return 返回符合条件的仓库列表
 */
    ArrayList<WareHouse> queryWareHouse(WareHouse wareHouse, PageHelper ph);

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
    boolean changeWareHouse(WareHouse wareHouse);

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
    boolean deleteWareHouse(WareHouse wareHouse);

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
    boolean addInventory(WareHouse wareHouse, Inventory inventory);
}
