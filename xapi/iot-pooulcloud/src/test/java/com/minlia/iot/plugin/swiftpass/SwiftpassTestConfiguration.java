package com.minlia.iot.plugin.swiftpass;

import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.pooulcloud.SwiftpassApi;
import com.minlia.iot.plugin.pooulcloud.config.SwiftpassApiEndpointConfiguration;
import com.minlia.iot.plugin.pooulcloud.config.SwiftpassApiCredentialConfiguration;
import com.minlia.iot.scope.ApiRequestMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.minlia.module.xapi.plugin.wechat.WechatPayApi;

/**
 * Created by will on 9/10/17.
 */
@Configuration
public class SwiftpassTestConfiguration {


  private String mchIdSandbox = "2302209837595143";
  private String keySandbox = "79A4EEE852658DF06B5A0099A608F8EC";


//  private String mchIdProduction = "8444812501217143";
//  private String keyProduction = "7B8CC56D58F81D7DACCE67C4D6C90E4D";
  private String mchIdProduction = "2302209837595143";
  private String keyProduction = "79A4EEE852658DF06B5A0099A608F8EC";



  //测试： http://gateway-test.pooulcloud.cn/paygate/merchant_info/pay
//  生产： https://gateway.pooulcloud.cn/paygate/merchant_info/pay



//  尊敬的商户,您好：
//  恭喜您，注册资料审核通过！以下为您账户所需的重要信息，请妥善保管
//  商户名称：云管家（深圳）网络科技有限公司
//  商户编号：8444812501217143
//  初始密码：376fd86
//  密钥：7B8CC56D58F81D7DACCE67C4D6C90E4D


  private String endpointProduction = "https://gateway.pooulcloud.cn/paygate/merchant_info/pay";
  private String endpointSandbox = "https://gateway.pooulcloud.cn/paygate/merchant_info/pay";


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
