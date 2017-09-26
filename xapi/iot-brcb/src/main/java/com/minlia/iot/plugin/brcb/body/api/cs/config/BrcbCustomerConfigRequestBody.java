package com.minlia.iot.plugin.brcb.body.api.cs.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerServiceApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@XmlRootElement(name = "xml")
@Data
@Signature
public class BrcbCustomerConfigRequestBody extends BrcbCustomerServiceApiHttpRequestBody {


//  业务类型	serviceType	是	varchar(32)	值为：CUSTOMER_CONFIG
//  代理商编号	agentNum	是	varchar(32)	由北农商分配
//  商户编号	customerNum	是	varchar(32)	由北农商分配
//  配置通道	configChannel	是	varchar(32)	WECHAT_OFFLINE或WECHAT_APP
//  授权目录	jsapiPath	至少存在一个	varchar(32)	公众账号JS API支付授权目录
//  APPID	appid	至少存在一个	varchar(32)
//  关注公众账号	scribeAppid	至少存在一个	varchar(32)	推荐关注公众账号APPID
//  签名	sign	是	varchar(32)	签名见签名规则

  @XmlElement(name = "customerNum", required = true)
  @JsonProperty(value = "customerNum")
  private String customerNum;


  @XmlElement(name = "configChannel", required = true)
  @JsonProperty(value = "configChannel")
  private String configChannel;

  @XmlElement(name = "jsapiPath", required = true)
  @JsonProperty(value = "jsapiPath")
  private String jsapiPath;

  @XmlElement(name = "appid", required = true)
  @JsonProperty(value = "appid")
  private String appid;


  @XmlElement(name = "scribeAppid", required = true)
  @JsonProperty(value = "scribeAppid")
  private String scribeAppid;


  /**
   * 签名	sign	是	varchar(32)	签名见签名规则
   */
  @XmlElement(name = "sign", required = true)
  @JsonProperty(value = "sign")
  private String sign;


}
