package com.minlia.iot.plugin.swiftpass.config;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiCredentialConfiguration;
import lombok.Data;

@Data
public class SwiftpassApiCredentialConfiguration extends AbstractApiRequestConfiguration implements
    ApiCredentialConfiguration {

  private String mchId;
  private String key;


}
