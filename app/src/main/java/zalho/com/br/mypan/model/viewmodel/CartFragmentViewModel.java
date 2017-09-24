package zalho.com.br.mypan.model.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import zalho.com.br.mypan.events.RefreshDisplayEvent;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.model.manager.CartManager;
import zalho.com.br.mypan.view.activities.MainActivity;
import zalho.com.br.mypan.view.adapter.CartListAdapter;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartFragmentViewModel extends BaseObservable{

	public ObservableBoolean emptyList = new ObservableBoolean(false);
	public ObservableArrayList<OrderSku> carrinho = new ObservableArrayList<>();
	public ObservableField<String> total = new ObservableField<>();

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
		total.set("TOTAL: R$" + manager.getBuyOrderPrice(carrinho));
	}

	public void clearCart(final View view) {
		manager.clearCart();
		onResume();
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
