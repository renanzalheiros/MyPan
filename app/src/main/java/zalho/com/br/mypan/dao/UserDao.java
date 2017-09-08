package zalho.com.br.mypan.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.snappydb.SnappydbException;

import zalho.com.br.mypan.model.entities.Login;

/**
 * Created by andrepereira on 11/07/17.
 */

public class UserDao {

	private SharedPreferences sharedPreferences;
	public UserDao(Context context) {
		sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
	}

	public Login getUser() {
		String user = sharedPreferences.getString("user", "");
		return new Gson().fromJson(user, Login.class);
	}

	public Login saveUser(Login login) throws SnappydbException {
		SharedPreferences.Editor edit = sharedPreferences.edit();
		edit.putString("user", new Gson().toJson(login));
		edit.apply();
		return getUser();
	}
}
