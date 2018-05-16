package com.minlia.iot.plugin.pooulcloud.marshal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.body.ApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class ApiHttpDataResponseBody extends ApiHttpRequestBody {

  @XmlElement(name = "data" )
  @JsonProperty(value = "data")
  private String data;

}
