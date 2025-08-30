package cn.jiruan.dao.Impl;

import cn.jiruan.dao.IWareHouseDao;
import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.util.DBHelper;
import cn.jiruan.util.PageHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class WareHouseDaoImpl implements IWareHouseDao {


    //新增
    @Override
    public int insertWareHouse(WareHouse wareHouse) {
        String sql="insert into  warehouse values(null,?,?,?,?)";
        Object[] obj={wareHouse.getWareHouseId(),wareHouse.getWareHouseName(),wareHouse.getWareHouseCapacity(),wareHouse.getWareHouseAddress()};
        return DBHelper.currencySqlUpdate(sql,obj);
    }


    //删除
    /*使用dao层sql语句删除对应数据*/
    @Override
    public int deleteWareHouse(WareHouse wareHouse) {
//        StringBuilder sql="delete from warehouse where warehousePrimaryKey = ?";
        StringBuilder sql = new StringBuilder("delete from warehouse where 1=1");
        ArrayList<Object> list = new ArrayList<>();
        if (wareHouse.getWareHouseName() != null) {
            sql.append(" and wareHouseName=?");
            list.add(wareHouse.getWareHouseName());
        }
        if (wareHouse.getWareHouseCapacity() != null) {
            sql.append(" and wareHouseCapacity=?");
            list.add(wareHouse.getWareHouseCapacity());
        }
        if (wareHouse.getWareHouseAddress() != null) {
            sql.append(" and wareHouseAddress=?");
            list.add(wareHouse.getWareHouseAddress());
        }if (wareHouse.getWareHousePrimaryKey() != null) {
            sql.append(" and wareHousePrimaryKey=?");
            list.add(wareHouse.getWareHousePrimaryKey());
        }if (wareHouse.getWareHouseId() != null) {
            sql.append(" and wareHouseId=?");
            list.add(wareHouse.getWareHouseId());
        }
        return DBHelper.currencySqlUpdate(sql.toString(), list.toArray());

    }


    //修改
    /*本方法首先调用dao层sql语句 根据仓库数据 精准修改对应数据*/
    @Override
    public int updateWareHouse(WareHouse wareHouse) {
//        String sql="";
//
//        if (wareHouse.getWareHouseId()!=-1&&wareHouse.getWareHousePrimaryKey()!= -1
//                &&wareHouse.getWareHouseName()!=null&&wareHouse.getWareHouseAddress()!=null
//                &&wareHouse.getWareHouseCapacity()!=null){
//
//            sql="update warehouse set warehouseId = ?,warehouseName = ?,wareHouseCapacity = ?,warehouseAddress = ? " +
//                    "where wareHousePrimaryKey = ?";
//
//        }   Object[] obj={wareHouse.getWareHouseId(),wareHouse.getWareHouseName(),wareHouse.getWareHouseCapacity(),wareHouse.getWareHouseAddress(),wareHouse.getWareHousePrimaryKey()};
//        return DBHelper.currencySqlUpdate(sql,obj);

        String sql="update warehouse set warehouseName = ?,wareHouseCapacity = ?,warehouseAddress = ? where wareHouseId = ?" ;
        Object[] obj={wareHouse.getWareHouseName(),wareHouse.getWareHouseCapacity(),wareHouse.getWareHouseAddress(),wareHouse.getWareHouseId()};
        return DBHelper.currencySqlUpdate(sql,obj);

    }


    /*本方法调用dao层sql来根据用户输入参数查询WareHouse是否已经存在*/
    @Override
    public int selectWareHouseExist(WareHouse wareHouse) {
        StringBuilder sql = new StringBuilder("select * from warehouse where 1=1");
        ArrayList<Object> list = new ArrayList<>();
        if (wareHouse.getWareHousePrimaryKey() != null) {
            sql.append(" and wareHousePrimaryKey=?");
            list.add(wareHouse.getWareHousePrimaryKey());
        }
        if (wareHouse.getWareHouseId() != null) {
            sql.append(" and wareHouseId=?");
            list.add(wareHouse.getWareHouseId());
        }
        if (wareHouse.getWareHouseName() != null) {
            sql.append(" and wareHouseName=?");
            list.add(wareHouse.getWareHouseName());
        }
        if (wareHouse.getWareHouseCapacity() != null) {
            sql.append(" and wareHouseCapacity=?");
            list.add(wareHouse.getWareHouseCapacity());
        }
        if (wareHouse.getWareHouseAddress() != null) {
            sql.append(" and wareHouseAddress=?");
            list.add(wareHouse.getWareHouseAddress());
        }
        return DBHelper.currencySqlQuery(sql.toString(), list.toArray());

    }



    /*本方法调用dao层sql来获取所有符合条件的warehouse数据*/
    @Override
    public int selectWareHouseCount(WareHouse wareHouse) {
        LinkedList<Object> ll=new LinkedList<>();


        StringBuilder sql=new StringBuilder("select count(*) from warehouse where 1=1 ");

        if(wareHouse.getWareHouseId() !=null){
            sql.append("and wareHouseId like ? ");
            ll.add("%"+wareHouse.getWareHouseId()+"%");
        }

        if(wareHouse.getWareHouseAddress()!=null){
            sql.append("and wareHouseAddress like ? ");
            ll.add("%"+wareHouse.getWareHouseAddress()+"%");
        }
        if(wareHouse.getWareHouseName() !=null){
            sql.append("and wareHouseName like ? ");
            ll.add("%"+wareHouse.getWareHouseName()+"%");
        }
        if(wareHouse.getWareHouseCapacity() !=null){
            sql.append("and wareHouseCapacity like ? ");
            ll.add("%"+wareHouse.getWareHouseCapacity()+"%");
        }
        return DBHelper.currencySqlQuery(sql.toString(),ll.toArray());
    }


    /*本方法首先调用dao层sql语句 根据仓库数据和页码 查找符合条件的WareHouse对象 以集合形式返回*/
    @Override
    public ArrayList<WareHouse> selectWareHouse(WareHouse wh, PageHelper pg) {

        LinkedList<Object> ll=new LinkedList<>();
        StringBuilder sql=new StringBuilder("select * from warehouse where 1=1");

        if(wh.getWareHouseId()!=null){
            sql.append(" and wareHouseId like ?");
            ll.add("%"+wh.getWareHouseId()+"%");
        }
        if(wh.getWareHouseName()!=null){
            sql.append(" and warehouseName like ?");
            ll.add("%"+wh.getWareHouseName()+"%");
        }
        if(wh.getWareHouseAddress()!=null){
            sql.append(" and warehouseAddress like ?");
            ll.add("%"+wh.getWareHouseAddress()+"%");
        }
        if(wh.getWareHouseCapacity()!=null){
            sql.append(" and wareHouseCapacity like ?");
            ll.add("%"+wh.getWareHouseCapacity()+"%");
        }

        sql.append(" limit ?,?");
        int offset = (pg.getPageIndex() - 1) * pg.getShowNumber();
        ll.add(offset);
        ll.add(pg.getShowNumber());
        ArrayList<Object> list=DBHelper.currencySqlQuery(WareHouse.class,sql.toString(),ll.toArray());
        ArrayList<WareHouse> backList = new ArrayList<>();
        if (list != null) {
            for (Object o : list) {
               if (o instanceof WareHouse) {
                   backList.add((WareHouse) o);

               }
            }
        }

        return backList;




}
    //查询主键的sql语句 需要动态查询
    //sql = "SELECT warehousePrimaryKey FROM warehouse ........."
    //.........部分  ->   WHERE wareHouseId = ? and wareHouseName = ? and............
    @Override
    public int selectWareHousePrimaryKey(WareHouse wareHouse) {
        StringBuilder sql = new StringBuilder("select * from warehouse where 1=1");
        ArrayList<Object> list = new ArrayList<>();
        if (wareHouse.getWareHouseName() != null) {
            sql.append(" and wareHouseName=?");
            list.add(wareHouse.getWareHouseName());
        }
        if (wareHouse.getWareHouseCapacity() != null) {
            sql.append(" and wareHouseCapacity=?");
            list.add(wareHouse.getWareHouseCapacity());
        }
        if (wareHouse.getWareHouseAddress() != null) {
            sql.append(" and wareHouseAddress=?");
            list.add(wareHouse.getWareHouseAddress());
        }if (wareHouse.getWareHouseId() != null) {
            sql.append(" and wareHouseId=?");
            list.add(wareHouse.getWareHouseId());
        }
        return DBHelper.currencySqlQuery(sql.toString(), list.toArray());


    }


    //根据仓库编号获取对应仓库已用容量
    @Override
    public int selectWareHouseCapacity(WareHouse wareHouse) {
        //根据仓库编号获得仓库主键
        String sql1 = "select * from warehouse where wareHouseId = ?";
        WareHouse wareHouseTemp = (WareHouse) Objects.requireNonNull(DBHelper.currencySqlQuery(WareHouse.class, sql1, wareHouse.getWareHouseId())).getFirst();
        Integer wPK =  wareHouseTemp.getWareHousePrimaryKey();
        //根据仓库主键在库存表中找到仓库所拥有的库存集合
        String sql2 = "select * from inventory where wareHousePrimaryKey = ?";
        ArrayList<Object> arrI = DBHelper.currencySqlQuery(Inventory.class, sql2, wPK);
        //计算获得已用容量
        int capacity = 0;
        if(arrI == null) return 0;
        for (Object o : arrI) {
            if(o instanceof Inventory){
                capacity += ((Inventory) o).getInventoryUseCapacity()!=null? ((Inventory) o).getInventoryUseCapacity() : 0;
            }
        }
        return capacity;
    }



    //主键获取
    /*2. 本方法首先调用dao层sql语句 根据 仓库数据 在 仓库表 中找到 对应 仓库数据 的 主键*/
    /*主键为 Integer 或者 int 类型*/
    @Override
    public WareHouse selectWareHouseByPrimaryKey(Integer wareHousePrimaryKey) {
        // 1. 校验主键是否为空
        if (wareHousePrimaryKey == null) {
            return null;
        }

        String sql = "select * from warehouse where wareHousePrimaryKey = ?";
        ArrayList<Object> objects = DBHelper.currencySqlQuery(WareHouse.class, sql, wareHousePrimaryKey);

        // 2. 判断查询结果是否为空
        if (objects == null || objects.isEmpty()) {
            return null; // 未查询到数据，返回null
        }

        // 3. 安全获取第一个元素
        return (WareHouse) objects.getFirst();
    }


}

