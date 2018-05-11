package com.minlia.iot.plugin.brcb;

import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.config.BrcbApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.config.settle.BrcbSettleApiCredentialConfiguration;
import com.minlia.iot.scope.ApiRequestMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by will on 9/10/17.
 * 不同的api请求参数需要分离成不同的API
 */
@Configuration
public class BrcbSettleTestConfiguration {

  private String ebusinessIdProduction = "C149628461779610201";
  private String appKeyProduction = "acc503c56b0c4fd399f7f7093d25223c";
  private String t0SettleProduction = "http://brcb.pufubao.net/customer/payType";
  private String t0SettleQueryProduction = "http://www.brcb-sandbox.sunfund.com/T0SettleQuery";


  private String ebusinessIdSandbox = "C149628461779610201";
  private String appKeySandbox = "acc503c56b0c4fd399f7f7093d25223c";
  private String t0SettleSandbox = "http://brcb.pufubao.net/customer/payType";
  private String t0SettleQuerySandbox = "http://www.brcb-sandbox.sunfund.com/T0SettleQuery";

  /**
   * 生产环境
   * @return
   */
  @Bean
  ApiCredentialConfiguration brcbSettleApiCredentialConfigurationProduction() {
    BrcbSettleApiCredentialConfiguration configuration = new BrcbSettleApiCredentialConfiguration();
    configuration.setMchKey(appKeyProduction);
    configuration.setMchId(ebusinessIdProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbSettleApiEndpointConfigurationProduction() {
    BrcbApiEndpointConfiguration configuration = new BrcbApiEndpointConfiguration();
    configuration.setT0Settle(t0SettleProduction);
    configuration.setT0SettleQuery(t0SettleQueryProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }


  /**
   * 沙箱环境
   * @return
   */
  @Bean
  ApiCredentialConfiguration brcbSettleApiCredentialConfigurationSandbox() {
    BrcbSettleApiCredentialConfiguration configuration = new BrcbSettleApiCredentialConfiguration();
    configuration.setMchKey(appKeySandbox);
    configuration.setMchId(ebusinessIdSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbSettleApiEndpointConfigurationSandbox() {
    BrcbApiEndpointConfiguration configuration = new BrcbApiEndpointConfiguration();
    configuration.setT0Settle(t0SettleSandbox);
    configuration.setT0SettleQuery(t0SettleQuerySandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }


  /**
   * 组装配置参数
   * @return
   */
  @Bean
  public BrcbSettleApi brcbSettleApi() {


    //组装2套API凭证参数进来
    ApiCredentialConfiguration[] apiCredentialConfigurations = {
        brcbSettleApiCredentialConfigurationProduction(),
        brcbSettleApiCredentialConfigurationSandbox()};


    //组装2套API端点参数进来
    ApiEndpointConfiguration[] apiEndpointConfigurations = {
        brcbSettleApiEndpointConfigurationProduction(),
        brcbSettleApiEndpointConfigurationSandbox()};
    return new BrcbSettleApi(apiCredentialConfigurations,
        apiEndpointConfigurations);
  }


}
