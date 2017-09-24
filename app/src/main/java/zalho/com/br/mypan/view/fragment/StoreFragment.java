package zalho.com.br.mypan.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.view.adapter.ViewPagerAdapter;

/**
 * Created by andrepereira on 21/09/17.
 */

public class StoreFragment extends Fragment {

	private ViewPager viewPager;
	private TabLayout tabLayout;
	private CartFragment cartFragment;
	private ProductsListFragment productsListFragment;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View inflate = inflater.inflate(R.layout.fragment_store, container, false);

		viewPager = (ViewPager) inflate.findViewById(R.id.viewpager_main_activity);
		tabLayout = (TabLayout) inflate.findViewById(R.id.tabs_main_activity);

		configurarViewPager(viewPager);
		tabLayout.setupWithViewPager(viewPager);

		return inflate;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	private void configurarViewPager(ViewPager viewPager) {
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
		productsListFragment = new ProductsListFragment();
		cartFragment = new CartFragment();

		viewPagerAdapter.addFragment(productsListFragment, "Produtos");
		viewPagerAdapter.addFragment(cartFragment, "Carrinho");

		viewPager.setAdapter(viewPagerAdapter);
	}
}
