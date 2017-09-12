package zalho.com.br.mypan.model.manager;

import android.content.Context;
import android.util.Log;

import com.snappydb.SnappydbException;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import zalho.com.br.mypan.dao.ProductDao;
import zalho.com.br.mypan.dao.UserDao;
import zalho.com.br.mypan.model.entities.Login;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.service.ProductService;
import zalho.com.br.mypan.service.ServiceGenerate;

/**
 * Created by andrepereira on 05/06/17.
 */

public class ProductManager {

    private ProductService service;
    private final ProductDao productDao;
    private final UserDao userDao;

    public ProductManager(Context context) {
    	userDao = new UserDao(context);
    	productDao = new ProductDao(context);

	    Login user = userDao.getUser();

        service = ServiceGenerate.createService(ProductService.class, user);
    }

    public Observable<List<Product>> getProductList(){
        return service.getProductsList()
	        .observeOn(AndroidSchedulers.mainThread())
            .doOnNext(productList -> {
                for(Product product : productList){
	                Log.v("ZALHO", product.toString());
                }
            });
    }

	public boolean updateProductList(List<Product> products) throws SnappydbException {
		return productDao.saveProducts(products);
	}

	public Product getProductById(String productId){
		return productDao.getProductById(productId);
	}
}
