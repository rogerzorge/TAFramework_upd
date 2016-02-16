package by.epam.taframework.businessobject;

/**
 * Created by Yahor_Faliazhynski on 2/3/2016.
 */
public class Account {

    private String login;
    private String passw;

    public Account() {}

    public Account(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return this.passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

}
