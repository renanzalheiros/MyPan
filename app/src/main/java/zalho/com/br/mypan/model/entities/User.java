package zalho.com.br.mypan.model.entities;

/**
 * Created by andrepereira on 27/06/17.
 */

public class User {

    private final Integer userId;
    private final String userName;
    private final String userPassword;

    public User(Integer userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
