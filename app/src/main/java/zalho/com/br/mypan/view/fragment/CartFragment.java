package zalho.com.br.mypan.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.databinding.FragmentCartBinding;
import zalho.com.br.mypan.model.manager.CartManager;
import zalho.com.br.mypan.model.viewmodel.CartFragmentViewModel;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartFragment extends Fragment {

    private CartFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentCartBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        viewModel = new CartFragmentViewModel(new CartManager(getContext()));

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        viewModel.onResume();
        super.onResume();
    }
}
