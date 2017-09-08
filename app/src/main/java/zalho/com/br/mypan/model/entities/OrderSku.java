package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by andrepereira on 26/06/17.
 */

public class OrderSku implements Serializable{

	private long orderSkuId;
	private Long productId;
	private int quantity;
	private BigDecimal skuPrice;

	public OrderSku() {
	}

	public OrderSku(Product product, int quantity) {
		this.quantity = quantity;
		this.productId = product.getId();
		this.skuPrice = product.getPrice();
	}

	public long getOrderSkuId() {
		return orderSkuId;
	}

	public void setOrderSkuId(long orderSkuId) {
		this.orderSkuId = orderSkuId;
	}

	public Long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getSkuPrice() {
		return skuPrice;
	}

	public void setSkuPrice(BigDecimal skuPrice) {
		this.skuPrice = skuPrice;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getOrderSkuPrice(){
		return skuPrice.multiply(BigDecimal.valueOf(quantity));
	}
}
