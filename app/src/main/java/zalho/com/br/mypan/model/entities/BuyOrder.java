package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrepereira on 26/06/17.
 */

public class BuyOrder implements Serializable {

    private int id;
    private List<OrderSku> orderSkuList;
    private Integer userId;

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

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
