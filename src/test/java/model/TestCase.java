package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.config.TestCaseConfig;
import model.inputParams.*;
import model.outputParams.TestCaseOutputParams;

public class TestCase {

  @JsonProperty("config")
  private TestCaseConfig config;

  @JsonProperty("inputParams")
  private TestCaseInputParams inputParams;

  @JsonProperty("outputParams")
  private TestCaseOutputParams outputParams;

  public TestCaseConfig getConfig() {
    return config;
  }

  public TestCaseInputParams getInputParams() {
    return inputParams;
  }

  public TestCaseOutputParams getOutputParams() {
    return outputParams;
  }
}
