package com.minlia.iot.plugin.brcb.body.api.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@XmlRootElement(name = "xml")
@Data
@Signature
public class BrcbT0SettleQueryRequestBody extends BrcbSettleApiHttpRequestBody {

  @XmlElement(name = "settle_num", required = true)
  @JsonProperty(value = "settle_num")
  private String settleNum;

  @XmlElement(name = "out_trade_no", required = true)
  @JsonProperty(value = "out_trade_no")
  private String outTradeNo;

  @XmlElement(name = "settle_mode", required = true)
  @JsonProperty(value = "settle_mode")
  private BrcbSettleMode settleMode;

  /**
   * 签名	sign	是	varchar(32)	签名见签名规则
   */
  @XmlElement(name = "sign", required = true)
  @JsonProperty(value = "sign")
  private String sign;


}
