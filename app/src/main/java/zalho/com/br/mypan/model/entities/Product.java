package zalho.com.br.mypan.model.entities;

import java.math.BigDecimal;

/**
 * Created by andrepereira on 04/06/17.
 */

public class Product {

    private Integer productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private String productImagePath;


    public Product(Integer productId, String productName, String productDescription, BigDecimal productPrice, String imagePath) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImagePath = imagePath;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }
}
