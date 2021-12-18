package model.inputParams;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.BookingResource;

public class TestCaseInputParams {

  @JsonProperty("bookingResource")
  private BookingResource bookingResource;

  public BookingResource getBookingResource() {
    return bookingResource;
  }
}
