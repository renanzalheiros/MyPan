package zalho.com.br.mypan.util.component;

import javax.inject.Singleton;

import dagger.Component;
import zalho.com.br.mypan.model.viewmodel.CartListHolderViewModel;
import zalho.com.br.mypan.model.viewmodel.ProductsListFragmentViewModel;
import zalho.com.br.mypan.util.module.ProductModule;

/**
 * Created by andrepereira on 01/09/17.
 */

@Component(modules = {ProductModule.class})
@Singleton
public interface ProductComponent {

	void inject(ProductsListFragmentViewModel productsListFragmentViewModel);
	void inject(CartListHolderViewModel cartListHolderViewModel);
}
