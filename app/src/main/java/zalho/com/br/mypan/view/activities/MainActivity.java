package zalho.com.br.mypan.view.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.events.RefreshDisplayEvent;
import zalho.com.br.mypan.model.manager.CartManager;
import zalho.com.br.mypan.view.adapter.ViewPagerAdapter;
import zalho.com.br.mypan.view.fragment.CartFragment;
import zalho.com.br.mypan.view.fragment.ProductsListFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private CartFragment cartFragment;
    private ProductsListFragment productsListFragment;
    private CartManager cartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager_main_activity);
        configurarViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_main_activity);
        tabLayout.setupWithViewPager(viewPager);

        cartManager = new CartManager(this);
    }

    private void configurarViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        productsListFragment = new ProductsListFragment();
        cartFragment = new CartFragment();

        viewPagerAdapter.addFragment(productsListFragment, "Produtos");
        viewPagerAdapter.addFragment(cartFragment, "Carrinho");

        viewPager.setAdapter(viewPagerAdapter);
    }

    public CartManager getCartManager() {
        return cartManager;
    }
}
