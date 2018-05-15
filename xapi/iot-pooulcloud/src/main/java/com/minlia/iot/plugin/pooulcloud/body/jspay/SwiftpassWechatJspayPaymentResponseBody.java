package com.minlia.iot.plugin.pooulcloud.body.jspay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.pooulcloud.body.SwiftpassApiHttpResponseBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by will on 9/10/17.
 */
@Data
public class SwiftpassWechatJspayPaymentResponseBody extends SwiftpassApiHttpResponseBody {




  //        "data": {
//           "appid": "wx26a0ffd6bfa99df7",
//          "sub_appid": "wx469ffdb81de47e4d",
//          "prepay_id": "wx1521101398908548b7cbf75f1090559034",
//          "pay_info": "{\"appId\":\"wx26a0ffd6bfa99df7\",\"timeStamp\":\"1526389814\",\"nonceStr\":\"rjtdjUjLck1lh9tW\",\"package\":\"prepay_id=wx1521101398908548b7cbf75f1090559034\",\"signType\":\"MD5\",\"paySign\":\"440537728C4050F5D123EE99D8F9C792\"}",
//          "trade_id": "5afadc35fd4eb06e4bc17029",
//          "mch_trade_id": "MINLIA-TEST-ORDER-2307894603",
//          "merchant_id": "2302209837595143",
//          "pay_type": "wechat.jsapi",
//          "nonce_str": "5afadc36fd4eb06e4bc1702c"
//        },

  @JsonProperty(value = "appid")
  @XmlElement(name = "appid")
  private String appid;

  @JsonProperty(value = "sub_appid")
  @XmlElement(name = "sub_appid")
  private String sub_appid;

  @JsonProperty(value = "prepay_id")
  @XmlElement(name = "prepay_id")
  private String prepay_id;

  @JsonProperty(value = "nonceStr")
  @XmlElement(name = "nonce_str")
  private String nonceStr;

  @JsonProperty(value = "sign")
  @XmlElement(name = "sign")
  private String sign;

  @JsonProperty(value = "pay_info")
  @XmlElement(name = "pay_info")
  private String pay_info;

  @JsonProperty(value = "trade_id")
  @XmlElement(name = "trade_id")
  private String trade_id;

  @JsonProperty(value = "mch_trade_id")
  @XmlElement(name = "mch_trade_id")
  private String mch_trade_id;

  @JsonProperty(value = "merchant_id")
  @XmlElement(name = "merchant_id")
  private String merchant_id;

  @JsonProperty(value = "pay_type")
  @XmlElement(name = "pay_type")
  private String pay_type;

}
