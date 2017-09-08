package zalho.com.br.mypan.model.entities;

import java.io.Serializable;

/**
 * Created by andrepereira on 16/07/17.
 */

public class Login implements Serializable {

	private Integer id;
	private String email;
	private String token;

	public Login() {
	}

	public Login(Integer id, String email, String token) {
		this.id = id;
		this.email = email;
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
