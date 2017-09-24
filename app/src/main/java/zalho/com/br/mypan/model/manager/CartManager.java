package zalho.com.br.mypan.model.manager;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zalho.com.br.mypan.dao.CartDao;
import zalho.com.br.mypan.dao.UserDao;
import zalho.com.br.mypan.events.OrderSkuEvent;
import zalho.com.br.mypan.events.RefreshDisplayEvent;
import zalho.com.br.mypan.model.entities.BuyOrder;
import zalho.com.br.mypan.model.entities.Login;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.service.CartService;
import zalho.com.br.mypan.service.ServiceGenerate;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartManager {

	private CartService service;
	private UserDao userDao;
	private CartDao cartDao;

	private List<OrderSku> order;

	public CartManager(Context context){
		EventBus.getDefault().register(this);

		this.userDao = new UserDao(context);
		this.cartDao = new CartDao(context);
		Login user = userDao.getUser();
		order = new ArrayList<>();
		order = getMyCart();

		service = ServiceGenerate.createService(CartService.class, user);
	}

	@Subscribe
	public void persistCart(OrderSkuEvent event) {
		OrderSku sku = searchForProduct(event.getOrderSku().getProduct());
		if (sku != null) {
			sku.setQuantity(sku.getQuantity() + event.getOrderSku().getQuantity());
			cartDao.persistCart(order);
		} else {
			order.add(event.getOrderSku());
			cartDao.persistCart(order);
		}
		EventBus.getDefault().post(new RefreshDisplayEvent());
	}

	private OrderSku searchForProduct(Product product){
		for(OrderSku sku : order) {
			if (sku.getProduct().getId().equals(product.getId())) {
				return sku;
			}
		}
		return null;
	}

	public void removeProduct(OrderSku orderSku){
		order.remove(orderSku);
	}

	public List<OrderSku> getMyCart() {
		return cartDao.getCart();
	}

	public Observable<BuyOrder> sendOrder(){
		Login user = userDao.getUser();

		if(user != null){
			BuyOrder buyOrder = new BuyOrder();
			buyOrder.setUserEmail(user.getEmail());
			buyOrder.setOrderProductList(order);
			buyOrder.setBuyOrderPrice(getBuyOrderPrice(order));
			return service.makeNewOrder(buyOrder)
					.subscribeOn(Schedulers.io())
					.observeOn(AndroidSchedulers.mainThread())
					.doOnNext(orderService -> Log.v("RESPOSTA NEW ORDER", "passei aqui"))
					.doOnError(throwable -> throwable.printStackTrace());
		} else {
	    	throw new RuntimeException("Não foi possível enviar seu pedido");
		}
	}

	public BigDecimal getBuyOrderPrice(List<OrderSku> order) {
		BigDecimal cartTotal = new BigDecimal(0.0);
		for (OrderSku sku : order) {
			cartTotal = cartTotal.add(sku.getOrderSkuPrice());
		}
		return cartTotal;
	}

	public boolean clearCart() {
		order.clear();
		boolean b = cartDao.persistCart(order);
		return b;
	}
}
