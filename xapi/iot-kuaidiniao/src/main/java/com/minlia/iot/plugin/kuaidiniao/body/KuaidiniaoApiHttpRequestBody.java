package com.minlia.iot.plugin.kuaidiniao.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.body.ApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class KuaidiniaoApiHttpRequestBody extends ApiHttpRequestBody {

  @XmlElement(name = "EBusinessID")
  @JsonProperty(value = "EBusinessID")
  private String ebusinessId;

}
