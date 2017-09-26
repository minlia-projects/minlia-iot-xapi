package com.minlia.iot.plugin.brcb.body.api.cs.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.brcb.body.BrcbApiHttpResponseBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class BrcbCustomerConfigResponseBody extends BrcbApiHttpResponseBody {

//  返回码	return_code	是	varchar(32)	SUCCESS/ERROR_CODE 查看错误码
//  返回信息	return_msg	否	varchar(255)	返回信息
//  授权目录返回码	js_result_code	否	varchar(255)	SUCCESS为成功否则失败
//  授权目录返回信息	js_result_msg	否	varchar(255)	返回信息
//  商户appid返回码	appid_result_code	否	varchar(255)	SUCCESS为成功否则失败
//  商户appid返回信息	appid_result_msg	否	varchar(255)	返回信息
//  推荐关注公众号返回码	scribe_appid_result_code	否	varchar(255)	SUCCESS为成功否则
//  推荐关注公众号返回信息	scribe_appid_result_msg	否	varchar(255)	返回信息
//  签名	sign	是	varchar(32)	签名见签名规则

  @XmlElement(name = "js_result_code" )
  @JsonProperty(value = "js_result_code")
  private String jsResultCode;

  @XmlElement(name = "js_result_msg" )
  @JsonProperty(value = "js_result_msg")
  private String jsResultMsg;


  @XmlElement(name = "appid_result_code" )
  @JsonProperty(value = "appid_result_code")
  private String appidResultCode;



  @XmlElement(name = "appid_result_msg" )
  @JsonProperty(value = "appid_result_msg")
  private String appidResultMsg;


  @XmlElement(name = "scribe_appid_result_code" )
  @JsonProperty(value = "scribe_appid_result_code")
  private String scribeAppidResultCode;



  @XmlElement(name = "scribe_appid_result_msg" )
  @JsonProperty(value = "scribe_appid_result_msg")
  private String scribeAppidResultMsg;








  @XmlElement(name = "bank" )
  @JsonProperty(value = "bank")
  private String bank;

  @XmlElement(name = "fee" )
  @JsonProperty(value = "fee")
  private String fee;

  @XmlElement(name = "material" )
  @JsonProperty(value = "material")
  private String material;


}
