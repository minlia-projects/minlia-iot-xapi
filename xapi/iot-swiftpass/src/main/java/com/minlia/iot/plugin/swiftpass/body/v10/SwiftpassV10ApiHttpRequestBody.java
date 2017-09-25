package com.minlia.iot.plugin.swiftpass.body.v10;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.body.ApiHttpRequestBody;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpRequestBody;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/10/17.
 * swiftpass接口公共请求参数
 *
 *
 * 老版本的请求体 体现不同之处在于, 当时还没引入版本.
 *
 * service===> serviceType
 *
 */
@Data
public class SwiftpassV10ApiHttpRequestBody extends SwiftpassApiHttpRequestBody {

  /**
   *接口类型	service_type	是	varchar(32)	类型：WECHAT_MICRO
   * 
   */
  @XmlElement(name = "service_type")
  @JsonProperty(value = "service_type")
  private String serviceType;

  /**
   * 商户号	mch_id	是	String(32)	商户号，由平台分配
   */
  @XmlElement(name = "mch_id")
  @JsonProperty(value = "mch_id")
  private String mchId;

}
