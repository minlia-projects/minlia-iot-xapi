package com.minlia.iot.plugin.kuaidiniao.config;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiCredentialConfiguration;
import lombok.Data;

@Data
public class KuaidiniaoApiCredentialConfiguration extends AbstractApiRequestConfiguration implements
    ApiCredentialConfiguration {

  private String ebusinessId;
  private String appKey;


}
