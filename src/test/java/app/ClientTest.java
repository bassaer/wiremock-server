package app;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest(httpsEnabled = true)
class ClientTest {

    Client client;

    private WireMockServer wireMockServer;

    @BeforeEach
    void before() {
        client = new Client();
        wireMockServer = new WireMockServer(options().port(8080));
        wireMockServer.start();
        configureFor(this.wireMockServer.port());
    }

    @AfterEach
    void after() {
        wireMockServer.stop();
    }

    @Test
    void getTest() {
        stubFor(get("/").willReturn(aResponse()
                .withStatus(200)
                .withBody("OK")));

        String actual = client.get("http://127.0.0.1:8080");
        assertEquals("OK", actual);
    }
}
