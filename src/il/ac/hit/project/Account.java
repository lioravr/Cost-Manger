package il.ac.hit.project;

public class Account {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Account (String userName, String password)
    {
        this.userName=userName;
        this.password=password;
    }
}
