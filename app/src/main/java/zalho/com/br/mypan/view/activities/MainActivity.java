package zalho.com.br.mypan.view.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.model.manager.CartManager;
import zalho.com.br.mypan.view.fragment.StoreFragment;

public class MainActivity extends AppCompatActivity {
    private CartManager cartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartManager = new CartManager(this);
        navegarPara(StoreFragment.class);
    }

    public void navegarPara(Class<?> destino){
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_app, (Fragment) destino.newInstance())
                    .commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void navegarPara(String origem, Class<?> destino){
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_app, (Fragment) destino.newInstance()).addToBackStack(origem)
                    .commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public CartManager getCartManager() {
        return cartManager;
    }
}
