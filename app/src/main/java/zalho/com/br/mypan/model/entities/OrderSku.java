package zalho.com.br.mypan.model.entities;

import java.math.BigDecimal;

/**
 * Created by andrepereira on 26/06/17.
 */

public class OrderSku {

    private final Sku orderSku;
    private final int skuQuantity;
    private BigDecimal orderPrice;

    public OrderSku(Sku orderSku, int skuQuantity) {
        this.orderSku = orderSku;
        this.skuQuantity = skuQuantity;
        orderPrice = orderSku.getSkuPrice().multiply(BigDecimal.valueOf(skuQuantity));
    }

    public Sku getOrderSku() {
        return orderSku;
    }

    public int getSkuQuantity() {
        return skuQuantity;
    }
}
