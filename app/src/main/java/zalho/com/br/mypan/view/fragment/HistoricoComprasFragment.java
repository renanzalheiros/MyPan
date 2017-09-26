package zalho.com.br.mypan.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.databinding.FragmentHistoricoComprasBinding;
import zalho.com.br.mypan.model.viewmodel.HistoricoComprasFragmentViewModel;

/**
 * Created by andrepereira on 23/09/17.
 */

public final class HistoricoComprasFragment extends Fragment {

	private HistoricoComprasFragmentViewModel viewModel;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		viewModel = new HistoricoComprasFragmentViewModel();
		FragmentHistoricoComprasBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_historico_compras, container, false);

		binding.setViewModel(viewModel);
		return binding.getRoot();
	}

	@Override
	public void onResume() {
		super.onResume();
		viewModel.resume();
	}
}
