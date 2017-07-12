package zalho.com.br.mypan.model.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.model.manager.CartManager;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductsListHolderViewModel extends BaseObservable {

    private Product product;

    public ObservableField<String> productName = new ObservableField<>();
    public ObservableField<String> productDescription = new ObservableField<>();
    public ObservableField<String> productPrice = new ObservableField<>();
    public ObservableField<String> productImagePath = new ObservableField<>();

    public ProductsListHolderViewModel(Product product) {
        this.product = product;
        this.productName.set(product.getProductName());
        this.productDescription.set(product.getProductDescription());
        this.productPrice.set("R$ " + product.getProductPrice().toString());
        this.productImagePath.set(product.getProductImagePath());
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct(){
        return this.product;
    }

    public void addToCart(View view){
        Snackbar.make(view, "Adicionado no carrinho com sucess", Snackbar.LENGTH_SHORT).show();
        CartManager manager = new CartManager(view.getContext().getSharedPreferences("cart", Context.MODE_PRIVATE));
        manager.persistCart(product);
    }

    public void onDetails(View view){
        //TODO implementar logica do onDetails
    }

    @BindingAdapter("productImage")
    public static void bindProductImage(final ImageView imageView, String imagePath){
        Picasso.with(imageView.getContext()).load("http://192.168.0.16:9090/mypan/img/products/" + imagePath).into(imageView);
    }
}
