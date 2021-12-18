package model.authenticationParams;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCaseAuthenticationParams {
  @JsonProperty("authFilePath")
  private String authFilePath;

  @JsonProperty("configFilePath")
  private String configFilePath;

  @JsonProperty("authBuilderParams")
  private AuthBuilderParams authBuilderParams;

  @JsonProperty("clientConfigParams")
  private ClientConfigParams clientConfigParams;

  public String getAuthFilePath(){
    return authFilePath;
  }

  public String getConfigFilePath() {
    return configFilePath;
  }

  public AuthBuilderParams getAuthBuilderParams(){
    return authBuilderParams;
  }

  public ClientConfigParams getClientConfigParams() {
    return clientConfigParams;
  }
}