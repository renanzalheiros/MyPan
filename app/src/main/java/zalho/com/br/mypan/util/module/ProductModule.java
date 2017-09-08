package zalho.com.br.mypan.util.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zalho.com.br.mypan.model.manager.ProductManager;

/**
 * Created by andrepereira on 01/09/17.
 */

@Module
public class ProductModule {

	private final Context context;

	public ProductModule(Context context){
		this.context = context;
	}

	@Provides
	@Singleton
	ProductManager getProductManager(){
		return new ProductManager(context);
	}
}
