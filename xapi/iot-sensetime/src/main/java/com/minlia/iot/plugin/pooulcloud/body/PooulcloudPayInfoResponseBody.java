package com.minlia.iot.plugin.pooulcloud.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.body.ApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class PooulcloudPayInfoResponseBody extends ApiHttpRequestBody {
//  {"appId":"wx26a0ffd6bfa99df7","timeStamp":"1526429363","nonceStr":"hXJ2e3dQZm8qwZlc","package":"prepay_id=wx1608092325202618ae9afa6d0781719733","signType":"MD5","paySign":"94095737486E1394D9534599B7A978D5"}

  private String appId;
  private String timeStamp;
  private String nonceStr;

  @XmlElement(name = "package")
  @JsonProperty(value = "package")
  private String pkg;
  private String signType;
  private String paySign;

}

