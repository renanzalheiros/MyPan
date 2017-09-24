package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by andrepereira on 26/06/17.
 */

public class OrderSku implements Serializable {

	private Product product;
	private int quantity;

	public OrderSku() {
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
		return product.getPrice().multiply(BigDecimal.valueOf(quantity));
	}
}
