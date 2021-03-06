package com.minlia.iot.plugin.brcb.config;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import lombok.Data;

@Data
public class BrcbApiEndpointConfiguration extends AbstractApiRequestConfiguration implements
    ApiEndpointConfiguration {

  /**
   * 商户进件服务URL
   */
  private String customerEnter;

  /**
   * 商户查询服务URL
   */
  private String customerQuery;

  /**
   * 支付交易网关
   */
  private String paymentGateway;


  /**
   * 商户T0结算
   */
  private String t0Settle;

  /**
   * 商户T0结算查询
   */
  private String t0SettleQuery;


}
