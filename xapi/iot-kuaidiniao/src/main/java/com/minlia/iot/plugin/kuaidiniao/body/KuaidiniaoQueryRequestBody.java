package com.minlia.iot.plugin.kuaidiniao.body;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.ApiRequestDataTransfer;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.kuaidiniao.body.query.RequestData;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 */
@XmlRootElement(name = "xml")
@Data
@Signature(value = "dataSign", source = "requestData")
@ApiRequestDataTransfer(source = "requestDataObject", target = "requestData", type = "UrlEncode")
public class KuaidiniaoQueryRequestBody extends KuaidiniaoApiHttpRequestBody {


  @JsonIgnore
  private RequestData requestDataObject;

  @JsonProperty(value = "RequestData")
  private String requestData;

  @XmlElement(name = "RequestType")
  @JsonProperty(value = "RequestType")
  private String requestType;


  @XmlElement(name = "DataSign")
  @JsonProperty(value = "DataSign")
  private String dataSign;

  @XmlElement(name = "DataType")
  @JsonProperty(value = "DataType")
  private String dataType;


}
