package cn.jiruan.pojo;

public class WareHouse {
    private Integer wareHousePrimaryKey;
    private Integer wareHouseId;
    private String wareHouseName;
    private Integer wareHouseCapacity;
    private String wareHouseAddress;

    public WareHouse(Integer wareHousePrimaryKey, Integer wareHouseId, String wareHouseName, Integer wareHouseCapacity, String wareHouseAddress) {
        this.wareHousePrimaryKey = wareHousePrimaryKey;
        this.wareHouseId = wareHouseId;
        this.wareHouseName = wareHouseName;
        this.wareHouseCapacity = wareHouseCapacity;
        this.wareHouseAddress = wareHouseAddress;
    }

    public WareHouse( Integer wareHouseId, String wareHouseName, Integer wareHouseCapacity, String wareHouseAddress) {
        this.wareHouseId = wareHouseId;
        this.wareHouseName = wareHouseName;
        this.wareHouseCapacity = wareHouseCapacity;
        this.wareHouseAddress = wareHouseAddress;
    }

    public WareHouse() {
    }

    public Integer getWareHousePrimaryKey() {
        return wareHousePrimaryKey;
    }

    public void setWareHousePrimaryKey(Integer wareHousePrimaryKey) {
        this.wareHousePrimaryKey = wareHousePrimaryKey;
    }

    public Integer getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(Integer wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public Integer getWareHouseCapacity() {
        return wareHouseCapacity;
    }

    public void setWareHouseCapacity(Integer wareHouseCapacity) {
        this.wareHouseCapacity = wareHouseCapacity;
    }

    public String getWareHouseAddress() {
        return wareHouseAddress;
    }

    public void setWareHouseAddress(String wareHouseAddress) {
        this.wareHouseAddress = wareHouseAddress;
    }
}
