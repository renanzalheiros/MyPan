package zalho.com.br.mypan.model.manager;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.mypan.model.entities.Product;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartManager {

	private List<Product> carrinho = new ArrayList<>();
	private Context context;

	public CartManager(Context context){
		this.context = context;
		carrinho = getCart();
		if(carrinho.size() == 10){
			try {
				DB cart = DBFactory.open(context, "Cart");
				cart.del("carrinho");
			} catch (SnappydbException e) {
				e.printStackTrace();
			}
		}
    }

    public void persistCart(Product order) {
    	carrinho.add(order);
	    try {
	    	DB dbNoSql = DBFactory.open(context, "Cart");
	        Product[] products = carrinho.toArray(new Product[carrinho.size()]);
		    dbNoSql.put("carrinho", products);
		    dbNoSql.close();
	    } catch (SnappydbException e) {
		    e.printStackTrace();
	    }
	}

    public List<Product> getCart(){
    	carrinho.clear();
	    try {
		    DB dbNoSql = DBFactory.open(context, "Cart");
		    Product[] carrinhos = dbNoSql.getArray("carrinho", Product.class);
		    for(Product product : carrinhos){
		    	carrinho.add(product);
		    }
		    dbNoSql.close();
	    } catch (SnappydbException e) {
		    e.printStackTrace();
	    }
	    return carrinho;
    }

}
