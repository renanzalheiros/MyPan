package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by andrepereira on 26/06/17.
 */

public class BuyOrder implements Serializable {

    private String id;
    private List<OrderSku> orderSkuList;
    private String userId;

    public BuyOrder() {
        this.orderSkuList = new ArrayList<OrderSku>();
    }

    public void addToCart(OrderSku orderSku){
        this.orderSkuList.add(orderSku);
    }

    public List<OrderSku> getOrderProductList(){
        return this.orderSkuList;
    }

	public void setOrderProductList(List<OrderSku> orderProductList) {
		this.orderSkuList = orderProductList;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
