package zalho.com.br.mypan.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import zalho.com.br.mypan.MypanApplication;
import zalho.com.br.mypan.databinding.AdapterProductListRowBinding;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.model.viewmodel.ProductsListHolderViewModel;
import zalho.com.br.mypan.view.activities.MainActivity;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductListViewHolder extends RecyclerView.ViewHolder{

    private final Context context;
    AdapterProductListRowBinding binding;

    public ProductListViewHolder(AdapterProductListRowBinding itemView) {
        super(itemView.getRoot());
        context = itemView.getRoot().getContext();
        binding = itemView;
    }

    public void bindData(Product product){
        if (binding.getViewModel() == null) {
            ProductsListHolderViewModel productsListHolderViewModel = new ProductsListHolderViewModel(product, context);

            binding.setViewModel(productsListHolderViewModel);
        } else {
            binding.getViewModel().setProduct(product);
        }
    }
}
