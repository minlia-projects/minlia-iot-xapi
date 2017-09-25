package com.minlia.iot.plugin.brcb;

import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.config.BrcbApiEndpointConfiguration;
import com.minlia.iot.plugin.brcb.config.payment.alipay.BrcbPaymentAlipayApiCredentialConfiguration;
import com.minlia.iot.scope.ApiRequestMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by will on 9/10/17.
 * 不同的api请求参数需要分离成不同的API
 */
@Configuration
public class BrcbPaymentAlipayTestConfiguration {

  private String ebusinessIdProduction = "C149628461779610201";
  private String appKeyProduction = "acc503c56b0c4fd399f7f7093d25223c";
  private String paymentProduction = "http://brcb.pufubao.net/gateway";


  private String ebusinessIdSandbox = "C149628461779610201";
  private String appKeySandbox = "acc503c56b0c4fd399f7f7093d25223c";
  private String paymentSandbox = "http://www.brcb-sandbox.sunfund.com/gateway";

  /**
   * 生产环境
   * @return
   */
  @Bean
  ApiCredentialConfiguration brcbPaymentAlipayApiCredentialConfigurationProduction() {
    BrcbPaymentAlipayApiCredentialConfiguration configuration = new BrcbPaymentAlipayApiCredentialConfiguration();
    configuration.setMchKey(appKeyProduction);
    configuration.setMchId(ebusinessIdProduction);
    configuration.setApiRequestMode(ApiRequestMode.PRODUCTION);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbPaymentAlipayApiEndpointConfigurationProduction() {
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
  ApiCredentialConfiguration brcbPaymentAlipayApiCredentialConfigurationSandbox() {
    BrcbPaymentAlipayApiCredentialConfiguration configuration = new BrcbPaymentAlipayApiCredentialConfiguration();
    configuration.setMchKey(appKeySandbox);
    configuration.setMchId(ebusinessIdSandbox);
    configuration.setApiRequestMode(ApiRequestMode.SANDBOX);
    return configuration;
  }

  @Bean
  ApiEndpointConfiguration brcbPaymentAlipayApiEndpointConfigurationSandbox() {
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
  public BrcbAlipayPaymentApi brcbPaymentApi() {


    //组装2套API凭证参数进来
    ApiCredentialConfiguration[] apiCredentialConfigurations = {
        brcbPaymentAlipayApiCredentialConfigurationProduction(),
        brcbPaymentAlipayApiCredentialConfigurationSandbox()};


    //组装2套API端点参数进来
    ApiEndpointConfiguration[] apiEndpointConfigurations = {
        brcbPaymentAlipayApiEndpointConfigurationProduction(),
        brcbPaymentAlipayApiEndpointConfigurationSandbox()};
    return new BrcbAlipayPaymentApi(apiCredentialConfigurations,
        apiEndpointConfigurations);
  }


}
