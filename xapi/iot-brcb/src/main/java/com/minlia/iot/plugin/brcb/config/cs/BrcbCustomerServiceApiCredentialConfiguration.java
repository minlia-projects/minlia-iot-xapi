package com.minlia.iot.plugin.brcb.config.cs;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiCredentialConfiguration;
import lombok.Data;

@Data
public class BrcbCustomerServiceApiCredentialConfiguration extends
    AbstractApiRequestConfiguration implements
    ApiCredentialConfiguration {

  private String agentNum;
  private String agentKey;


}
