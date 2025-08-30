package cn.jiruan.dao.Impl;

import cn.jiruan.dao.IProductDao;
import cn.jiruan.pojo.Product;
import cn.jiruan.util.DBHelper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductDaoImpl implements IProductDao {
    @Override
//    /**
//     * 根据产品主键查询产品信息
//     * @param product 包含查询条件的Product对象，其中productPrimaryKey用于指定要查询的产品ID
//     * @return 返回查询到的Product对象，如果未找到则返回null
//     */
    public Product selectProductByPrimaryKey(Integer productKey) {
        if (productKey == null ) {
            return null;
        }
        String sql = "SELECT * FROM product WHERE productPrimaryKey = ?";

        ArrayList<Object> OBJ=DBHelper.currencySqlQuery(Product.class,sql, productKey);

        ArrayList<Product> list = new ArrayList<>();
        if (OBJ != null) {
            for (Object obj : OBJ) {
                if (obj instanceof Product){
                    list.add((Product) obj);

                }
            }
        }
        return !list.isEmpty() ? list.getFirst() : null;
    }



    //通过产品数据找到对应产品主键
    //select inventoryPrimaryKey from inventory where ...........
    /*本方法对应根据产品数据 找到 对应产品数据主键*/
    @Override
    public int selectProductPrimaryKey(Product product) {
        StringBuilder sql=new StringBuilder("select productPrimaryKey from product where 1=1");
        ArrayList<Object> list=new ArrayList<>();
        if (product.getProductId()!=null) {
            sql.append(" and productId = ?");
            list.add(product.getProductId());
        }if (product.getProductName()!=null) {
            sql.append(" and productName = ?");
            list.add(product.getProductName());
        }if (product.getProductDate()!=null) {
            sql.append(" and productType = ?");
            list.add(product.getProductDate());
        }if (product.getProductType()!=null) {
            sql.append(" and productDate = ?");
            list.add(product.getProductDate());
        }if (product.getQualityDate()!=null) {
            sql.append(" and qualityDate = ?");
            list.add(product.getQualityDate());
        }
        return DBHelper.currencySqlQuery(sql.toString(), list.toArray());
    }


    //获取所有产品的对象（含主键）及其对应剩余日期的Map集合(已实现)
    //SELECT productPrimaryKey,DATEDIFF(DATE_ADD(produceDate, INTERVAL qualityDate DAY), CURDATE()) AS 剩余天数 FROM product
    @Override
  @SuppressWarnings("all")
    public Map<Object, String> selectRemainingDates() {
        Connection conn = DBHelper.getConnection();
        try{
            String sql = "SELECT \n" +
                    "    productPrimaryKey,\n" +
                    "    productId,\n" +
                    "    productName,\n" +
                    "    productType,\n" +
                    "    productDate,\n" +
                    "    qualityDate,\n" +
                    "    DATEDIFF(\n" +
                    "        DATE_ADD(productDate, INTERVAL qualityDate DAY),\n" +
                    "        CURDATE()\n" +
                    "    ) AS remainingDays\n" +  // 建议使用英文列名
                    "FROM \n" +
                    "    product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Map<Object, String> map = new HashMap<>();

            Field[] fields = Product.class.getDeclaredFields();
            while(rs.next()){
                Product p = Product.class.newInstance();
                for(Field field : fields){
                    field.setAccessible(true);
                    field.set(p,rs.getObject(field.getName()));
                }
                map.put(p,rs.getString(7));
            }
            return map;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //根据产品数据找到对应产品主键
    @Override
    public Product selectProductById(Product product) {
        String sql="select * from product where productId = ?";
        return (Product) Objects.requireNonNull(DBHelper.currencySqlQuery(Product.class, sql, product.getProductId())).getFirst();
    }
}

