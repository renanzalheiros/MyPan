package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by andrepereira on 16/07/17.
 */

public class Login implements Serializable {

	private String id;
	private String email;
	private String token;

	public Login() {
	}

	public Login(String id, String email, String token) {
		this.id = id;
		this.email = email;
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
