package test_service.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class StubTEST {
    @BeforeAll
    static void beforeAll(){
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        configureFor("localhost",8089);
        System.out.println("server start");
    }

    @Test
    void stuf(){
        stubFor(get(urlEqualTo("/my/resource"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void stufOnProxy(){
        stubFor(
                get(urlMatching(".*"))
                .atPriority(10)
                .willReturn(aResponse().proxiedFrom("https://ceshiren.com"))

        );
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stubFor(
                get(urlMatching("/categories_and_latest"))
                .atPriority(1)
                .willReturn(aResponse().withBodyFile(""))
        );

    }

}
