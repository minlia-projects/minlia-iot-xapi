package com.example.demo.config;

import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.swiftpass.SwiftpassApi;
import com.minlia.iot.plugin.swiftpass.config.SwiftpassApiCredentialConfiguration;
import com.minlia.iot.plugin.swiftpass.config.SwiftpassApiEndpointConfiguration;
import com.minlia.iot.scope.ApiRequestMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by will on 9/10/17.
 */
@Configuration
public class SwiftpassConfiguration {


  private String mchIdSandbox = "755437000006";
  private String keySandbox = "7daa4babae15ae17eee90c9e";


  private String mchIdProduction = "7551000001";
  private String keyProduction = "9d101c97133837e13dde2d32a5054abb";


  private String endpointProduction = "https://pay.swiftpass.cn/pay/gateway";
  private String endpointSandbox = "https://pay.swiftpass.cn/pay/gateway";


  @Bean
  ApiCredentialConfiguration swiftpassApiCredentialConfigurationProduction() {
    SwiftpassApiCredentialConfiguration configuration = new SwiftpassApiCredentialConfiguration();
    configuration.setKey(keyProduction);
    configuration.setMchId(mchIdProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration swiftpassApiEndpointConfigurationProduction() {
    SwiftpassApiEndpointConfiguration configuration = new SwiftpassApiEndpointConfiguration();
    configuration.setEndpoint(endpointProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiCredentialConfiguration swiftpassApiCredentialConfigurationSandbox() {
    SwiftpassApiCredentialConfiguration configuration = new SwiftpassApiCredentialConfiguration();
    configuration.setKey(keySandbox);
    configuration.setMchId(mchIdSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration swiftpassApiEndpointConfigurationSandbox() {
    SwiftpassApiEndpointConfiguration configuration = new SwiftpassApiEndpointConfiguration();
    configuration.setEndpoint(endpointSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }


  @Bean
  public SwiftpassApi swiftpassApi() {
    ApiCredentialConfiguration[] apiCredentialConfigurations = {
        swiftpassApiCredentialConfigurationProduction(),
        swiftpassApiCredentialConfigurationSandbox()};
    ApiEndpointConfiguration[] apiEndpointConfigurations = {
        swiftpassApiEndpointConfigurationProduction(),
        swiftpassApiEndpointConfigurationSandbox()};
    return new SwiftpassApi(apiCredentialConfigurations,
        apiEndpointConfigurations);
  }


}
