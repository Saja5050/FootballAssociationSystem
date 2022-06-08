package Domain;

public abstract class User {
    private String name;
    private String username;
    private String password;

    // constructors / standard setters / getters
    public User (String Name, String UserName , String Password) {
        name=Name;
        username=UserName;
        password=Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    abstract public boolean is_referee() ;

}
