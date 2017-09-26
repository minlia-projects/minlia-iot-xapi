package com.minlia.iot.plugin.brcb.body.api.cs.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.brcb.body.BrcbApiHttpResponseBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class BrcbCustomerQueryResponseBody extends BrcbApiHttpResponseBody {

  @XmlElement(name = "customer" )
  @JsonProperty(value = "customer")
  private String customer;

  @XmlElement(name = "bank" )
  @JsonProperty(value = "bank")
  private String bank;

  @XmlElement(name = "fee" )
  @JsonProperty(value = "fee")
  private String fee;

  @XmlElement(name = "material" )
  @JsonProperty(value = "material")
  private String material;


}
