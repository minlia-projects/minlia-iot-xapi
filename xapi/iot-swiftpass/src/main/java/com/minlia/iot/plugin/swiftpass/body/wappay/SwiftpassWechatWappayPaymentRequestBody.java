package com.minlia.iot.plugin.swiftpass.body.wappay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.iot.annotation.Signature;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpRequestBody;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 498391498 on 2017/11/18.
 */
@XmlRootElement(name = "xml")
@Data
@Signature
public class SwiftpassWechatWappayPaymentRequestBody extends SwiftpassApiHttpRequestBody {

    /**
     * 商户订单号    out_trade_no    是   String(32)  商户系统内部的订单号 ,32 个字符内、 可包含字母,确保 在商户系统唯一
     */
    @XmlElement(name = "out_trade_no",required = true)
    private String outTradeNo;

    /**
     * 商品描述	body	是	String(127)	商品描述
     */
    @XmlElement(name = "body",required = true)
    @JsonProperty(value = "body")
    private String body;

    /**
     * 总金额  total_fee   是       Int     总金额，以分为单位，不允许包含任何字、 符号
     */
    @XmlElement(name = "total_fee",required = true)
    private String totalFee;

    /**
     * 终端 IP    mch_create_ip   是   String(16)  订单生成的机器 IP
     */
    @XmlElement(name = "mch_create_ip",required = true)
    private String mchCreateIp;

    /**
     * 通知地址 notify_url  是   String(255)
     *接收浦发银行通知的 URL，需给绝对路径，255 字符内格式 如:http://wap.tenpay.com/tenpay.asp，确 保浦发银行能通过互联网访问该地址
     */
    @XmlElement(name = "notify_url",required = true)
    @JsonProperty(value = "notify_url")
    private String notifyUrl;

    /**
     * 如果是用于苹果app应用里值为iOS_SDK；如果是用于安卓app应用里值为AND_SDK；如果是用于手机网站，值为iOS_WAP或AND_WAP均可
     */
    @XmlElement(name = "device_info",required = true)
    @JsonProperty(value = "device_info")
    private String deviceInfo;

    /**
     * 如果是用于苹果或安卓app应用中，传分别对应在AppStore和安桌分发市场中的应用名（如：王者荣耀）如果是用于手机网站，传对应的网站名(如：京东官网)
     */
    @XmlElement(name = "mch_app_name",required = true)
    @JsonProperty(value = "mch_app_name")
    private String mchAppName;

    @XmlElement(name = "mch_app_id",required = true)
    @JsonProperty(value = "mch_app_id")
    private String mchAppId;

    @XmlElement(name = "nonce_str",required = true)
    @JsonProperty(value = "nonce_str")
    private String nonceStr;

    /**
     *签名 sign    是   String(32)  MD5 签名结果，详见“第 4 章 MD5 签名规则”
     */
    @XmlElement(name = "sign", required = true)
    @JsonProperty(value = "sign")
    private String sign;
}
