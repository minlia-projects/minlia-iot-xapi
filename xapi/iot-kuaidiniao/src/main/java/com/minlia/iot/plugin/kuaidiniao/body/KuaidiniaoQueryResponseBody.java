package com.minlia.iot.plugin.kuaidiniao.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.kuaidiniao.body.query.KuaidiniaoTraceItem;
import com.minlia.iot.annotation.XmlElementArray;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class KuaidiniaoQueryResponseBody extends KuaidiniaoApiHttpResponseBody {


  @XmlElement(name = "ShipperCode")
  @JsonProperty(value = "ShipperCode")
  private String shipperCode;
// "ShipperCode": "YTO",
// "Success": true,


  @XmlElement(name = "Success")
  @JsonProperty(value = "Success")
  private Boolean success;

  // "State": "3",
  @XmlElement(name = "State")
  @JsonProperty(value = "State")
  private Integer state;

  @XmlElementArray(indexElement = "traces")
  @XmlElement(name = "Traces")
  @JsonProperty(value = "Traces")
  private KuaidiniaoTraceItem[] traces;


}
