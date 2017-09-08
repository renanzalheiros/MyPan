package zalho.com.br.mypan.util.component;

import javax.inject.Singleton;

import dagger.Component;
import zalho.com.br.mypan.model.viewmodel.CartFragmentViewModel;
import zalho.com.br.mypan.model.viewmodel.ProductsListHolderViewModel;
import zalho.com.br.mypan.util.module.CartModule;

/**
 * Created by andrepereira on 01/09/17.
 */

@Component(modules = {CartModule.class})
@Singleton
public interface CartComponent {

	void inject(ProductsListHolderViewModel productsListHolderViewModel);
	void inject(CartFragmentViewModel cartFragmentViewModel);
}
