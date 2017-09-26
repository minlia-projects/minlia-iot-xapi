package com.minlia.iot.plugin.brcb.body.api.cs.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerServiceApiHttpRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbPayChannel;
import com.minlia.iot.plugin.brcb.body.api.settle.BrcbSettleProcessMode;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@XmlRootElement(name = "xml")
@Data
@Signature
public class BrcbCustomerQueryRequestBody extends BrcbCustomerServiceApiHttpRequestBody {



//  业务类型	serviceType	是	varchar(32)	类型：CUSTOMER_INFO
//  代理商编号	agentNum	是	varchar(32)	由北农商分配
//  查询条件类型	queryType	是	varchar(32)	值为：0/1
//  商户编号	customerNum	否	varchar(32)	查询条件类型为0时必填
//  下游商户号	outMchId	否	varchar(32)	查询条件类型为1时必填
//  签名	sign	是	varchar(32)	签名见签名规则
  @XmlElement(name = "queryType", required = true)
  @JsonProperty(value = "queryType")
  private String queryType;
  @XmlElement(name = "customerNum", required = true)
  @JsonProperty(value = "customerNum")
  private String customerNum;
  @XmlElement(name = "outMchId", required = true)
  @JsonProperty(value = "outMchId")
  private String outMchId;


  /**
   * 签名	sign	是	varchar(32)	签名见签名规则
   */
  @XmlElement(name = "sign", required = true)
  @JsonProperty(value = "sign")
  private String sign;


}
