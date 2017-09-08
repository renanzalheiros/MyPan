package zalho.com.br.mypan.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.view.activities.MainActivity;

/**
 * Created by andrepereira on 01/09/17.
 */

public class CartDao {

	private final Context context;
	private final SharedPreferences sharedPreferences;
	public CartDao(Context context) {
		sharedPreferences = context.getSharedPreferences("cart", Context.MODE_PRIVATE);
		this.context = context;
	}

	public List<OrderSku> getCart() throws SnappydbException {
		String cart = sharedPreferences.getString("mycart", "");
		OrderSku[] orderSkus = new Gson().fromJson(cart, OrderSku[].class);
		if(orderSkus != null) {
			return Arrays.asList(orderSkus);
		}
		return new ArrayList<>();
	}

	public boolean persistCart(List<OrderSku> cart) throws SnappydbException {
		SharedPreferences.Editor edit = sharedPreferences.edit();
		String s = new Gson().toJson(cart.toArray(new OrderSku[cart.size()]));
		edit.putString("mycart", s);
		edit.apply();
		return true;
	}

	public boolean clearCart() throws SnappydbException {
		return false;
	}
}
