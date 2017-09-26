package com.minlia.iot.plugin.brcb.body.api.cs.enter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.brcb.body.BrcbApiHttpResponseBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@Data
public class BrcbCustomerEnterResponseBody extends BrcbApiHttpResponseBody {

  /**
   * 商户号	customer_num	是	varchar(32)	北农商商户号
   */
  @XmlElement(name = "customer_num" )
  @JsonProperty(value = "customer_num")
  private String customerNum;

  /**
   * 商户秘钥	api_key	是	varchar(32)	商户秘钥，用户交易
   */
  @XmlElement(name = "api_key" )
  @JsonProperty(value = "api_key")
  private String apiKey;

}
