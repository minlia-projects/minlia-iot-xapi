package com.minlia.iot.plugin.brcb.body.api.payment.wechat.unifiedorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.brcb.body.BrcbApiHttpResponseBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by will on 9/10/17.
 */
@Data
public class BrcbPaymentWechatUnifiedOrderResponseBody extends BrcbApiHttpResponseBody {


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

  @JsonProperty(value = "result_code")
  @XmlElement(name = "result_code")
  private String resultCode;


  @JsonProperty(value = "trade_type")
  @XmlElement(name = "trade_type")
  private String tradeType;


  @JsonProperty(value = "transaction_id")
  @XmlElement(name = "transaction_id")
  private String  transactionId;


  @JsonProperty(value = "out_trade_no")
  @XmlElement(name = "out_trade_no")
  private String  outTradeNo;

  @JsonProperty(value = "pay_json")
  @XmlElement(name = "pay_json")
  private String payJson;


  @JsonProperty(value = "prepay_id")
  @XmlElement(name = "prepay_id")
  private String prepayId;


  /**
   * 随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位。推荐随机数生成算法
   */
  @XmlElement(name = "nonce_str", required = true)
  @JsonProperty(value = "nonce_str")
  private String nonceStr= RandomStringUtils.randomAlphabetic(31);


  /**
   *签名 sign    是   String(32)  MD5 签名结果，详见“第 4 章 MD5 签名规则”
   */
  @XmlElement(name = "sign", required = true)
  @JsonProperty(value = "sign")
  private String sign;


}
