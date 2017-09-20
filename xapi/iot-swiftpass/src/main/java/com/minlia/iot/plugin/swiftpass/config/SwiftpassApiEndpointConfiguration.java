package com.minlia.iot.plugin.swiftpass.config;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import lombok.Data;

/**
 * 需要与ApiScopes SwiftpassApiScope 中定义的枚举保持一致
 */
@Data
public class SwiftpassApiEndpointConfiguration extends AbstractApiRequestConfiguration implements
    ApiEndpointConfiguration {

  private String endpoint;

}
