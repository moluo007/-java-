package cn.jiruan.dao;

import cn.jiruan.pojo.*;

import java.util.ArrayList;

public interface IPLinkWDao {
    //通过产品主键查询对应数据
    ArrayList<PLinkW> selectByProducePrimaryKey(Product product);
    //通过仓库主键查询对应数据
    ArrayList<PLinkW> selectByWareHousePrimaryKey(WareHouse wh);

    //建议一个产品仓库关联
    int insertPLikW(PLinkW pLinkW);
}
