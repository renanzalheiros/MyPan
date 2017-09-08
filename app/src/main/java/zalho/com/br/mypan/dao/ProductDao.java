package zalho.com.br.mypan.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.snappydb.SnappydbException;

import java.util.Arrays;
import java.util.List;

import zalho.com.br.mypan.model.entities.Product;

/**
 * Created by andrepereira on 26/06/17.
 */

public class ProductDao {

	private SharedPreferences sharedPreferences;
    public ProductDao(Context context) {
	    sharedPreferences = context.getSharedPreferences("products", Context.MODE_PRIVATE);
    }

    public List<Product> getAllProducts() throws SnappydbException {
	    String products = sharedPreferences.getString("products", "");
	    Product[] product = new Gson().fromJson(products, Product[].class);
	    if(product != null) {
		    return Arrays.asList(product);
	    }
	    return null;
    }

    public boolean saveProducts(List<Product> products) throws SnappydbException {
	    SharedPreferences.Editor edit = sharedPreferences.edit();
	    edit.putString("products", new Gson().toJson(products.toArray(new Product[products.size()])));
	    edit.apply();
	    return true;
    }

    public Product getProductById(Long id) {
	    try {
		    List<Product> allProducts = getAllProducts();
		    for(Product product : allProducts) {
		    	if(product.getId() == id) {
		    		return product;
			    }
		    }
		    return null;
	    } catch (SnappydbException e) {
		    e.printStackTrace();
		    return null;
	    }
    }

    public List<Product> clearProducts() throws SnappydbException {
	    return null;
    }


}
