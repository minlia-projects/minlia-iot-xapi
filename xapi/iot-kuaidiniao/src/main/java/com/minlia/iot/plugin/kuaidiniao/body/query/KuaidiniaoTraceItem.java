package com.minlia.iot.plugin.kuaidiniao.body.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

/**
 * Created by will on 9/11/17.
 */
@Data

public class KuaidiniaoTraceItem {
// "Traces": [    {      "AcceptTime": "2017-06-06 21:13:11",      "AcceptStation": "【浙江省宁波市雅格尔公司】 已收件"    },    {      "AcceptTime": "2017-06-06 21:25:57",      "AcceptStation": "【浙江省宁波市雅格尔公司】 已打包"    },    {      "AcceptTime": "2017-06-06 21:31:55",      "AcceptStation": "【浙江省宁波市雅格尔公司】 已发出 下一站 【宁波转运中心】"    },    {      "AcceptTime": "2017-06-06 23:03:13",      "AcceptStation": "【宁波转运中心】 已收入"    },    {      "AcceptTime": "2017-06-06 23:29:04",      "AcceptStation": "【宁波转运中心】 已发出 下一站 【嘉兴转运中心】"    },    {      "AcceptTime": "2017-06-07 02:18:26",      "AcceptStation": "【嘉兴转运中心】 已收入"    },    {      "AcceptTime": "2017-06-07 02:22:22",      "AcceptStation": "【嘉兴转运中心】 已发出 下一站 【浙江省嘉兴市秀洲公司】"    },    {      "AcceptTime": "2017-06-07 05:21:32",      "AcceptStation": "【浙江省嘉兴市秀洲公司】 已收入"    },    {      "AcceptTime": "2017-06-07 05:26:09",      "AcceptStation": "【浙江省嘉兴市秀洲公司】 派件人 :程攀飞 派件中 派件员电话18858316595"    },    {      "AcceptTime": "2017-06-07 13:42:25",      "AcceptStation": "客户 签收人 :null 已签收 感谢使用圆通速递，期待再次为您服务"    }  ]}
  @XmlElement(name = "AcceptTime")
  @JsonProperty(value = "AcceptTime")
  private String acceptTime;


  @XmlElement(name = "AcceptStation")
  @JsonProperty(value = "AcceptStation")
  private String acceptStation;


}
