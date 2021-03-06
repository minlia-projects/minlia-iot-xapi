package com.minlia.iot.plugin.pooulcloud.body.wappay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.plugin.pooulcloud.body.SwiftpassApiHttpResponseBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by 498391498 on 2017/11/18.
 */
@Data
public class SwiftpassWechatWappayPaymentResponseBody extends SwiftpassApiHttpResponseBody {

    @JsonProperty(value = "appid")
    @XmlElement(name = "appid")
    private String appid;

    @JsonProperty(value = "merchantId")
    @XmlElement(name = "mch_id")
    private String mchId;

    @JsonProperty(value = "resultCode")
    @XmlElement(name = "result_code")
    private String resultCode;

    @JsonProperty(value = "nonceStr")
    @XmlElement(name = "nonce_str")
    private String nonceStr;

    @JsonProperty(value = "errCode")
    @XmlElement(name = "err_code")
    private String errCode;

    @JsonProperty(value = "errMsg")
    @XmlElement(name = "err_msg")
    private String errMsg;

    @JsonProperty(value = "sign")
    @XmlElement(name = "sign")
    private String sign;

    @XmlElement(name = "pay_info")
    private String payInfo;

    public Boolean isSuccess() {
        return "0".equals(resultCode);
    }
}
