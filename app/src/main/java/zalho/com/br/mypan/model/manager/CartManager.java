package zalho.com.br.mypan.model.manager;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import zalho.com.br.mypan.model.entities.Product;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartManager {

    private SharedPreferences sharedPreferences;


    public CartManager(SharedPreferences cart){
        this.sharedPreferences = cart;
    }

    public void persistCart(Product order) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Gson gson = new Gson();
        String orderJson = gson.toJson(order);
        edit.putString("cart", orderJson);
        edit.apply();
    }

    public Product getCart(){
        String cart = sharedPreferences.getString("cart", null);
        Gson gson = new Gson();
        return gson.fromJson(cart, Product.class);
    }

}
