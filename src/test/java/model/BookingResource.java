package model;
import com.fasterxml.jackson.annotation.JsonProperty;
import model.inputParams.BookingDates;

public class BookingResource {
        @JsonProperty("firstname")
        private String firstName;

        @JsonProperty("lastname")
        private String lastName;

        @JsonProperty("totalprice")
        private String totalPrice;

        @JsonProperty("depositpaid")
        private boolean depositPaid;

        @JsonProperty("additionalneeds")
        private String additionalneeds;

        @JsonProperty("bookingdates")
        private BookingDates bookingDates;

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public String getTotalPrice() {
                return totalPrice;
        }

        public boolean isDepositPaid() {
                return depositPaid;
        }

        public String getAdditionalneeds() {
                return additionalneeds;
        }

        public BookingDates getBookingDates() {
                return bookingDates;
        }
}
