package model.outputParams;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCaseOutputParams {
  @JsonProperty("positiveCase")
  private PositiveCase positiveCase;

  @JsonProperty("exceptionCase")
  private ExceptionCase exceptionCase;

  public PositiveCase getPositiveCaseResponse(){
    return positiveCase;
  }

  public ExceptionCase getExceptionCaseResponse(){
    return exceptionCase;
  }
}
