package zalho.com.br.mypan.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import zalho.com.br.mypan.databinding.AdapterCartListRowBinding;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.model.viewmodel.CartListHolderViewModel;

/**
 * Created by andrepereira on 22/07/17.
 */

public class CartListViewHolder extends RecyclerView.ViewHolder {

	private final AdapterCartListRowBinding binding;
	private final Context context;

	public CartListViewHolder(AdapterCartListRowBinding binding) {
		super(binding.getRoot());

		this.context = binding.getRoot().getContext();

		this.binding = binding;
	}

	public void bindData(OrderSku orderSku){
		if (binding.getViewModel() == null) {
			CartListHolderViewModel viewModel = new CartListHolderViewModel(orderSku, context);
			binding.setViewModel(viewModel);
		} else {
			binding.getViewModel().setOrderSku(orderSku);
		}
	}
}
