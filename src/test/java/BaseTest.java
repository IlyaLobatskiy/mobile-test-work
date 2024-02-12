import org.junit.jupiter.api.AfterEach;
import org.my.test.app.managers.DriverMansger;

public class BaseTest {

    protected DriverMansger driverMansger = DriverMansger.getDriverManager();

    @AfterEach
    public void quitDriver(){
        driverMansger.quitDriver();
    }

}
