package zalho.com.br.mypan.events;

import zalho.com.br.mypan.model.entities.OrderSku;

/**
 * Created by andrepereira on 11/09/17.
 */

public class OrderSkuEvent {

	private final OrderSku orderSku;

	public OrderSkuEvent(OrderSku orderSku) {
		this.orderSku = orderSku;
	}

	public OrderSku getOrderSku() {
		return orderSku;
	}
}
