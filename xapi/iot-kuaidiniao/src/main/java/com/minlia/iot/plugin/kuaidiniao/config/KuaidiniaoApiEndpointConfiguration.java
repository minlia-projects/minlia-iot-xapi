package com.minlia.iot.plugin.kuaidiniao.config;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import lombok.Data;

@Data
public class KuaidiniaoApiEndpointConfiguration extends AbstractApiRequestConfiguration implements
    ApiEndpointConfiguration {

  private String kuaidiniaoQuery;

}
