package test_service.mock;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.BeforeAll;

public class BrowserMobTest {
    @BeforeAll
    static void beforeAll(){
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        int port = proxy.getPort(); // get the JVM-assigned port
    }

}
