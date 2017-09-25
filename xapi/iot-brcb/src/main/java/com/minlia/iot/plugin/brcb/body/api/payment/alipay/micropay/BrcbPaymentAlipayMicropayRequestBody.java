package com.minlia.iot.plugin.brcb.body.api.payment.alipay.micropay;

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
public class BrcbPaymentAlipayMicropayRequestBody extends BrcbPaymentApiHttpRequestBody {

  /**
   *设备授权码	auth_code	是	varchar(128)	设备读取用户微信中的条码或者二维码信息
   */
  @XmlElement(name = "auth_code",required = true)
  @JsonProperty(value = "auth_code",required = true)
  private String authCode;


  /**
   * 支付场景	scene	是	varchar(32)	条码-bar_code， 声波-wave_code
   */
  @XmlElement(name = "scene",required = true)
  @JsonProperty(value = "scene",required = true)
  private String scene;


  /**
   * 商品描述	body	是	String(127)	商品描述
   */
  @XmlElement(name = "body",required = true)
  @JsonProperty(value = "body",required = true)
  private String body;

  /**
   * 设备号	device_info	是	varchar(32)	终端设备号
   */
  @XmlElement(name = "device_info",required = true)
  @JsonProperty(value = "device_info",required = true)
  private String deviceInfo;


  /**
   * 订单标题	subject	是	varchar(256)	订单标题
   */
  @XmlElement(name = "subject",required = true)
  @JsonProperty(value = "subject",required = true)
  private String subject;

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
  private String totalFee;

  /**
   * 货币类型	fee_type	否	varchar(16)	默认人民币：CNY
   */
  @XmlElement(name = "fee_type" )
  @JsonProperty(value = "fee_type" )
  private String feeType="CNY";

  /**
   * 终端 IP    mch_create_ip   是   String(16)  订单生成的机器 IP
   */
  @XmlElement(name = "spbill_create_ip",required = true)
  @JsonProperty(value = "spbill_create_ip",required = true)
  private String spbillCreateIp;



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
