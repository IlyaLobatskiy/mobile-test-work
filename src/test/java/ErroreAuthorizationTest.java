import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.my.test.app.framework.LoginPage;

public class ErroreAuthorizationTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    public ErroreAuthorizationTest() throws Exception {
    }

    @Test
    public void errAuthorizationTest(){
        String result = loginPage.authorization("12", "1124");
        Assertions.assertEquals( "Login failed", result, "Error");
    }
}
