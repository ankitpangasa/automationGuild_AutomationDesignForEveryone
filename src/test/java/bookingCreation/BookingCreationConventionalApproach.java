package bookingCreation;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingCreationConventionalApproach {
    @Test(description = "sanity test")
    public void BookingCreationSuccessTestConventionalTest1() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Tim\",\n" +
                "          \"lastname\" : \"Brown\",\n" +
                "          \"totalprice\" : 111,\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Tim");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Brown");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), "111");
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "Multiple words in first name")
    public void BookingCreationSuccessTestConventionalTest2() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Tommy Hance\",\n" +
                "          \"lastname\" : \"Lee\",\n" +
                "          \"totalprice\" : 111,\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Tommy Hance");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Lee");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), "111");
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "Multiple words in last name")
    public void BookingCreationSuccessTestConventionalTest3() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Joe\",\n" +
                "          \"lastname\" : \"Lee Parker\",\n" +
                "          \"totalprice\" : 111,\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Joe");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Lee Parker");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), "111");
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "total price is 0")
    public void BookingCreationSuccessTestConventionalTest4() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Tim\",\n" +
                "          \"lastname\" : \"Lee\",\n" +
                "          \"totalprice\" : 0,\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Tim");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Lee");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), "0");
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "total price is string")
    public void BookingCreationSuccessTestConventionalTest5() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Tim\",\n" +
                "          \"lastname\" : \"Lee\",\n" +
                "          \"totalprice\" : \"$500\",\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Tim");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Lee");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), null);
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "Non Eng characters in First Name")
    public void BookingCreationSuccessTestConventionalTest6() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Zoë\",\n" +
                "          \"lastname\" : \"Lee\",\n" +
                "          \"totalprice\" : \"$500\",\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Zoë");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Lee");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), null);
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "Non Eng characters in Last Name")
    public void BookingCreationSuccessTestConventionalTest7() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Joey\",\n" +
                "          \"lastname\" : \"Adrián\",\n" +
                "          \"totalprice\" : 500,\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Joey");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Adrián");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), "500");
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "Non Eng (JP) characters in First Name")
    public void BookingCreationSuccessTestConventionalTest8() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"愛子\",\n" +
                "          \"lastname\" : \"Lee\",\n" +
                "          \"totalprice\" : \"$500\",\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "愛子");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Lee");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), null);
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "Non Eng (JP) characters in Last Name")
    public void BookingCreationSuccessTestConventionalTest9() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Joey\",\n" +
                "          \"lastname\" : \"あいみ\",\n" +
                "          \"totalprice\" : \"$500\",\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Joey");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "あいみ");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), null);
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
    }

    @Test(description = "Multiple additional needs")
    public void BookingCreationSuccessTestConventionalTest10() throws Exception {
        String json = "{\n" +
                "          \"firstname\" : \"Joey\",\n" +
                "          \"lastname\" : \"あいみ\",\n" +
                "          \"totalprice\" : \"$500\",\n" +
                "          \"depositpaid\" : false,\n" +
                "          \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "            \"checkout\" : \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\" : \"Breakfast, Dinner\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                body(json).
                when().
                post("/booking").
                then().
                log().all().
                extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(!response.jsonPath().getString("bookingid").equals(null));
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Joey");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "あいみ");
        Assert.assertEquals(response.jsonPath().getString("booking.totalprice"), null);
        Assert.assertEquals(response.jsonPath().getString("booking.depositpaid"), "false");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2018-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2019-01-01");
        Assert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast, Dinner");
    }

    @Test(description = "First Name is Null")
    public void BookingCreationSuccessTestConventionalTest11() throws Exception {
        String json = "{\n" +
                "        \"firstname\": null,\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": false,\n" +
                "        \"bookingdates\": {\n" +
                "          \"checkin\": \"2018-01-01\",\n" +
                "          \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "      }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
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

    @Test(description = "Last Name is Null")
    public void BookingCreationSuccessTestConventionalTest12() throws Exception {
        String json = "{\n" +
                "        \"firstname\": \"Brown\",\n" +
                "        \"lastname\": null,\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": false,\n" +
                "        \"bookingdates\": {\n" +
                "          \"checkin\": \"2018-01-01\",\n" +
                "          \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "      }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
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

    @Test(description = "Total price is null")
    public void BookingCreationSuccessTestConventionalTest13() throws Exception {
        String json = "{\n" +
                "        \"firstname\": \"Brown\",\n" +
                "        \"lastname\": \"Lee\",\n" +
                "        \"totalprice\": null,\n" +
                "        \"depositpaid\": false,\n" +
                "        \"bookingdates\": {\n" +
                "          \"checkin\": \"2018-01-01\",\n" +
                "          \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "      }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
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

    @Test(description = "Booking Date is null")
    public void BookingCreationSuccessTestConventionalTest14() throws Exception {
        String json = "{\n" +
                "   \"firstname\": \"Lee\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": null,\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
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

    @Test(description = "Checkin date is Null")
    public void BookingCreationSuccessTestConventionalTest15() throws Exception {
        String json = "{\n" +
                "   \"firstname\": \"Lee\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "            \"checkin\": null,\n" +
                "            \"checkout\": \"2018-01-01\"\n" +
                "          },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
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

    @Test(description = "Checkout date is Null")
    public void BookingCreationSuccessTestConventionalTest16() throws Exception {
        String json = "{\n" +
                "   \"firstname\": \"Lee\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": null\n" +
                "          },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
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

    @Test(description = "Additional Need is Null")
    public void BookingCreationSuccessTestConventionalTest17() throws Exception {
        String json = "{\n" +
                "          \"firstname\": \"Lee\",\n" +
                "          \"lastname\": \"Brown\",\n" +
                "          \"totalprice\": null,\n" +
                "          \"depositpaid\": false,\n" +
                "          \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "          },\n" +
                "          \"additionalneeds\": \"Breakfast\"\n" +
                "        }";
        Response response = RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com").
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
