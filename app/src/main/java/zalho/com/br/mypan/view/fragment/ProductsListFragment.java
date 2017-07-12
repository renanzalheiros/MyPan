package zalho.com.br.mypan.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.databinding.FragmentProductsListBinding;
import zalho.com.br.mypan.model.viewmodel.ProductsListFragmentViewModel;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductsListFragment extends Fragment {

    private ProductsListFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ProductsListFragmentViewModel();

        FragmentProductsListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products_list, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        viewModel.onResume();
        super.onResume();
    }
}
