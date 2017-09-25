package com.minlia.iot.plugin.brcb.scope;

import com.minlia.iot.scope.ApiScopes;

/**
 * 本SDK提供的API范围
 */
public enum BrcbApiScope implements ApiScopes {

  /**
   * 商户进件
   */
  CUSTOMER_ENTER,
  /**
   * 商户T0结算
   */
  T0_SETTLE,
  /**
   * 商户T0结算查询
   */
  T0_SETTLE_QUERY

  /**
   * 交易支付网关
   */

  ,PAYMENT_GATEWAY



}
