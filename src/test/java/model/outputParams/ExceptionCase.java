package model.outputParams;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.BookingResource;

public class ExceptionCase {
  public int getStatusCode() {
    return statusCode;
  }

  public String getError() {
    return error;
  }

  @JsonProperty("statusCode")
  private int statusCode;

  @JsonProperty("error")
  private String error;

}
