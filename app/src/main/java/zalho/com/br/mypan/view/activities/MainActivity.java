package zalho.com.br.mypan.view.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.view.adapter.ViewPagerAdapter;
import zalho.com.br.mypan.view.fragment.CartFragment;
import zalho.com.br.mypan.view.fragment.ProductsListFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager_main_activity);
        configurarViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_main_activity);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void configurarViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        final ProductsListFragment productsListFragment = new ProductsListFragment();
        final CartFragment cartFragment = new CartFragment();

        viewPagerAdapter.addFragment(productsListFragment, "Produtos");
        viewPagerAdapter.addFragment(cartFragment, "Carrinho");

        viewPager.setAdapter(viewPagerAdapter);
    }
}
