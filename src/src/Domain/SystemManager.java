package Domain;

public class SystemManager extends User {


    public SystemManager(String Name, String UserName, String Password) {
        super(Name, UserName, Password);

    }

    @Override
    public boolean is_referee() {
        return false;
    }



}

