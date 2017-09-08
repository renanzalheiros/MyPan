package zalho.com.br.mypan.util.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zalho.com.br.mypan.model.manager.CartManager;

/**
 * Created by andrepereira on 01/09/17.
 */

@Module
public class CartModule {

	private final Context context;

	public CartModule(Context context){
		this.context = context;
	}

	@Provides
	@Singleton
	CartManager getCartManager(){
		return new CartManager(context);
	}
}
