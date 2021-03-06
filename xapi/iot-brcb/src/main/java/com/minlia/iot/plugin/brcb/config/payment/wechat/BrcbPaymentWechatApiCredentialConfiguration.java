package com.minlia.iot.plugin.brcb.config.payment.wechat;

import com.minlia.iot.config.AbstractApiRequestConfiguration;
import com.minlia.iot.config.ApiCredentialConfiguration;
import lombok.Data;


@Data
public class BrcbPaymentWechatApiCredentialConfiguration extends AbstractApiRequestConfiguration implements
    ApiCredentialConfiguration {

  private String appid;
}
