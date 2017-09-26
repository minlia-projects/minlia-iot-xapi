package com.minlia.iot.plugin.brcb.body.api.cs.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerServiceApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;


/**
 * http://note.youdao.com/share/?token=44AF662F83914546B6F7F93FFBBE69F0&gid=47293425#/
 */
@XmlRootElement(name = "xml")
@Data
@Signature
public class BrcbCustomerConfigQueryRequestBody extends BrcbCustomerServiceApiHttpRequestBody {


//  字段名	变量名	必填	类型	说明
//  业务类型	serviceType	是	varchar(32)	值为：CUSTOMER_QUERYCONFIG
//  代理商编号	agentNum	是	varchar(32)	由北农商分配
//  商户编号	customerNum	是	varchar(32)	由北农商分配
//  配置通道	configChannel	是	varchar(32)	WECHAT_OFFLINE或WECHAT_APP
//  签名	sign	是	varchar(32)	签名见签名规则


  @XmlElement(name = "customerNum", required = true)
  @JsonProperty(value = "customerNum")
  private String customerNum;


  @XmlElement(name = "configChannel", required = true)
  @JsonProperty(value = "configChannel")
  private String configChannel;



  /**
   * 签名	sign	是	varchar(32)	签名见签名规则
   */
  @XmlElement(name = "sign", required = true)
  @JsonProperty(value = "sign")
  private String sign;


}
