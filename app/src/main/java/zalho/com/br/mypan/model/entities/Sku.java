package zalho.com.br.mypan.model.entities;

import java.math.BigDecimal;

/**
 * Created by andrepereira on 26/06/17.
 */

public class Sku {

    private Integer skuId;
    private Integer productId;
    private String skuName;
    private String skuDescription;
    private BigDecimal skuPrice;
    private String skuImagePath;

    public Sku() {
    }

    public Sku(Integer skuId, Integer productId, String skuName, String skuDescription, BigDecimal skuPrice, String skuImagePath) {
        this.skuId = skuId;
        this.productId = productId;
        this.skuName = skuName;
        this.skuDescription = skuDescription;
        this.skuPrice = skuPrice;
        this.skuImagePath = skuImagePath;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuDescription() {
        return skuDescription;
    }

    public void setSkuDescription(String skuDescription) {
        this.skuDescription = skuDescription;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getSkuImagePath() {
        return skuImagePath;
    }

    public void setSkuImagePath(String skuImagePath) {
        this.skuImagePath = skuImagePath;
    }
}
