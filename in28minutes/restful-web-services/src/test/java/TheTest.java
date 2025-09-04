import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * Created by Alex Corghencea on 05 September 2017.
 */
public class TheTest {

    @Before
    public void setUp() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGetMessage() {
        mockServer.expect(requestTo("http://google.com"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("resultSuccess", MediaType.TEXT_PLAIN));

        String result = simpleRestService.getMessage();

        mockServer.verify();
        assertThat(result, allOf(containsString("SUCCESS"),
                containsString("resultSuccess")));
    }

    @Test
    public void testGetMessage_500() {
        mockServer.expect(requestTo("http://google.com"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withServerError());

        String result = simpleRestService.getMessage();

        mockServer.verify();
        assertThat(result, allOf(containsString("FAILED"),
                containsString("500")));
    }

}
