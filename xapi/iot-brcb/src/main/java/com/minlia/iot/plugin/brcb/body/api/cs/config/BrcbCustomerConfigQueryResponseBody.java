package com.minlia.iot.plugin.brcb.body.api.cs.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.brcb.body.BrcbApiHttpResponseBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 * http://note.youdao.com/share/?token=44AF662F83914546B6F7F93FFBBE69F0&gid=47293425#/
 */
@Data
public class BrcbCustomerConfigQueryResponseBody extends BrcbApiHttpResponseBody {


//  返回码	return_code	是	varchar(32)	SUCCESS/ERROR_CODE 查看错误码
//  返回信息	return_msg	否	varchar(255)	返回信息
//  业务结果	result_code	否	varchar(255)	SUCCESS/FAIL
//  公众账号JSAPI支付授权目录	jsapi_path_list	否	varchar(255)	公众号支付域名列表 (最多返回 5 个支付域名)
//  特约商户APPID配置列表	appid_config_list	否	varchar(255)	每个appid对应一个scribe_appid， sub_appid=null对应默认的推荐关注
//  错误代码	err_code	否	varchar(255)	返回信息
//  错误代码描述	err_code_des	否	varchar(255)	结果信息描述
//  签名	sign	是	varchar(32)	签名见签名规则

  @XmlElement(name = "result_code" )
  @JsonProperty(value = "result_code")
  private String resultCode;


  @XmlElement(name = "jsapi_path_list" )
  @JsonProperty(value = "jsapi_path_list")
  private String jsapiPathList;


  @XmlElement(name = "err_code" )
  @JsonProperty(value = "err_code")
  private String err_code;



  @XmlElement(name = "err_code_des" )
  @JsonProperty(value = "err_code_des")
  private String errCodeDes;




  @XmlElement(name = "sign" )
  @JsonProperty(value = "sign")
  private String sign;




}
