package zalho.com.br.mypan.service;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import zalho.com.br.mypan.model.entities.BuyOrder;

/**
 * Created by andrepereira on 21/08/17.
 */

public interface CartService {

	@POST("order/neworder")
	Observable<BuyOrder> makeNewOrder(@Body BuyOrder buyOrder);
}
