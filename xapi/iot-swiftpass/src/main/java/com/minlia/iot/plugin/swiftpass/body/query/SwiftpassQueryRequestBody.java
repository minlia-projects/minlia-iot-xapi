package com.minlia.iot.plugin.swiftpass.body.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by will on 9/10/17.
 */
@XmlRootElement(name = "xml")
@Data
@Signature
//@ApiRequestDataTransfer(source = "requestDataObject", target = "requestData", type = "UrlEncode")
public class SwiftpassQueryRequestBody extends SwiftpassApiHttpRequestBody {

  /**
   * 商品描述	body	是	String(127)	商品描述
   */
  @XmlElement(name = "body",required = true)
  private String body;

  /**
   * 商户订单号    out_trade_no    是   String(32)  商户系统内部的订单号 ,32 个字符内、 可包含字母,确保 在商户系统唯一
   */
  @XmlElement(name = "out_trade_no",required = true)
  private String outTradeNo;


  /**
   * 总金额  total_fee   是       Int     总金额，以分为单位，不允许包含任何字、 符号
   */
  @XmlElement(name = "total_fee",required = true)
  private String totalFee;

  /**
   * 终端 IP    mch_create_ip   是   String(16)  订单生成的机器 IP
   */
  @XmlElement(name = "mch_create_ip",required = true)
  private String mchCreateIp;



  /**
   * 通知地址 notify_url  是   String(255)
   *接收浦发银行通知的 URL，需给绝对路径，255 字符内格式 如:http://wap.tenpay.com/tenpay.asp，确 保浦发银行能通过互联网访问该地址
   */
  @XmlElement(name = "notify_url",required = true)
  @JsonProperty(value = "notify_url")
  private String notifyUrl;
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
