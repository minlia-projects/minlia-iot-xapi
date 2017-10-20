package com.minlia.iot.plugin.swiftpass.body.jspay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpResponseBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by will on 9/10/17.
 */
@Data
public class SwiftpassWechatJspayPayInfoBody {

  private String appId;

  private String timeStamp;

  private String status;

  private String signType;

  @JsonProperty(value = "package")
  @XmlElement(name = "package")
  private String packages;

  private String callbackUrl;

  private String nonceStr;

  private String paySign;

}
