package zalho.com.br.mypan.view.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.util.component.CartComponent;
import zalho.com.br.mypan.util.component.DaggerCartComponent;
import zalho.com.br.mypan.util.component.DaggerProductComponent;
import zalho.com.br.mypan.util.component.ProductComponent;
import zalho.com.br.mypan.util.module.CartModule;
import zalho.com.br.mypan.util.module.ProductModule;
import zalho.com.br.mypan.view.adapter.ViewPagerAdapter;
import zalho.com.br.mypan.view.fragment.CartFragment;
import zalho.com.br.mypan.view.fragment.ProductsListFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private CartFragment cartFragment;
    private ProductsListFragment productsListFragment;
    private CartComponent cartComponent;
    private ProductComponent productComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productComponent = DaggerProductComponent.builder()
                .productModule(new ProductModule(this))
                .build();

        cartComponent = DaggerCartComponent.builder()
                .cartModule(new CartModule(this))
                .build();

        viewPager = (ViewPager) findViewById(R.id.viewpager_main_activity);
        configurarViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_main_activity);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        cartFragment.onResume();
                        break;
                    case 1:
                        cartFragment.onResume();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private void configurarViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        productsListFragment = new ProductsListFragment();
        cartFragment = new CartFragment();

        viewPagerAdapter.addFragment(productsListFragment, "Produtos");
        viewPagerAdapter.addFragment(cartFragment, "Carrinho");

        viewPager.setAdapter(viewPagerAdapter);
    }

    public ProductComponent getProductComponent() {
        return productComponent;
    }

    public CartComponent getCartComponent() {
        return cartComponent;
    }
}
