package com.minlia.iot.plugin.brcb.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.ApiRequestEntity;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "xml")
public class BrcbStatefulApiResponseBody<T extends BrcbApiHttpResponseBody> implements StatefulApiResponseBody<T> {

  /**
   *响应码	return_code	是	varchar(32)	000000 为操作成功
   */
  @XmlElement(name = "return_code" )
  @JsonProperty(value = "return_code")
  private  String returnCode;
  /**
   *响应信息	return_msg	是	varchar(32)	提示具体的业务信息
   */
  @XmlElement(name = "return_msg" )
  @JsonProperty(value = "return_msg")
  private  String returnMsg;

  /**
   *签名	sign	是	varchar(32)	签名见签名规则
   */
  @XmlElement(name = "sign" )
  @JsonProperty(value = "sign")
  private  String sign;


  @ApiRequestEntity
  private T payload;

  public Boolean isSuccess() {
    return "000000".equals(returnCode);
  }


}
