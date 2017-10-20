package com.minlia.iot.plugin.swiftpass.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.ApiRequestEntity;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "xml")
public class SwiftpassStatefulApiResponseBody<RESPONSE extends SwiftpassApiHttpResponseBody> implements StatefulApiResponseBody<RESPONSE> {

  /**
   * 版本号	version	否	String(8)	版本号，version默认值是2.0
   */
  @XmlElement(name = "version")
  @JsonProperty(value = "version")
  private String version ;

  /**
   * 字符集	charset	否	String(8)	可选值 UTF-8 ，默认为 UTF-8
   */
  @XmlElement(name = "charset")
  @JsonProperty(value = "charset")
  private String charset ;

  /**
   * 签名方式	sign_type	否	String(8)	签名类型，取值：MD5默认：MD5
   */
  @XmlElement(name = "sign_type")
  @JsonProperty(value = "sign_type")
  private String signType ;

  /* 返回状态码 */
  @JsonProperty(value = "status")
  @XmlElement(name = "status")
  private String status;

  /* 返回信息 */
  @JsonProperty(value = "message")
  @XmlElement(name = "message")
  private String message;

  @ApiRequestEntity
  private RESPONSE payload;

  public Boolean isSuccess() {
    return "0".equals(status);
  }


}
