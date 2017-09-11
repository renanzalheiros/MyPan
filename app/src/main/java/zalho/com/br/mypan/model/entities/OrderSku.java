package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by andrepereira on 26/06/17.
 */

public class OrderSku implements Serializable{

	private String orderSkuId;
	private String productId;
	private int quantity;
	private BigDecimal skuPrice;

	public OrderSku() {
		this.orderSkuId = UUID.randomUUID().toString();
	}

	public OrderSku(Product product, int quantity) {
		this.quantity = quantity;
		this.productId = product.getId();
		this.skuPrice = product.getPrice();
	}

	public String getOrderSkuId() {
		return orderSkuId;
	}

	public void setOrderSkuId(String orderSkuId) {
		this.orderSkuId = orderSkuId;
	}

	public String getProductId() {
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
