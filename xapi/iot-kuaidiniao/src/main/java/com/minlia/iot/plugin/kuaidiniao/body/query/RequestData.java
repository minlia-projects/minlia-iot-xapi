package com.minlia.iot.plugin.kuaidiniao.body.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class RequestData {

  @XmlElement(name = "OrderCode")
  @JsonProperty(value = "OrderCode")
  private String orderCode;
  @XmlElement(name = "ShipperCode")
  @JsonProperty(value = "ShipperCode")
  private String shipperCode;

  @XmlElement(name = "LogisticCode")
  @JsonProperty(value = "LogisticCode")
  private String logisticCode;


}
