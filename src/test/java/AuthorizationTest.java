import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.my.test.app.framework.LoginPage;


public class AuthorizationTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    public AuthorizationTest() throws Exception {
    }


    @Test
    public void authorization(){

        String result = loginPage.authorization("admin@admin.ru", "1234");
        Assertions.assertEquals( "Welcome ! user", result, "Error");

    }
}

