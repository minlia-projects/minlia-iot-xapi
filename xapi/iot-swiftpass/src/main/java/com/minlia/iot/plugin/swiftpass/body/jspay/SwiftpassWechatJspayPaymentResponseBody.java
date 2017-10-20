package com.minlia.iot.plugin.swiftpass.body.jspay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpResponseBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class SwiftpassWechatJspayPaymentResponseBody extends SwiftpassApiHttpResponseBody {

  /* 返回状态码 */
  @JsonProperty(value = "err_code")
  @XmlElement(name = "err_code")
  private String errCode;

  /* 返回信息 */
  @JsonProperty(value = "err_msg")
  @XmlElement(name = "err_msg")
  private String errMsg;

  @JsonProperty(value = "appid")
  @XmlElement(name = "appid")
  private String appid;

  @JsonProperty(value = "mch_id")
  @XmlElement(name = "mch_id")
  private String mchId;

  @JsonProperty(value = "nonce_str")
  @XmlElement(name = "nonce_str")
  private String nonceStr;

  @JsonProperty(value = "pay_info")
  @XmlElement(name = "pay_info")
  private String payInfo;

  @JsonProperty(value = "token_id")
  @XmlElement(name = "token_id")
  private String tokenId;




}
