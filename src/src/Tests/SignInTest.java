

import Service.UserApplication;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.junit.jupiter.api.DisplayName;

public class SignInTest {

    UserApplication user=new UserApplication();



    @Test
    @DisplayName("Sign in with vail System Manager User")
    public void signIn()
    {

        Assert.assertNotEquals(null,(user.sign_in("ehsank","123")));
    }

    @Test
    @DisplayName("Sign in with vail Referee User")
    public void refsignIn()
    {

        Assert.assertNotEquals(null,(user.sign_in("khalilmh","123456")));
    }


    @Test
    @DisplayName("Check With Wrong UserName")
    public void testSignInUser()
    {
        Assert.assertEquals(null,(user.sign_in("None","1234")));
        Assert.assertEquals(null,(user.sign_in("123","1234")));
    }



    @Test
    @DisplayName("Check With Wrong Password")
    public void testSignInPass()
    {
        Assert.assertEquals(null,(user.sign_in("ehsank","123224")));
        Assert.assertEquals(null,(user.sign_in("khalilmh","1231114")));
    }


    @Test
    @DisplayName("Sign in with invalid user and pass")
    public void signIninValid()
    {

        Assert.assertEquals(null,(user.sign_in("asfs","1594423")));
    }


    @Test
    public void IsRefere()
    {
        Assert.assertEquals(true,user.sign_in("khalilmh","123456").is_referee());
        Assert.assertEquals(false,user.sign_in("ehsank","123").is_referee());
    }


}
