package model.authenticationParams;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthBuilderParams {
  @JsonProperty("clientId")
  private String clientId;

  @JsonProperty("clientSecret")
  private String clientSecret;

  @JsonProperty("privateKey")
  private String privateKey;

  @JsonProperty("issuer")
  private String issuer;

  @JsonProperty("subject")
  private String subject;

  public String getClientId() {
    return clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public String getIssuer() {
    return issuer;
  }

  public String getSubject() {
    return subject;
  }
}