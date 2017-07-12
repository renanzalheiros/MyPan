package zalho.com.br.mypan.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.databinding.AdapterProductListRowBinding;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.view.viewholder.ProductListViewHolder;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductsListAdapter extends RecyclerView.Adapter<ProductListViewHolder> {

    private List<Product> productList = new ArrayList<>();

    public ProductsListAdapter(List<Product> productList){
        this.productList = productList;
    }

    @Override
    public ProductListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterProductListRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.adapter_product_list_row, viewGroup, false);
        return new ProductListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductListViewHolder productListViewHolder, int i) {
        productListViewHolder.bindData(productList.get(i));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
