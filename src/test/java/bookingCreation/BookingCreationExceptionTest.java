package bookingCreation;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.TestCase;
import model.TestCases;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Utils;

public class BookingCreationExceptionTest {
    private static TestCases testCases;
    @BeforeClass
    public void setup() {
        testCases = Utils.loadTestCases("src/test/json/bookingCreation/ExceptionTestCases.json");
    }

    @DataProvider(name = "testCaseId", parallel = true)
    public Object[] testCaseId() {
        return new Object[] { "4"};
//        Object[] dataProvider = new Object[testCases.numTestCases()];
//        for (int i =0; i < testCases.numTestCases(); i++) {
//            TestCase eachTestCase = testCases.getTestCaseAtIndex(i);
//            dataProvider[i] = eachTestCase.getConfig().getId();
//        }
//        return dataProvider;
    }

    @Test(dataProvider = "testCaseId")
    public void BookingCreationExceptionTestNonConventional(String id) throws Exception {
        TestCase testCase = testCases.getTestCaseById(id);
        testCase.getConfig().printConfig();
        String propertyFile = Constants.CONF_PATH + Utils.getEnvironment(null) + Constants.PROPERTY_SUFFIX;
        String uri = Utils.getPropertyValue(propertyFile, "base_uri");
        String json = new ObjectMapper().writeValueAsString(testCase.getInputParams().getBookingResource());
        Response response = RestAssured.given().
                baseUri(uri).
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 500);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 500 Internal Server Error");
    }
}
