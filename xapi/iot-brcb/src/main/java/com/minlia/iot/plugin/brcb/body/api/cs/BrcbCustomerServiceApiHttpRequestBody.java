package com.minlia.iot.plugin.brcb.body.api.cs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.body.ApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;
/**
 *
 * 文档地址： http://note.youdao.com/share/?token=B4F4FAED481F4B4AB2A1F869EE4B5C08&gid=47293425#/
 * Created by qianyi on 2017/9/18
 * 进件商户到北京农村商业银行，
 *请求Body
 环境
 测试URL: http://www.brcb-sandbox.sunfund.com/customer/service
 正式URL: http://brcb.pufubao.net/customer/service

 测试参数
 代理商编号：A147860093307610145
 代理商密钥：2e01317bb92a458280ca2ec3a466ceba
 业务类型	serviceType	是	varchar(32)	值为：CUSTOMER_ENTER
 */
@Data
public class BrcbCustomerServiceApiHttpRequestBody extends ApiHttpRequestBody {

  /**
   * 业务类型	serviceType	是	varchar(32)	值为：CUSTOMER_ENTER
   */
  @XmlElement(name = "serviceType",required = true)
  @JsonProperty(value = "serviceType",required = true)
  private String serviceType;

  /**
   * 代理商编号	agentNum	是	varchar(32)	由北农商分配
   */
  @XmlElement(name = "agentNum",required = true)
  @JsonProperty(value = "agentNum")
  private String agentNum;


}
