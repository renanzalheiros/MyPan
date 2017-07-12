package zalho.com.br.mypan.model.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.model.manager.ProductManager;
import zalho.com.br.mypan.view.adapter.ProductsListAdapter;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductsListFragmentViewModel extends BaseObservable {

    public ObservableBoolean loadingListProgress = new ObservableBoolean(true);
    public ObservableBoolean emptyList = new ObservableBoolean(false);
    public ObservableArrayList<Product> products = new ObservableArrayList<>();

    private ProductManager manager;

    public ProductsListFragmentViewModel(){
        manager = new ProductManager();
    }

    public void onResume(){
        loadProductsList();
    }

    private void loadProductsList(){
        products.clear();

        manager.getProductList()
		        .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<List<Product>>() {
                    @Override
                    public void accept(List<Product> productList) throws Exception {
                        loadingListProgress.set(false);
                        products.addAll(productList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        loadingListProgress.set(false);
                        emptyList.set(true);
                        throwable.printStackTrace();
                    }
                });
    }

    @BindingAdapter("itemsProductsList")
    public static void bindList(final RecyclerView view, ObservableArrayList<Product> list){
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(new ProductsListAdapter(list));
    }
}
