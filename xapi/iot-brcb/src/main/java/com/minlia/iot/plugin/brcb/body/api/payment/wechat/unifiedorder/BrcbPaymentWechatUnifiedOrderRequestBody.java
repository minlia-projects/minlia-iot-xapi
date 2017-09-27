package com.minlia.iot.plugin.brcb.body.api.payment.wechat.unifiedorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.brcb.body.api.payment.BrcbPaymentApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;


@XmlRootElement(name = "xml")
@Data
@Signature
public class BrcbPaymentWechatUnifiedOrderRequestBody extends BrcbPaymentApiHttpRequestBody {

  @XmlElement(name = "mch_id",required = true)
  @JsonProperty(value = "mch_id")
  private String mchId;



  @XmlElement(name = "openid",required = true)
  @JsonProperty(value = "openid",required = true)
  private String openid;

  /**
   * 商品描述	body	是	String(127)	商品描述
   */
  @XmlElement(name = "body",required = true)
  @JsonProperty(value = "body",required = true)
  private String body;

  /**
   * 商户订单号    out_trade_no    是   String(32)  商户系统内部的订单号 ,32 个字符内、 可包含字母,确保 在商户系统唯一
   */
  @XmlElement(name = "out_trade_no",required = true)
  @JsonProperty(value = "out_trade_no",required = true)
  private String outTradeNo;


  /**
   * 总金额  total_fee   是       Int     总金额，以分为单位，不允许包含任何字、 符号
   */
  @XmlElement(name = "total_fee",required = true)
  @JsonProperty(value = "total_fee",required = true)
  private Integer totalFee;


  /**
   * 终端 IP    mch_create_ip   是   String(16)  订单生成的机器 IP
   */
  @XmlElement(name = "spbill_create_ip",required = true)
  @JsonProperty(value = "spbill_create_ip",required = true)
  private String spbillCreateIp;


  /**
   * 通知地址	notify_url	是	varchar(255)	接收农商行通知的公网URL
   */
  @XmlElement(name = "notify_url",required = true)
  @JsonProperty(value = "notify_url",required = true)
  private String notifyUrl;


  @XmlElement(name = "trade_type",required = true)
  @JsonProperty(value = "trade_type",required = true)
  private String tradeType="JSAPI";

  /**
   * 下游自行调起支付	is_self_pay	是	varchar(32)	下游是否自己使用js调起支付，值为Y／N
   */
  @XmlElement(name = "is_self_pay",required = true)
  @JsonProperty(value = "is_self_pay",required = true)
  private String isSelfPay="Y";

  /**
   * 随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位。推荐随机数生成算法
   */
  @XmlElement(name = "nonce_str", required = true)
  @JsonProperty(value = "nonce_str")
  private String nonceStr= RandomStringUtils.randomAlphabetic(10);


  /**
   *签名 sign    是   String(32)  MD5 签名结果，详见“第 4 章 MD5 签名规则”
   */
  @XmlElement(name = "sign", required = true)
  @JsonProperty(value = "sign")
  private String sign;

}
