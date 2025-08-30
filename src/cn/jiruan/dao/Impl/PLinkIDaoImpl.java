package cn.jiruan.dao.Impl;

import cn.jiruan.dao.IPLinkIDao;
import cn.jiruan.pojo.Inventory;
import cn.jiruan.pojo.PLinkI;
import cn.jiruan.pojo.Product;
import cn.jiruan.util.DBHelper;

import java.util.ArrayList;

public class PLinkIDaoImpl implements IPLinkIDao {

    @Override
    public ArrayList<PLinkI> selectByProducePrimaryKey(Product product) {

        String sql = "select * from plinki where productPrimaryKey= ? ";

        ArrayList<Object> arr = DBHelper.currencySqlQuery(PLinkI.class, sql, product.getProductPrimaryKey());
        ArrayList<PLinkI> plinkIs = new ArrayList<>();

        // 增加空指针判断，避免arr为null时出现异常
        if (arr != null) {
            for (Object o : arr) {
                if (o instanceof PLinkI) {
                    plinkIs.add((PLinkI) o);
                }
            }
        }

        return plinkIs;
    }

    //通过库存主键查询对应数据
    @Override
    public ArrayList<PLinkI> selectByInventoryPrimaryKey(Inventory inventory) {
        String sql = "select from plinki where inventoryPrimaryKey= ? ";
        ArrayList<Object> arr = DBHelper.currencySqlQuery(PLinkI.class, sql, inventory.getInventoryPrimaryKey());
        ArrayList<PLinkI> plinkIs = new ArrayList<>();

        if (arr != null) {
            for (Object o : arr) {
                if (o instanceof PLinkI) {
                    plinkIs.add((PLinkI) o);
                }
            }
        }
        return plinkIs;
    }

    @Override
    public int insertPLinkI(PLinkI pLinkI) {
        return 0;
    }
}
