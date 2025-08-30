package cn.jiruan.pojo;

public class PLinkW {

    private Integer primaryKey;

    private Integer productPrimaryKey;

    private Integer wareHousePrimaryKey;

    public PLinkW(Integer primaryKey, Integer productPrimaryKey, Integer wareHousePrimaryKey) {
        this.primaryKey = primaryKey;
        this.productPrimaryKey = productPrimaryKey;
        this.wareHousePrimaryKey = wareHousePrimaryKey;
    }

    public PLinkW() {
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getProductPrimaryKey() {
        return productPrimaryKey;
    }

    public void setProductPrimaryKey(Integer productPrimaryKey) {
        this.productPrimaryKey = productPrimaryKey;
    }

    public Integer getWareHousePrimaryKey() {
        return wareHousePrimaryKey;
    }

    public void setWareHousePrimaryKey(Integer wareHousePrimaryKey) {
        this.wareHousePrimaryKey = wareHousePrimaryKey;
    }
}
