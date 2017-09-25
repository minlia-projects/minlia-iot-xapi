package com.minlia.iot.plugin.brcb.config.payment.alipay;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiCredentialConfiguration;
import lombok.Data;


@Data
public class BrcbPaymentAlipayApiCredentialConfiguration extends AbstractApiRequestConfiguration implements
    ApiCredentialConfiguration {

  private String mchId;

  private String mchKey;


}
