package zalho.com.br.mypan.model.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.model.manager.CartManager;
import zalho.com.br.mypan.view.adapter.ProductsListAdapter;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartFragmentViewModel extends BaseObservable{

    public ObservableBoolean emptyList = new ObservableBoolean(false);
    public ObservableArrayList<Product> carrinho = new ObservableArrayList<>();

    private CartManager manager;

    public CartFragmentViewModel(CartManager manager){
        this.manager = manager;
    }

    public void onResume(){
	    carrinho.clear();
	    carrinho.addAll(manager.getCart());
    }

    @BindingAdapter("itemsCarrinho")
    public static void bindList(final RecyclerView view, ObservableArrayList<Product> list){
    	if(list == null){
    		list = new ObservableArrayList<>();
	    }
	    LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
	    view.setLayoutManager(layoutManager);
	    view.setAdapter(new ProductsListAdapter(list));
    }

}
