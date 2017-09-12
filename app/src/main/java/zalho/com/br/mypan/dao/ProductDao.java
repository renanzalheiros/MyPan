package zalho.com.br.mypan.dao;

import android.content.Context;

import com.google.gson.Gson;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import zalho.com.br.mypan.model.entities.Product;

/**
 * Created by andrepereira on 26/06/17.
 */

public class ProductDao {

	private final Context context;
    public ProductDao(Context context) {
	    this.context = context;
    }

    public List<Product> getAllProducts() {
	    try {
		    DB snappyDB = DBFactory.open(context, "Products");
		    String products = snappyDB.get("products");
		    snappyDB.close();

		    Product[] product = new Gson().fromJson(products, Product[].class);
		    if(product != null) {
			    return Arrays.asList(product);
		    }
		    return null;
	    } catch (SnappydbException e) {
		    e.printStackTrace();
		    return null;
	    }
    }

    public boolean saveProducts(List<Product> products) {
	    try {
		    DB snappyDB = DBFactory.open(context, "Products");
		    snappyDB.put("products", new Gson().toJson(products.toArray(new Product[products.size()])));
		    snappyDB.close();
		    return true;
	    } catch (SnappydbException e) {
		    e.printStackTrace();
		    return false;
	    }
    }

    public Product getProductById(String id) {
	    List<Product> allProducts;
	    try {
		    DB snappyDB = DBFactory.open(context, "Products");
		    String produto = snappyDB.get("products");
		    snappyDB.close();
		    Product[] products = new Gson().fromJson(produto, Product[].class);
		    allProducts = new ArrayList<>(Arrays.asList(products));
		    for(Product product : allProducts) {
		        if(product.getId().equals(id)) {
		            return product;
			    }
		    }
		    return null;
	    } catch (SnappydbException e) {
		    e.printStackTrace();
		    return null;
	    }
    }

    public List<Product> clearProducts() {
	    try {
		    DB snappyDB = DBFactory.open(context, "Products");
		    snappyDB.del("products");
	        snappyDB.close();
	        return getAllProducts();
	    } catch (SnappydbException e) {
		    e.printStackTrace();
		    return null;
	    }
    }


}
