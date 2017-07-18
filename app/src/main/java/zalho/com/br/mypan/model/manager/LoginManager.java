package zalho.com.br.mypan.model.manager;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zalho.com.br.mypan.model.entities.Login;
import zalho.com.br.mypan.service.LoginService;

/**
 * Created by andrepereira on 16/07/17.
 */

public class LoginManager {

	private LoginService service;

	public LoginManager(){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://192.168.0.12:8090/mypan/rest/")
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();

		service = retrofit.create(LoginService.class);
	}

	public Login saveNewUser(String userId, String userEmail){
		final Login user = new Login(userId, userEmail, "");
		service.saveNewUser(user)
				.doOnNext(new Consumer<Login>() {
					@Override
					public void accept(Login login) throws Exception {
						Log.v("ZALHOMAN RETROFIT", "Accept doOnNext");
					}
				})
				.subscribeOn(Schedulers.newThread())
				.subscribe(new Consumer<Login>() {
					@Override
					public void accept(Login login) throws Exception {
						user.setToken(login.getToken());
					}
				}, new Consumer<Throwable>() {
					@Override
					public void accept(Throwable throwable) throws Exception {
						throwable.printStackTrace();
						user.setUserId("");
						user.setUserEmail("");
					}
				});
		return user;
	}
}
