package cn.jiruan.dao;

import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.PLinkI;
import cn.jiruan.pojo.Product;

import java.util.ArrayList;

public interface IPLinkIDao {
    //通过产品主键查询对应数据
    ArrayList<PLinkI> selectByProducePrimaryKey(Product product);
    //通过库存主键查询对应数据
    ArrayList<PLinkI> selectByInventoryPrimaryKey(Inventory inventory);

    //通过产品主键与库存主键关联关系
    int insertPLinkI(PLinkI pLinkI);
}
