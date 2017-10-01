package zalho.com.br.mypan.service;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import zalho.com.br.mypan.model.entities.Login;

/**
 * Created by andrepereira on 16/07/17.
 */

public interface LoginService {

	@POST("login/save.json")
	Observable<Login> saveNewUser(@Body Login login);

}
