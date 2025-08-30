package cn.jiruan.dao;

import cn.jiruan.pojo.Product;

import java.util.Map;

public interface IProductDao {
    //通过产品主键 找 数据打包的产品对象
    /*根据产品主键 找到 对应产品(返回有全部产品信息的Product对象)*/
    Product selectProductByPrimaryKey(Integer productPrimaryKey);

    //通过产品数据找到对应产品主键
    //select inventoryPrimaryKey from inventory where ...........
    /*本方法对应根据产品数据 找到 对应产品数据主键*/
    int selectProductPrimaryKey(Product product);

    //获取所有产品的对象（含主键）及其对应剩余日期的Map集合(已实现)
    //SELECT productPrimaryKey,DATEDIFF(DATE_ADD(produceDate, INTERVAL qualityDate DAY), CURDATE()) AS 剩余天数 FROM product
    Map<Object,String> selectRemainingDates();


    //根据产品数据找到对应产品主键
    Product selectProductById(Product product);
}
