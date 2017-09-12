package zalho.com.br.mypan.model.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.snappydb.SnappydbException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import zalho.com.br.mypan.events.RefreshDisplayEvent;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.model.manager.CartManager;
import zalho.com.br.mypan.view.activities.MainActivity;
import zalho.com.br.mypan.view.adapter.CartListAdapter;
import zalho.com.br.mypan.view.adapter.ProductsListAdapter;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartFragmentViewModel extends BaseObservable{

	public ObservableBoolean emptyList = new ObservableBoolean(false);
	public ObservableArrayList<OrderSku> carrinho = new ObservableArrayList<>();

	private CartManager manager;

	public CartFragmentViewModel(Context context){
		this.manager = ((MainActivity)context).getCartManager();
		EventBus.getDefault().register(this);
	}

	public CartManager getManager() {
		return manager;
	}

	public void onResume() {
		carrinho.clear();
		carrinho.addAll(manager.getMyCart());
		if(carrinho.size() <= 0){
			emptyList.set(true);
		} else {
			emptyList.set(false);
		}
	}

	@BindingAdapter("itemsCarrinho")
	public static void bindList(final RecyclerView view, ObservableArrayList<OrderSku> list){
		LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
		view.setLayoutManager(layoutManager);
		view.setAdapter(new CartListAdapter(list));
	}

	public void newOrder() {
		if (manager.clearCart()) {
			carrinho.clear();
			onResume();
		}
	}

	@Subscribe
	public void atualizaTela(RefreshDisplayEvent event) {
		onResume();
	}
}
