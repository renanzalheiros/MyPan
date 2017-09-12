package zalho.com.br.mypan.view.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

import zalho.com.br.mypan.R;
import zalho.com.br.mypan.model.entities.Login;
import zalho.com.br.mypan.model.manager.LoginManager;

/**
 * Created by andrepereira on 16/07/17.
 */

public class LoginActivity extends AppCompatActivity{

	private CallbackManager callbackManager;
	private LoginButton btnFacebookLogin;

	private Login user = new Login();

	private SharedPreferences shared;
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		shared = getSharedPreferences("login", Context.MODE_PRIVATE);
		if(AccessToken.getCurrentAccessToken() != null){
			goToMainActivity();
		}

		btnFacebookLogin = (LoginButton) findViewById(R.id.btn_facebook_login);

		btnFacebookLogin.setReadPermissions(Arrays.asList("email"));

		callbackManager = CallbackManager.Factory.create();

		btnFacebookLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

			@Override
			public void onSuccess(LoginResult loginResult) {
				Toast.makeText(LoginActivity.this, "Logou no facebook", Toast.LENGTH_SHORT).show();

				GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
					@Override
					public void onCompleted(JSONObject json, GraphResponse response) {
						// Application code
						if (response.getError() != null) {
							System.out.println("ERROR");
						} else {
							System.out.println("Success");
							String jsonresult = String.valueOf(json);
							System.out.println("JSON Result" + jsonresult);

							String fbUserId = json.optString("id");
							String fbUserFirstName = json.optString("name");
							String fbUserEmail = json.optString("email");

							LoginManager manager = new LoginManager(LoginActivity.this);
							manager.checkCredentials(fbUserEmail)
									.subscribe(login -> {
										user.setId(login.getId());
										user.setEmail(login.getEmail());
										user.setToken(login.getToken());

										manager.saveUser(user);
										goToMainActivity();
									}, throwable -> {
										throwable.printStackTrace();
										com.facebook.login.LoginManager.getInstance().logOut();
										Toast.makeText(LoginActivity.this, "Erro ao realizar login", Toast.LENGTH_SHORT).show();
									});
						}
						Log.v("FaceBook Response :", response.toString());
					}
				});
				Bundle parameters = new Bundle();
				parameters.putString("fields", "id,name,email,gender");
				request.setParameters(parameters);
				request.executeAsync();
			}

			@Override
			public void onCancel() {
				// App code
				Toast.makeText(LoginActivity.this, "Cancelou", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onError(FacebookException exception) {
				// App code
				Toast.makeText(LoginActivity.this, "Errou", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void goToMainActivity() {
		Intent intent = new Intent(LoginActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onStop() {
		super.onStop();
		btnFacebookLogin.unregisterCallback(callbackManager);
	}
}
