package zalho.com.br.mypan.view.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.login.LoginManager;

import zalho.com.br.mypan.MypanApplication;
import zalho.com.br.mypan.R;
import zalho.com.br.mypan.databinding.FragmentProductsListBinding;
import zalho.com.br.mypan.model.viewmodel.ProductsListFragmentViewModel;
import zalho.com.br.mypan.view.activities.LoginActivity;
import zalho.com.br.mypan.view.activities.MainActivity;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductsListFragment extends Fragment {

    private ProductsListFragmentViewModel viewModel;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        viewModel = new ProductsListFragmentViewModel(getContext());
        FragmentProductsListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products_list, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.add("Deslogar");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().equals("Deslogar")){
            LoginManager.getInstance().logOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        viewModel.onResume();
        super.onResume();
    }
}
