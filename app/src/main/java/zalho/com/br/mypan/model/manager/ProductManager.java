package zalho.com.br.mypan.model.manager;

import android.util.Log;

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
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.service.ProductService;

/**
 * Created by andrepereira on 05/06/17.
 */

public class ProductManager {

    private ProductService service;

    public ProductManager(){
	    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
	    builder.addInterceptor(new Interceptor() {
		    @Override
		    public Response intercept(Chain chain) throws IOException {
			    Request request = chain.request().newBuilder().addHeader("user-auth", "zalho").build();
			    return chain.proceed(request);
		    }
	    });

	    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8090/mypan/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			    .client(builder.build())
                .build();

        service = retrofit.create(ProductService.class);
    }

    public Observable<List<Product>> getProductList(){
        return service.getProductsList()
		        .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<Product>>() {
                    @Override
                    public void accept(List<Product> productList) throws Exception {
                        Log.v("PC", productList.toString());
                    }
                });
    }

//    public List<Product> getFakeProducts(){
//        return new ProductServiceImpl().getProducts();
//    }
}
