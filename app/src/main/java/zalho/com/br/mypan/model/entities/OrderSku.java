package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by andrepereira on 26/06/17.
 */

public class OrderSku implements Serializable {

	private String orderSkuId;
	private Product product;
	private int quantity;
	private BigDecimal orderSkuPrice;

	public OrderSku() {
		this.orderSkuId = UUID.randomUUID().toString();
	}

	public OrderSku(Product product, int quantity) {
		this.quantity = quantity;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getOrderSkuPrice(){
		this.orderSkuPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
		return orderSkuPrice;
	}
}
