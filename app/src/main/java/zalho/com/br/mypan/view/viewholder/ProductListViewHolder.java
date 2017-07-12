package zalho.com.br.mypan.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import zalho.com.br.mypan.databinding.AdapterProductListRowBinding;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.model.viewmodel.ProductsListHolderViewModel;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductListViewHolder extends RecyclerView.ViewHolder{

    AdapterProductListRowBinding binding;

    public ProductListViewHolder(AdapterProductListRowBinding itemView) {
        super(itemView.getRoot());

        binding = itemView;
    }

    public void bindData(Product product){
        if (binding.getViewModel() == null) {
            binding.setViewModel(new ProductsListHolderViewModel(product));
        } else {
            binding.getViewModel().setProduct(product);
        }
    }
}
