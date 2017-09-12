package zalho.com.br.mypan.dao;

import android.content.Context;

import com.google.gson.Gson;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappyDB;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import zalho.com.br.mypan.model.entities.OrderSku;

/**
 * Created by andrepereira on 01/09/17.
 */

public class CartDao {

	private final Context context;

	public CartDao(Context context) {
		this.context = context;
	}

	public List<OrderSku> getCart() {
		try {
			DB snappyDB = DBFactory.open(context, "Cart");
			String mycart = snappyDB.get("mycart");
			OrderSku[] orderSkus = new Gson().fromJson(mycart, OrderSku[].class);
			if(orderSkus != null) {
				return new ArrayList<>(Arrays.asList(orderSkus));
			}
			snappyDB.close();
			return new ArrayList<>();
		} catch (SnappydbException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public boolean persistCart(List<OrderSku> cart) {
		String s = new Gson().toJson(cart.toArray(new OrderSku[cart.size()]));
		try {
			DB snappyDB = DBFactory.open(context, "Cart");
			snappyDB.put("mycart", s);
			snappyDB.close();
			return true;
		} catch (SnappydbException e) {
			e.printStackTrace();
			return false;
		}
	}
}
