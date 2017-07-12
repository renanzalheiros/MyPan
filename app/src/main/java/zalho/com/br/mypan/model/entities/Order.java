package zalho.com.br.mypan.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrepereira on 26/06/17.
 */

public class Order {

    private final List<OrderSku> cart;

    public Order() {
        this.cart = new ArrayList<OrderSku>();
    }

    public void addToCart(OrderSku orderSku){
        this.cart.add(orderSku);
    }

    public List<OrderSku> getCart(){
        return this.cart;
    }

}
