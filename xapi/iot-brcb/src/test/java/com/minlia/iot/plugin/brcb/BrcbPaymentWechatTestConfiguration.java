package com.minlia.iot.plugin.brcb;

import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.config.BrcbApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.config.payment.wechat.BrcbPaymentWechatApiCredentialConfiguration;
import com.minlia.iot.scope.ApiRequestMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by will on 9/10/17.
 * 不同的api请求参数需要分离成不同的API
 */
@Configuration
public class BrcbPaymentWechatTestConfiguration {

  private String ebusinessIdProduction = "C150226031936310846";
  private String appKeyProduction = "98abac04672549cfa651a9e52b08fc62";
  private String paymentProduction = "http://brcb.pufubao.net/gateway";


  private String ebusinessIdSandbox = "C149628461779610201";
  private String appKeySandbox = "acc503c56b0c4fd399f7f7093d25223c";
  private String paymentSandbox = "http://www.brcb-sandbox.sunfund.com/gateway";

  /**
   * 生产环境
   * @return
   */
  @Bean
  ApiCredentialConfiguration brcbPaymentWechatApiCredentialConfigurationProduction() {
    BrcbPaymentWechatApiCredentialConfiguration configuration = new BrcbPaymentWechatApiCredentialConfiguration();
//    configuration.setMchKey(appKeyProduction);
//    configuration.setMchId(ebusinessIdProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbPaymentWechatApiEndpointConfigurationProduction() {
    BrcbApiEndpointConfiguration configuration = new BrcbApiEndpointConfiguration();
    configuration.setPaymentGateway(paymentProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }


  /**
   * 沙箱环境
   * @return
   */
  @Bean
  ApiCredentialConfiguration brcbPaymentWechatApiCredentialConfigurationSandbox() {
    BrcbPaymentWechatApiCredentialConfiguration configuration = new BrcbPaymentWechatApiCredentialConfiguration();
//    configuration.setMchKey(appKeySandbox);
//    configuration.setMchId(ebusinessIdSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbPaymentWechatApiEndpointConfigurationSandbox() {
    BrcbApiEndpointConfiguration configuration = new BrcbApiEndpointConfiguration();
    configuration.setPaymentGateway(paymentSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }


  /**
   * 组装配置参数
   * @return
   */
  @Bean
  public BrcbWechatPaymentApi brcbPaymentApi() {


    //组装2套API凭证参数进来
    ApiCredentialConfiguration[] apiCredentialConfigurations = {
        brcbPaymentWechatApiCredentialConfigurationProduction(),
        brcbPaymentWechatApiCredentialConfigurationSandbox()};


    //组装2套API端点参数进来
    ApiEndpointConfiguration[] apiEndpointConfigurations = {
        brcbPaymentWechatApiEndpointConfigurationProduction(),
        brcbPaymentWechatApiEndpointConfigurationSandbox()};
    return new BrcbWechatPaymentApi(apiCredentialConfigurations,
        apiEndpointConfigurations);
  }


}
