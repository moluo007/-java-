package cn.jiruan.dao.Impl;

import cn.jiruan.dao.IInventoryDao;
import cn.jiruan.dao.IWareHouseDao;
import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.util.DBHelper;
import cn.jiruan.util.PageHelper;

import java.util.*;

public class InventoryDaoImpl implements IInventoryDao {

    private final IWareHouseDao wareHouseDao = new WareHouseDaoImpl();
    //////新增////////////////////
    @Override
    public int insertInventory(int wHPrimaryKey, Inventory inventory) {
        String sql = "INSERT INTO inventory (wareHousePrimaryKey,inventoryAllCapacity,inventoryUseCapacity" +
                ",inventoryWarnCapacity,inventoryType)VALUES (?,?,?, ?, ?)";

        // 3. 传递参数（注意顺序与?一一对应）
        Object[] params = {
                wHPrimaryKey,  // 仓库主键（对应wareHousePrimaryKey字段）
                inventory.getInventoryAllCapacity(),
                inventory.getInventoryUseCapacity(),
                inventory.getInventoryWarnCapacity(),
                inventory.getInventoryType()
        };

        return DBHelper.currencySqlUpdate(sql, params);
    }


    //////查找///////////////////
    //通过产品条件和分页工具类返回查询结果

    /*本方法调用da0层sql语句 返回所有符合条件的Inventory数据的数量*/
    @Override
    public Integer selectInventoryCount(Inventory inventory) {
        if (inventory == null) {
            return 0;
        }


        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM inventory WHERE 1=1");
        List<Object> params = new LinkedList<>();


        if (inventory.getInventoryAllCapacity() != null) {
            sql.append(" AND inventoryAllCapacity = ?");
            params.add("%"+inventory.getInventoryAllCapacity()+"%");
        }

        // 库存已用容量（支持范围查询）
        if (inventory.getInventoryUseCapacity() != null) {
            sql.append(" AND inventoryUseCapacity = ?");
            params.add("%"+inventory.getInventoryUseCapacity()+"%");
        }


        if (inventory.getInventoryWarnCapacity() != null) {
            sql.append(" AND inventoryWarnCapacity = ?");
            params.add("%"+inventory.getInventoryWarnCapacity()+"%");
        }


        if (inventory.getInventoryType() != null && !inventory.getInventoryType().trim().isEmpty()) {
            sql.append(" AND inventoryType = ?");
            params.add("%"+inventory.getInventoryType().trim()+"%");
        }


        return DBHelper.currencySqlQuery(sql.toString(), params.toArray());
    }


        /*本方法对应首先调用dao层sql语句 根据库存数据和页码 查找符合条件的Inventory对象 以集合形式返回*/
        @Override
        public Map<WareHouse, Inventory> selectByInventory(Inventory inventory, PageHelper pageHelper) {
            StringBuilder sql = new StringBuilder("SELECT * FROM inventory WHERE 1=1");
            ArrayList<Object> params = new ArrayList<>();

            // 添加查询条件（根据库存属性过滤）
            if (inventory.getInventoryUseCapacity() != null) {
                sql.append(" AND inventoryUseCapacity = ?");
                params.add(inventory.getInventoryUseCapacity());
                  }
            if (inventory.getInventoryAllCapacity() != null) {
                sql.append(" AND inventoryAllCapacity = ?");
                params.add(inventory.getInventoryAllCapacity());
            }
            if (inventory.getInventoryWarnCapacity() != null) {
                sql.append(" AND inventoryWarnCapacity = ?");
                params.add(inventory.getInventoryWarnCapacity());
            }
            if (inventory.getInventoryType() != null && !inventory.getInventoryType().trim().isEmpty()) {
                sql.append(" AND inventoryType LIKE ?");
                params.add("%" + inventory.getInventoryType().trim() + "%");
            }
            if (inventory.getWareHousePrimaryKey() != null) {
                sql.append(" AND wareHousePrimaryKey = ?");
                params.add(inventory.getWareHousePrimaryKey());
            }
            if (inventory.getInventoryPrimaryKey() != null) {
                sql.append(" AND inventoryPrimaryKey = ?");
                params.add(inventory.getInventoryPrimaryKey());
            }

            // 2. 添加分页参数（LIMIT 偏移量, 每页条数）
            // 偏移量 = (当前页-1) * 每页显示数量
            sql.append(" LIMIT ?, ?");
            params.add((pageHelper.getPageIndex() - 1) * pageHelper.getShowNumber());
            params.add(pageHelper.getShowNumber());

            // 3. 执行分页查询，获取当前页的库存列表
            ArrayList<Object> inventoryList = DBHelper.currencySqlQuery(Inventory.class, sql.toString(), params.toArray());
            if (inventoryList == null || inventoryList.isEmpty()) {
                return new HashMap<>(); // 无数据时返回空Map
            }

            // 4. 关联查询库存对应的仓库信息，构建返回的Map
            Map<WareHouse, Inventory> resultMap = new HashMap<>();
            for (Object obj : inventoryList) {
                if (obj instanceof Inventory inv) {   //Java 16 引入了 模式匹配 instanceof，允许在判断类型的同时完成转换并赋值给变量
                    // 根据库存关联的仓库主键查询仓库信息
                    WareHouse wareHouse = wareHouseDao.selectWareHouseByPrimaryKey(inv.getWareHousePrimaryKey());   //根据库存里有仓库主键在仓库表找仓库对象
                    if (wareHouse != null) {
                        resultMap.put(wareHouse, inv);
                    }
                }
            }

            return resultMap;

        }





    //查询所有的库存,以及库存所对应的仓库,以键值对形式返回
    @Override
    public Map<WareHouse, Inventory> selectAllInventory() {
        String sql1 = "select * from inventory";
        Map<WareHouse,Inventory> returnMap = new HashMap<>();
        ArrayList<Object> arrInventory = DBHelper.currencySqlQuery(Inventory.class,sql1);
        if(arrInventory == null) return returnMap;

        String sql2 = "select * from warehouse where wareHousePrimaryKey=?";

        for(Object o : arrInventory){

            if(o instanceof Inventory){
                WareHouse iWareHouse = (WareHouse) Objects.requireNonNull(DBHelper.currencySqlQuery(WareHouse.class,
                        sql2, ((Inventory) o).getWareHousePrimaryKey())). getFirst();
                returnMap.put(iWareHouse, (Inventory) o);

            }   //Objects.requireNonNull() 是 java.util.Objects 类提供的一个静态方法，用于检查对象是否为 null。如果被检查的对象是 null，它会抛出 NullPointerException；如果不是 null，则直接返回该对象本身


        }
        return returnMap;
    }


    //通过主键在 库存表中 精准的找到对应库存
    /* addProduceInWareHouse方法首先调用 dao层sql语句 根据ID 在 库存表(Inventory) 中 找到对应的库存
     *  数据*/
    @Override
    public Inventory selectInventoryByIdKey(Integer inventoryPrimaryKey) {
        String sql="select * from inventory where inventoryPrimaryKey = ?";
        ArrayList<Object> resultList = DBHelper.currencySqlQuery(Inventory.class, sql, inventoryPrimaryKey);

        // 判断查询结果是否为空
        if (resultList == null || resultList.isEmpty()) {
            return null; // 库存不存在，返回 null
        }


        return (Inventory) resultList.getFirst();


    }

    /* 使用 dao层sql语句 对 库存表(Inventory)中的 对应库存数据进行修改*/
    @Override
    public int updateInventory(Inventory inventory) {
       String sql="update inventory set inventoryUseCapacity = ?,inventoryAllCapacity = ?,inventoryWarnCapacity = ?,inventoryType = ? where inventoryPrimaryKey = ?";
       return DBHelper.currencySqlUpdate(sql,inventory.getInventoryUseCapacity(),inventory.getInventoryAllCapacity(),inventory.getInventoryWarnCapacity(),inventory.getInventoryType(),inventory.getInventoryPrimaryKey());
    }
}
