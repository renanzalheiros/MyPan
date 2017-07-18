package zalho.com.br.mypan.model.manager;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import zalho.com.br.mypan.model.entities.Product;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartManager {

    private SharedPreferences sharedPreferences;
	private List<Product> carrinho = new ArrayList<>();

    public CartManager(SharedPreferences cart){
        this.sharedPreferences = cart;
        carrinho = getCart();
    }

    public void persistCart(Product order) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
    	carrinho.add(order);
        Gson gson = new Gson();
        String orderJson = gson.toJson(carrinho);
        edit.putString("cart", orderJson);
        edit.apply();
    }

    public List<Product> getCart(){
        String cart = sharedPreferences.getString("cart", "");
        Gson gson = new Gson();
        if(cart.equals("")){
        	return new ArrayList<>();
        } else {
	        List<Product> products = Arrays.asList(gson.fromJson(cart, Product[].class));
	        return products;
        }

    }

}
