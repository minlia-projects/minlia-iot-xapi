package com.example.demo.config;

import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.BrcbCustomerServiceApi;
import com.minlia.iot.plugin.brcb.config.BrcbApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.config.cs.BrcbCustomerServiceApiCredentialConfiguration;
import com.minlia.iot.scope.ApiRequestMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by will on 9/10/17.
 * 不同的api请求参数需要分离成不同的API
 */
@Configuration
public class BrcbCustomerServiceTestConfiguration {

  private String ebusinessIdProduction = "1256193";
  private String appKeyProduction = "66d76465-e6d6-4136-a38a-6d3740f813b8";
  private String customerEnterProduction = "http://brcb.pufubao.net/customer/service";


  private String ebusinessIdSandbox = "A149628212021310656";
  private String appKeySandbox = "6ec855f4ff854c069a6d457748236d80";
  private String customerEnterSandbox = "http://www.brcb-sandbox.sunfund.com/customer/service";

  /**
   * 生产环境
   * @return
   */
  @Bean
  ApiCredentialConfiguration brcbCustomerServiceApiCredentialConfigurationProduction() {
    BrcbCustomerServiceApiCredentialConfiguration configuration = new BrcbCustomerServiceApiCredentialConfiguration();
    configuration.setAgentKey(appKeyProduction);
    configuration.setAgentNum(ebusinessIdProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbCustomerServiceApiEndpointConfigurationProduction() {
    BrcbApiEndpointConfiguration configuration = new BrcbApiEndpointConfiguration();
    configuration.setCustomerEnter(customerEnterProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }


  /**
   * 沙箱环境
   * @return
   */
  @Bean
  ApiCredentialConfiguration brcbCustomerServiceApiCredentialConfigurationSandbox() {
    BrcbCustomerServiceApiCredentialConfiguration configuration = new BrcbCustomerServiceApiCredentialConfiguration();
    configuration.setAgentKey(appKeySandbox);
    configuration.setAgentNum(ebusinessIdSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbCustomerServiceApiEndpointConfigurationSandbox() {
    BrcbApiEndpointConfiguration configuration = new BrcbApiEndpointConfiguration();
    configuration.setCustomerEnter(customerEnterSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }


  /**
   * 组装配置参数
   * @return
   */
  @Bean
  public BrcbCustomerServiceApi brcbCustomerServiceApi() {


    //组装2套API凭证参数进来
    ApiCredentialConfiguration[] apiCredentialConfigurations = {
        brcbCustomerServiceApiCredentialConfigurationProduction(),
        brcbCustomerServiceApiCredentialConfigurationSandbox()};


    //组装2套API端点参数进来
    ApiEndpointConfiguration[] apiEndpointConfigurations = {
        brcbCustomerServiceApiEndpointConfigurationProduction(),
        brcbCustomerServiceApiEndpointConfigurationSandbox()};
    return new BrcbCustomerServiceApi(apiCredentialConfigurations,
        apiEndpointConfigurations);
  }


}
