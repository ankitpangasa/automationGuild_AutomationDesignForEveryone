package model.authenticationParams;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientConfigParams {
  @JsonProperty("connectTimeout")
  private int connectTimeout;

  @JsonProperty("readTimeout")
  private int readTimeout;

  @JsonProperty("uploadReadTimeout")
  private int uploadReadTimeout;

  public int getConnectTimeout() {
    return connectTimeout;
  }

  public int getReadTimeout() {
    return readTimeout;
  }

  public int getUploadReadTimeout() {
    return uploadReadTimeout;
  }
}