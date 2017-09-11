package zalho.com.br.mypan.model.manager;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zalho.com.br.mypan.dao.CartDao;
import zalho.com.br.mypan.dao.UserDao;
import zalho.com.br.mypan.model.entities.BuyOrder;
import zalho.com.br.mypan.model.entities.Login;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.service.CartService;
import zalho.com.br.mypan.util.Constantes;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartManager {

	private CartService service;
	private UserDao userDao;
	private CartDao cartDao;

	private List<OrderSku> order;

	public CartManager(Context context){
		this.userDao = new UserDao(context);
		this.cartDao = new CartDao(context);
		order = new ArrayList<>();
		order = getMyCart();

		Login user = new Gson().fromJson(context.getSharedPreferences("login", Context.MODE_PRIVATE).getString("user", ""), Login.class);

		if(user != null && user.getToken() == null){
			final String token = "";
		}
		final String token = user.getToken();


		OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
		builder.connectTimeout(120, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS);
		builder.addInterceptor(chain -> {
			Request request = chain.request().newBuilder().addHeader("user-auth", token).build();
			return chain.proceed(request);
		});

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(Constantes.LOCALHOST_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(builder.build())
				.build();

		service = retrofit.create(CartService.class);
	}

	public void persistCart(OrderSku orderSku) {
		OrderSku sku = searchForProduct(orderSku.getProductId());
		if (sku != null) {
			sku.setQuantity(sku.getQuantity() + orderSku.getQuantity());
			cartDao.persistCart(order);
		} else {
			order.add(orderSku);
			cartDao.persistCart(order);
		}
	}

	private OrderSku searchForProduct(String productId){
		for(OrderSku sku : order) {
			if (sku.getProductId().equals(productId)) {
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
			buyOrder.setUserId(user.getId());
			buyOrder.setOrderProductList(order);
			return service.makeNewOrder(buyOrder)
					.subscribeOn(Schedulers.io())
					.observeOn(AndroidSchedulers.mainThread())
					.doOnNext(orderService -> Log.v("RESPOSTA NEW ORDER", "passei aqui"))
					.doOnError(throwable -> throwable.printStackTrace());
		} else {
	    	throw new RuntimeException("Não foi possível enviar seu pedido");
		}
	}

	public void saveBuyOrder(BuyOrder buyOrder) {
		cartDao.persistBuyOrder(buyOrder);
	}

	public boolean clearCart() {
		order.clear();
		boolean b = cartDao.persistCart(order);
		return b;
	}
}
