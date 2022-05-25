import DataAccess.RefereeDaoSQL;
import Service.UserApplication;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class AddReferee {



    UserApplication userApp=new UserApplication();
    RefereeDaoSQL refereDAo=RefereeDaoSQL.getInstance();

    @Test
    public void addReferee()
    {
        userApp.insertReferee("Test1","test123","1234");
        Assert.assertNotNull(refereDAo.get("test123","1234"));
        refereDAo.deleteRef("test123","1234");
    }






}
