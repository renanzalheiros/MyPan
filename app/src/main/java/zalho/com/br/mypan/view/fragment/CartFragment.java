package zalho.com.br.mypan.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.snappydb.SnappydbException;

import io.reactivex.functions.Consumer;
import zalho.com.br.mypan.MypanApplication;
import zalho.com.br.mypan.R;
import zalho.com.br.mypan.databinding.FragmentCartBinding;
import zalho.com.br.mypan.model.entities.BuyOrder;
import zalho.com.br.mypan.model.manager.CartManager;
import zalho.com.br.mypan.model.viewmodel.CartFragmentViewModel;
import zalho.com.br.mypan.view.activities.MainActivity;

/**
 * Created by andrepereira on 26/06/17.
 */

public class CartFragment extends Fragment {

    private CartFragmentViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        viewModel = new CartFragmentViewModel(getContext());

	    FragmentCartBinding inflate = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
	    inflate.setViewModel(viewModel);

        return inflate.getRoot();
    }

    public CartFragmentViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void onResume() {
	    viewModel.onResume();
	    super.onResume();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.add("Comprar");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().equals("Comprar")){
	        CartManager manager = viewModel.getManager();
	        manager.sendOrder()
            .subscribe(
		            orderService -> { Log.v("BUY ORDER", orderService.toString());
		                viewModel.newOrder();
		            } ,
		            throwable -> {
			            throwable.printStackTrace();
			            Snackbar snackbar = Snackbar.make(getView(), "Não foi possível enviar seu carrinho", Snackbar.LENGTH_LONG);
			            snackbar.show();
		            });
        }
        return super.onOptionsItemSelected(item);
    }
}
