package cn.jiruan.dao.Impl;

import cn.jiruan.dao.IPLinkWDao;
import cn.jiruan.pojo.PLinkW;
import cn.jiruan.pojo.Product;
import cn.jiruan.pojo.WareHouse;
import cn.jiruan.util.DBHelper;

import java.util.ArrayList;

public class PLinkWDaoImpl implements IPLinkWDao {
    @Override
    public ArrayList<PLinkW> selectByProducePrimaryKey(Product product) {

        String sql="select * from plinkw where productprimarykey=?";
        ArrayList<Object> arr= DBHelper.currencySqlQuery(PLinkW.class,sql,product.getProductPrimaryKey());
        ArrayList<PLinkW> list=new ArrayList<>();
        if (arr != null) {
            for (Object o:arr){
                PLinkW plinkW=(PLinkW)o;
                list.add(plinkW);
            }
        }

        return list;
    }

    @Override
    public ArrayList<PLinkW> selectByWareHousePrimaryKey(WareHouse wh) {

        String sql="select * from plinkw where wareHousePrimaryKey" +
                "=?";
        ArrayList<Object> arr= DBHelper.currencySqlQuery(PLinkW.class,sql,wh.getWareHousePrimaryKey());
        ArrayList<PLinkW> list=new ArrayList<>();
        if (arr != null) {
            for (Object o:arr){
                PLinkW plinkW=(PLinkW)o;
                list.add(plinkW);
            }
        }

        return list;

    }

    @Override
    public int insertPLikW(PLinkW pLinkW) {
        return 0;
    }
}
