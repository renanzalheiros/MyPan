package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrepereira on 26/06/17.
 */

public class BuyOrder implements Serializable {

    private String id;
    private List<OrderSku> orderSkuList;
    private Login user;

    public BuyOrder() {
        this.orderSkuList = new ArrayList<OrderSku>();
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

    public void setUser(Login user) {
        this.user = user;
    }
}
