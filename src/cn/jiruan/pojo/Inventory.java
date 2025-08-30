package cn.jiruan.pojo;

public class Inventory {

    private Integer inventoryPrimaryKey;    //主键

    //库存所在的仓库的主键
    private Integer wareHousePrimaryKey;    //仓库主键

    //库存总容量
    private Integer inventoryAllCapacity;

    //库存中已用容量
    private Integer  inventoryUseCapacity;

    //库存预警容量
    private Integer  inventoryWarnCapacity;

    private String inventoryType;

    public Inventory(Integer inventoryPrimaryKey, Integer wareHousePrimaryKey, Integer inventoryAllCapacity, Integer inventoryUseCapacity, Integer inventoryWarnCapacity, String inventoryType) {
        this.inventoryPrimaryKey = inventoryPrimaryKey;
        this.wareHousePrimaryKey = wareHousePrimaryKey;
        this.inventoryAllCapacity = inventoryAllCapacity;
        this.inventoryUseCapacity = inventoryUseCapacity;
        this.inventoryWarnCapacity = inventoryWarnCapacity;
        this.inventoryType = inventoryType;
    }

    public Inventory() {
    }

    public Integer getInventoryPrimaryKey() {
        return inventoryPrimaryKey;
    }

/**
 * 设置库存主键的方法
 * @param inventoryPrimaryKey 库存主键的值
 */
    public void setInventoryPrimaryKey(Integer inventoryPrimaryKey) {
        // 将传入的inventoryPrimaryKey参数值赋值给当前对象的inventoryPrimaryKey属性
        this.inventoryPrimaryKey = inventoryPrimaryKey;
    }

    public Integer getWareHousePrimaryKey() {
        return wareHousePrimaryKey;
    }

    public void setWareHousePrimaryKey(Integer wareHousePrimaryKey) {
        this.wareHousePrimaryKey = wareHousePrimaryKey;
    }

/**
 * 获取库存总容量的方法
 * @return 返回库存总容量 inventoryAllCapacity 的值
 */
    public Integer getInventoryAllCapacity() {
        return inventoryAllCapacity;
    }

    public void setInventoryAllCapacity(Integer inventoryAllCapacity) {
        this.inventoryAllCapacity = inventoryAllCapacity;
    }

    public Integer getInventoryUseCapacity() {
        return inventoryUseCapacity;
    }

    public void setInventoryUseCapacity(Integer inventoryUseCapacity) {
        this.inventoryUseCapacity = inventoryUseCapacity;
    }

    public Integer getInventoryWarnCapacity() {
        return inventoryWarnCapacity;
    }

    public void setInventoryWarnCapacity(Integer inventoryWarnCapacity) {
        this.inventoryWarnCapacity = inventoryWarnCapacity;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }
}
