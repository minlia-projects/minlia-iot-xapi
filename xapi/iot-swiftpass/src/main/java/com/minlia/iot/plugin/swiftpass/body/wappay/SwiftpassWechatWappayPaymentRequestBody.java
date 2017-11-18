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
     * 大商户编号	groupno	否	String(32)	大商户模式下专用（用到时签名必须使用大商户密钥），正常模式下忽略不传此字段
     */
    @XmlElement(name = "groupno",required = false)
    @JsonProperty(value = "groupno")
    private String groupno;

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
     * 附加信息	attach	否	String(128)	商户附加信息，可做扩展参数，255字符内
     */
    @XmlElement(name = "attach",required = false)
    @JsonProperty(value = "attach")
    private String attach;

    /**
     * 总金额  total_fee   是       Int     总金额，以分为单位，不允许包含任何字、 符号
     */
    @XmlElement(name = "total_fee",required = true)
    private Integer totalFee;

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
     * 前台地址	callback_url	否	String(255)	前端页面跳转的URL（包括支付成功和关闭时都会跳到这个地址,商户需自行处理逻辑），需给绝对路径，255字符内格式如:http://wap.tenpay.com/callback.asp注:该地址只作为前端页面的一个跳转，须使用notify_url通知结果作为支付最终结果。
     */
    @XmlElement(name = "callback_url")
    @JsonProperty(value = "callback_url")
    private String callbackUrl;

    /**
     * 订单生成时间	time_start	否	String(14)	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器。注：订单生成时间与超时时间需要同时传入才会生效。
     */
    @XmlElement(name = "time_start")
    @JsonProperty(value = "time_start")
    private String timeStart;

    /**
     * 订单超时时间	time_expire	否	String(14)	订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。时区为GMT+8 beijing。该时间取自商户服务器。注：订单生成时间与超时时间需要同时传入才会生效。
     */
    @XmlElement(name = "time_expire")
    @JsonProperty(value = "time_expire")
    private String timeExpire;

    /**
     * 商品标记	goods_tag	否	String(32)	商品标记
     */
    @XmlElement(name = "goods_tag")
    @JsonProperty(value = "goods_tag")
    private String goodsTag;

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
