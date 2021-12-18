package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCases {
  private List<TestCase> testCases;

  public List<TestCase> getTestCases() {
    return testCases;
  }

  public int numTestCases(){
    if(testCases != null){
      return testCases.size();
    }
    else
      return -1;
  }

  public TestCase getTestCaseAtIndex(int i) {
    if(testCases != null){
      return testCases.get(i);
    }
    else
      return null;
  }

  public TestCase getTestCaseById(String id) {
    if(testCases != null){
      for(int i=0; i<testCases.size(); i++){
        TestCase eachTestCase = getTestCaseAtIndex(i);
        if(eachTestCase.getConfig().getId().equals(id))
          return eachTestCase;
      }
      return null;
    }
    else
      return null;
  }
}