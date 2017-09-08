package zalho.com.br.mypan.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.databinding.AdapterCartListRowBinding;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.view.viewholder.CartListViewHolder;

/**
 * Created by andrepereira on 22/07/17.
 */

public class CartListAdapter extends RecyclerView.Adapter<CartListViewHolder> {

	private final List<OrderSku> cart;

	public CartListAdapter(List<OrderSku> cart){
		this.cart = cart;
	}

	@Override
	public CartListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		AdapterCartListRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.adapter_cart_list_row, viewGroup, false);
		return new CartListViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(CartListViewHolder cartListViewHolder, int i) {
		cartListViewHolder.bindData(cart.get(i));
	}

	@Override
	public int getItemCount() {
		return cart.size();
	}
}
