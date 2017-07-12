package zalho.com.br.mypan.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import zalho.com.br.mypan.R;
import zalho.com.br.mypan.model.entities.Product;

/**
 * Created by andrepereira on 05/06/17.
 */

public class ProductServiceImpl implements ProductService {

    private List<Product> lista = new ArrayList<>();

//    @Override
//    public List<Product> getProducts() {
//        lista.add(new Product(1, "Pão integral", "Pão integral com grãos", BigDecimal.valueOf(Double.parseDouble("10.75")),""));
//        lista.add(new Product(2, "Pão fatiado", "Pão de forma fatiado", BigDecimal.valueOf(Double.parseDouble("7.75")),""));
//        lista.add(new Product(3, "Pão francês", "Pão francês feito Renan Zalheiros com todo o sabor e qualidade que um produto Renan Zalheiros pode oferecer", BigDecimal.valueOf(Double.parseDouble("1.99")), ""));
//        return lista;
//    }

    @Override
    public Observable<List<Product>> getProductsList() {

        return null;
    }
}
