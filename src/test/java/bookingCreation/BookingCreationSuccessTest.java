package bookingCreation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.*;
import model.TestCase;
import model.TestCases;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Utils;


public class BookingCreationSuccessTest {
    private static TestCases testCases;

    @BeforeClass
    public void setup() {
        testCases = Utils.loadTestCases("src/test/json/bookingCreation/SuccessTestCases.json");
    }

    @DataProvider(name = "testCaseId", parallel = true)
    public Object[] testCaseId() {
        Object[] dataProvider = new Object[testCases.numTestCases()];
        for (int i =0; i < testCases.numTestCases(); i++) {
            TestCase eachTestCase = testCases.getTestCaseAtIndex(i);
            dataProvider[i] = eachTestCase.getConfig().getId();
        }
        return dataProvider;
    }

    @Test(dataProvider = "testCaseId")
    public void BookingCreationSuccessTestNonConventional(String id) throws Exception {
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
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), testCase.getOutputParams().getPositiveCaseResponse().getBookingResource().getFirstName());
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), testCase.getOutputParams().getPositiveCaseResponse().getBookingResource().getLastName());
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), testCase.getOutputParams().getPositiveCaseResponse().getBookingResource().getTotalPrice());
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), String.valueOf(testCase.getOutputParams().getPositiveCaseResponse().getBookingResource().isDepositPaid()));
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), testCase.getOutputParams().getPositiveCaseResponse().getBookingResource().getBookingDates().getCheckinDate());
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), testCase.getOutputParams().getPositiveCaseResponse().getBookingResource().getBookingDates().getCheckoutDate());
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), testCase.getOutputParams().getPositiveCaseResponse().getBookingResource().getAdditionalneeds());
    }
}
