package model.inputParams;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.List;

public class BookingDates {
        @JsonProperty("checkin")
        private String checkinDate;

        @JsonProperty("checkout")
        private String checkoutDate;

        public String getCheckinDate() {
                return checkinDate;
        }

        public String getCheckoutDate() {
                return checkoutDate;
        }

        public BookingDates(String checkinDate, String checkoutDate) {
                this.checkinDate = checkinDate;
                this.checkoutDate = checkoutDate;
        }

        public BookingDates(String checkinDate) {
                this.checkinDate = checkinDate;
                this.checkoutDate = null;
        }

        public BookingDates() {
        }
}
