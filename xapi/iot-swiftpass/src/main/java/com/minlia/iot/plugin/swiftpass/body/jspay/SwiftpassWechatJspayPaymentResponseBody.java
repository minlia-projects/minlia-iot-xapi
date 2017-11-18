package com.minlia.iot.plugin.swiftpass.body.jspay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpResponseBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by will on 9/10/17.
 */
@Data
public class SwiftpassWechatJspayPaymentResponseBody extends SwiftpassApiHttpResponseBody {

  @JsonProperty(value = "appid")
  @XmlElement(name = "appid")
  private String appid;

  @JsonProperty(value = "mchId")
  @XmlElement(name = "mch_id")
  private String mchId;

  @JsonProperty(value = "resultCode")
  @XmlElement(name = "result_code")
  private String resultCode;

  @JsonProperty(value = "nonceStr")
  @XmlElement(name = "nonce_str")
  private String nonceStr;

  @JsonProperty(value = "sign")
  @XmlElement(name = "sign")
  private String sign;

  @JsonProperty(value = "tokenId")
  @XmlElement(name = "token_id")
  private String tokenId;

  @XmlElement(name = "pay_info")
  private String payInfo;

}
