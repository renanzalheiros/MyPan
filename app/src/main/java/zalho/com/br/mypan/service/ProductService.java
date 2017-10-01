package zalho.com.br.mypan.service;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import zalho.com.br.mypan.model.entities.Product;

/**
 * Created by andrepereira on 05/06/17.
 */

public interface ProductService {

    @GET("product/all.json")
    Observable<List<Product>> getProductsList();
}
