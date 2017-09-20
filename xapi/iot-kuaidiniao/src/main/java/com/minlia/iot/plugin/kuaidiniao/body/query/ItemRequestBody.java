package com.minlia.iot.plugin.kuaidiniao.body.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class ItemRequestBody {

  @XmlElement(name = "No")
  @JsonProperty(value = "No")
  private String number;

  @XmlElement(name = "Bk")
  @JsonProperty(value = "Bk")
  private String bk;
}
