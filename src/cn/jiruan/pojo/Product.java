package cn.jiruan.pojo;

public class Product {
    //产品主键
    private Integer productPrimaryKey;
    //产品ID
    private Integer productId;
    //产品名称
    private String productName;
    //产品种类
    private String productType;
    //生产日期
    private String productDate;
    //保质期
    private String qualityDate;

    public Product(Integer productPrimaryKey, Integer productId, String productName, String productType, String productDate, String qualityDate) {
        this.productPrimaryKey = productPrimaryKey;
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productDate = productDate;
        this.qualityDate = qualityDate;
    }

    public Product() {
    }

    public Integer getProductPrimaryKey() {
        return productPrimaryKey;
    }

    public void setProductPrimaryKey(Integer productPrimaryKey) {
        this.productPrimaryKey = productPrimaryKey;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(String qualityDate) {
        this.qualityDate = qualityDate;
    }
}
