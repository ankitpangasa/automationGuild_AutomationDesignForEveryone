package model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCaseConfig {
  @JsonProperty("id")
  private String id;

  @JsonProperty("description")
  private String description;

  public String getId(){
    return id;
  }

  public String getDescription(){
    return description;
  }

  public String printConfig(){
    System.out.println("TESTCASE ID : " + id);
    System.out.println("TESTCASE DESCRIPTION : " + description);
    return null;
  }
}