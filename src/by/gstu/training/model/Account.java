package by.gstu.training.model;


public class Account extends Entity{
    private String login;
    private String password;
    private int accessLevel;
    private int userId;
    private User user;

    public Account(int id, String login, String password, int accessLevel, int userId) {
        super(id);
        this.login = login;
        this.password = password;
        this.accessLevel = accessLevel;
        this.userId = userId;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return login+"   "+accessLevel;
    }
}
