package zalho.com.br.mypan.model.entities;

import zalho.com.br.mypan.util.CriptoUtil;

/**
 * Created by andrepereira on 16/07/17.
 */

public class Login {

	private String userId;
	private String userEmail;
	private String token;

	public Login() {
	}

	public Login(String userId, String userEmail, String token) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
