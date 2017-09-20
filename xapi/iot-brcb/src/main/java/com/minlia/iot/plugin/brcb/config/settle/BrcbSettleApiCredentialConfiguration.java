package com.minlia.iot.plugin.brcb.config.settle;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiCredentialConfiguration;
import lombok.Data;


@Data
public class BrcbSettleApiCredentialConfiguration extends AbstractApiRequestConfiguration implements
    ApiCredentialConfiguration {

  private String mchId;

  private String mchKey;


}
