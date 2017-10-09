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
	private BigDecimal price;

	public OrderSku() {
		this.price = new BigDecimal("0.0");
	}

	public OrderSku(Product product, int quantity) {
		this.quantity = quantity;
		this.product = product;
		this.price = new BigDecimal("0.0");
		refreshOrderSkuPrice();
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		refreshOrderSkuPrice();
	}

	public BigDecimal getOrderSkuPrice(){
		return this.price;
	}

	private void refreshOrderSkuPrice() {
		this.price = new BigDecimal(String.valueOf(product.getPrice().multiply(BigDecimal.valueOf(quantity))));
	}
}
