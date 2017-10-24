package com.minlia.iot.plugin.swiftpass.body.jspay;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 //for swiftpass only
 <xml><bank_type><![CDATA[CFT]]></bank_type>
 <charset><![CDATA[UTF-8]]></charset>
 <fee_type><![CDATA[CNY]]></fee_type>
 <is_subscribe><![CDATA[N]]></is_subscribe>
 <mch_id><![CDATA[101500146325]]></mch_id>
 <nonce_str><![CDATA[1508747368049]]></nonce_str>
 <openid><![CDATA[o-Rj7wDPLuZy4lcJBCFz-wkoMR8Y]]></openid>
 <out_trade_no><![CDATA[O15087473265905034]]></out_trade_no>
 <out_transaction_id><![CDATA[4200000016201710239841981115]]></out_transaction_id>
 <pay_result><![CDATA[0]]></pay_result>
 <result_code><![CDATA[0]]></result_code>
 <sign><![CDATA[D3BA5BD6BB6CD85DC2CBC821742C64DE]]></sign>
 <sign_type><![CDATA[MD5]]></sign_type>
 <status><![CDATA[0]]></status>
 <sub_appid><![CDATA[wx8d0da24b30e0f110]]></sub_appid>
 <sub_is_subscribe><![CDATA[N]]></sub_is_subscribe>
 <sub_openid><![CDATA[oICYK0S0kMA1VKT33LpD-4VDhK3g]]></sub_openid>
 <time_end><![CDATA[20171023162927]]></time_end>
 <total_fee><![CDATA[1]]></total_fee>
 <trade_type><![CDATA[pay.weixin.jspay]]></trade_type>
 <transaction_id><![CDATA[101500146325201710232216127980]]></transaction_id>
 <version><![CDATA[2.0]]></version>
 </xml>

 attach=TS100000000001149245184212600276&bank_type=CFT&charset=UTF-8&fee_type=CNY&is_subscribe=N&mch_id=103580003270&nonce_str=1492451851250&openid=o7PjgtyHptTwPILLfptTmplDomFg&out_trade_no=TS100000000001149245184212600276&out_transaction_id=4004642001201704187397984756&pay_result=0&result_code=0&status=0&sub_appid=wx62eb98733173fa88&sub_is_subscribe=Y&sub_openid=oGM7bwGdkotqW25z8Bwm05hrXDZY&time_end=20170418015730&total_fee=1&trade_type=pay.weixin.jspay&transaction_id=103580003270201704181196670406&version=2.0&key=d83e2ec91d72e4a00ffa7177353f8c47
 */
public class SwiftpassCallbackRequestBody implements Serializable {


    //后台通知通过请求中的notify_url进行， post

    /**
     * 版本号      version默认值是2.0。
     */
    private String version;

    /**
     * 字符集	可选值 UTF-8 ，默认为 UTF-8。
     */
    private String charset;

    /**
     * 签名方式	签名类型，取值：MD5默认：MD5
     */
    private String sign_type;

    /**
     * 返回状态码	 0表示成功，非0表示失败此字段是通信标识，非交易标识，交易是否成功需要查看 result_code 来判断
     */
    private String status;

    /**
     * 返回信息，如非空，为错误原因签名失败参数格式校验错误
     */
    private String message;



    //以下字段在 status 为 0的时候有返回

    /**
     * 业务结果	0表示成功非0表示失败
     */
    private String result_code;

    /**
     * 商户号，由平台分配
     */
    private String mch_id;

    /**
     * 终端设备号
     */
    private String device_info;

    /**
     * 随机字符串，不长于 32 位
     */
    private String nonce_str;

    /**
     * 错误代码 参考错误码
     */
    private String err_code;

    /**
     * 错误代码描述   结果信息描述
     */
    private String err_msg;

    /**
     * 签名   MD5签名结果，详见“安全规范”
     */
    private String sign;

    //以下字段在 status 和 result_code 都为 0的时候有返回

    /**
     * 用户在商户 appid 下的唯一标识
     */
    private String openid;

    /**
     * 交易类型:pay.weixin.jspay
     */
    private String trade_type;

    /**
     * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String is_subscribe;

    /**
     * 支付结果：0—成功；其它—失败
     */
    private Integer pay_result;

    /**
     * 支付结果信息,支付成功时为空
     */
    private String pay_info;

    /**
     * 平台交易号
     */
    private String transaction_id;

    /**
     * 第三方订单号
     */
    private String out_transaction_id;

    /**
     * 用户是否关注子公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String sub_is_subscribe;

    /**
     * 子商户appid
     */
    private String sub_appid;

    /**
     * 用户openid:用户在商户 sub_appid 下的唯一标识
     */
    private String sub_openid;

    /**
     * 商户订单号:商户系统内部的定单号
     */
    private String out_trade_no;

    /**
     * 总金额，以分为单位，不允许包含任何字、符号
     */
    private Integer total_fee;

    /**
     * 现金券支付金额<=订单总金额， 订单总金额-现金券金额为现金支付金额
     */
    private Integer coupon_fee;

    /**
     * 货币类型，符合 ISO 4217 标准的三位字母代码，默认人民币：CNY
     */
    private String fee_type;

    /**
     * 附加信息:商家数据包，原样返回
     */
    private String attach;

    /**
     * 付款银行
     */
    private String bank_type;

    /**
     * 银行订单号
     */
    private String bank_billno;

    /**
     * time_end
     */
    private String time_end;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public Integer getPay_result() {
        return pay_result;
    }

    public void setPay_result(Integer pay_result) {
        this.pay_result = pay_result;
    }

    public String getPay_info() {
        return pay_info;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_transaction_id() {
        return out_transaction_id;
    }

    public void setOut_transaction_id(String out_transaction_id) {
        this.out_transaction_id = out_transaction_id;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    public void setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public Integer getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(Integer coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getBank_billno() {
        return bank_billno;
    }

    public void setBank_billno(String bank_billno) {
        this.bank_billno = bank_billno;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this,o,false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,false);
    }

}
