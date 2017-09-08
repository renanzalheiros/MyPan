package zalho.com.br.mypan.model.manager;

import android.content.Context;
import android.util.Log;

import com.snappydb.SnappydbException;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zalho.com.br.mypan.dao.ProductDao;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.service.ProductService;

/**
 * Created by andrepereira on 05/06/17.
 */

public class ProductManager {

    private ProductService service;
    private final ProductDao productDao;

    public ProductManager(Context context) {
    	productDao = new ProductDao(context);
	    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
	    builder.addInterceptor(new Interceptor() {
		    @Override
		    public Response intercept(Chain chain) throws IOException {
			    Request request = chain.request().newBuilder().addHeader("user-auth", "zalho").build();
			    return chain.proceed(request);
		    }
	    });

	    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.15:8000/mypan/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			    .client(builder.build())
                .build();

        service = retrofit.create(ProductService.class);
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

	public Product getProductById(Long productId){
		return productDao.getProductById(productId);
	}
}
