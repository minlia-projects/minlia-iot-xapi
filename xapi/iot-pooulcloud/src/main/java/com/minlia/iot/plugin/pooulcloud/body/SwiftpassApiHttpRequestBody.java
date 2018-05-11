package com.minlia.iot.plugin.pooulcloud.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.body.ApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 * swiftpass接口公共请求参数
 */
@Data
public class SwiftpassApiHttpRequestBody extends ApiHttpRequestBody {

  /**
   * 接口类型	payType	是	String(32)
   * 接口类型：pay.weixin.native
   *
   *
   */
  @XmlElement(name = "pay_type")
  @JsonProperty(value = "pay_type")
  private String payType;

  /**
   * 商户号	mch_id	是	String(32)	商户号，由平台分配
   */
  @XmlElement(name = "merchant_id")
  @JsonProperty(value = "merchant_id")
  private String merchantId;

  /**
   * 商户密钥
   */
  private String mchSecret;

  /**
   * 版本号	version	否	String(8)	版本号，version默认值是2.0
   */
//  @XmlElement(name = "version")
//  @JsonProperty(value = "version")
//  private String version="1.0";

//  /**
//   * 字符集	charset	否	String(8)	可选值 UTF-8 ，默认为 UTF-8
//   */
//  @XmlElement(name = "charset")
//  @JsonProperty(value = "charset")
//  private String charset="UTF-8";


  /**
   * 签名方式	sign_type	否	String(8)	签名类型，取值：MD5默认：MD5
   */
  @XmlElement(name = "sign_type")
  @JsonProperty(value = "sign_type")
  private String signType="md5";

}
