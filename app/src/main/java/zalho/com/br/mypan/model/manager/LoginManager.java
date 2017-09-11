package zalho.com.br.mypan.model.manager;

import android.content.Context;
import android.util.Log;

import com.snappydb.SnappydbException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zalho.com.br.mypan.MypanApplication;
import zalho.com.br.mypan.dao.UserDao;
import zalho.com.br.mypan.model.entities.Login;
import zalho.com.br.mypan.service.LoginService;
import zalho.com.br.mypan.util.Constantes;
import zalho.com.br.mypan.view.activities.LoginActivity;
import zalho.com.br.mypan.view.activities.MainActivity;

/**
 * Created by andrepereira on 16/07/17.
 */

public class LoginManager {

	private LoginService service;
	private final UserDao userDao;

	public LoginManager(Context context) {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(Constantes.LOCALHOST_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();

		service = retrofit.create(LoginService.class);

		userDao = new UserDao(context);
	}

	public Observable<Login> checkCredentials(String userEmail){
		Login user = new Login(null, userEmail, "");
		return service.saveNewUser(user)
				.doOnNext(login -> {
					Log.v("TOKEN LOGIN", login.getToken());
					Log.v("ZALHOMAN RETROFIT", "Accept doOnNext");
				})
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread());
	}

	public void saveUser(Login login) {
		userDao.saveUser(login);
	}
}
