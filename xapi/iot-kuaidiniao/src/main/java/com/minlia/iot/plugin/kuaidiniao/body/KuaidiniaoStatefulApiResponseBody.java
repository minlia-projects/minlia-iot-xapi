package com.minlia.iot.plugin.kuaidiniao.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.ApiRequestEntity;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "xml")
public class KuaidiniaoStatefulApiResponseBody<T extends KuaidiniaoApiHttpResponseBody> implements StatefulApiResponseBody<T> {

  /* 返回状态码 */
  @JsonProperty(value = "Success")
  @XmlElement(name = "Success")
  private Boolean success;

  /* 返回信息 */
  @JsonProperty(value = "Reason")
  @XmlElement(name = "Reason")
  private String reason;

  @ApiRequestEntity
  private T payload;

  public Boolean isSuccess() {
    return Boolean.TRUE.equals(success);
  }


}
