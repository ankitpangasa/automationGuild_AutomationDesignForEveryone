package model.outputParams;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.BookingResource;

public class PositiveCase {

  public BookingResource getBookingResource() {
    return bookingResource;
  }

  @JsonProperty("bookingResource")
  private BookingResource bookingResource;
}
