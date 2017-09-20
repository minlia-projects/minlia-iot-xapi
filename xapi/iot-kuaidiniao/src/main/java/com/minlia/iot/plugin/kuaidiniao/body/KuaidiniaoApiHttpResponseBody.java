package com.minlia.iot.plugin.kuaidiniao.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.body.ApiHttpResponseBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by Administrator on 2016/9/1.
 */
@Data
public abstract class KuaidiniaoApiHttpResponseBody extends ApiHttpResponseBody {

  //{  "EBusinessID": "1255666",
  @XmlElement( name="EBusinessID")
  @JsonProperty(value = "EBusinessID")
  private String ebusinessId;


  // "LogisticCode": "885336485979984406",
  @XmlElement(name = "LogisticCode")
  @JsonProperty(value = "LogisticCode")
  private String logisticCode;
}
