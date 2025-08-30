package cn.jiruan.pojo;

public class PLinkI {

    private Integer primaryKey;

    private Integer productPrimaryKey;

    private Integer inventoryPrimaryKey;

    //入库时间
    private String storageTime;

    public PLinkI(Integer primaryKey, Integer productPrimaryKey, Integer inventoryPrimaryKey, String storageTime) {
        this.primaryKey = primaryKey;
        this.productPrimaryKey = productPrimaryKey;
        this.inventoryPrimaryKey = inventoryPrimaryKey;
        this.storageTime = storageTime;
    }

    public PLinkI() {
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

    public Integer getInventoryPrimaryKey() {
        return inventoryPrimaryKey;
    }

    public void setInventoryPrimaryKey(Integer inventoryPrimaryKey) {
        this.inventoryPrimaryKey = inventoryPrimaryKey;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }
}
