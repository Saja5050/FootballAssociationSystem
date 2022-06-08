package Domain;

public class Referee extends User {

    public Referee(String Name, String UserName, String Password) {
        super(Name, UserName, Password);
    }
    @Override
    public boolean is_referee() {
        return true;
    }
}
