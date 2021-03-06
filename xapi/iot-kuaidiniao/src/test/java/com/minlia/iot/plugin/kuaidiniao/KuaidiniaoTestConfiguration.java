package com.minlia.iot.plugin.kuaidiniao;

import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.kuaidiniao.config.KuaidiniaoApiCredentialConfiguration;
import com.minlia.iot.plugin.kuaidiniao.config.KuaidiniaoApiEndpointConfiguration;
import com.minlia.iot.scope.ApiRequestMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.minlia.module.xapi.plugin.wechat.WechatPayApi;

/**
 * Created by will on 9/10/17.
 */
@Configuration
public class KuaidiniaoTestConfiguration {


  private String ebusinessIdSandbox = "1255666";
  private String appKeySandbox = "4a3fe63b-9a0d-4daa-861e-7057a9f30206";


  private String ebusinessIdProduction = "1256193";
  private String appKeyProduction = "66d76465-e6d6-4136-a38a-6d3740f813b8";


  private String queryProduction = "http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";


  private String querySandbox = "http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";


  @Bean
  ApiCredentialConfiguration kuaidiniaoApiCredentialConfigurationProduction() {
    KuaidiniaoApiCredentialConfiguration configuration = new KuaidiniaoApiCredentialConfiguration();
    configuration.setAppKey(appKeyProduction);
    configuration.setEbusinessId(ebusinessIdProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration kuaidiniaoApiEndpointConfigurationProduction() {
    KuaidiniaoApiEndpointConfiguration configuration = new KuaidiniaoApiEndpointConfiguration();
    configuration.setKuaidiniaoQuery(queryProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiCredentialConfiguration kuaidiniaoApiCredentialConfigurationSandbox() {
    KuaidiniaoApiCredentialConfiguration configuration = new KuaidiniaoApiCredentialConfiguration();
    configuration.setAppKey(appKeySandbox);
    configuration.setEbusinessId(ebusinessIdSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration kuaidiniaoApiEndpointConfigurationSandbox() {
    KuaidiniaoApiEndpointConfiguration configuration = new KuaidiniaoApiEndpointConfiguration();
    configuration.setKuaidiniaoQuery(querySandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }


  @Bean
  public KuaidiniaoApi kuaidiniaoApi() {
    ApiCredentialConfiguration[] apiCredentialConfigurations = {
        kuaidiniaoApiCredentialConfigurationProduction(),
        kuaidiniaoApiCredentialConfigurationSandbox()};
    ApiEndpointConfiguration[] apiEndpointConfigurations = {
        kuaidiniaoApiEndpointConfigurationProduction(),
        kuaidiniaoApiEndpointConfigurationSandbox()};
    return new KuaidiniaoApi(apiCredentialConfigurations,
        apiEndpointConfigurations);
  }


}
