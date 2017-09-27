package com.minlia.iot.plugin.brcb.signature;

import com.minlia.iot.body.SignatureBody;
import com.minlia.iot.context.ApiRuntimeContext;
import com.minlia.iot.plugin.brcb.body.api.payment.BrcbPaymentApiHttpRequestBody;
import com.minlia.iot.plugin.brcb.config.payment.wechat.BrcbPaymentWechatApiCredentialConfiguration;
import com.minlia.iot.signature.CaseControl;
import com.minlia.iot.signature.SignatureAlgorithmic;
import com.minlia.iot.signature.binder.SignatureBinder;
import com.minlia.iot.signature.sign.DefaultXmlSignatureProcessor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by will on 9/11/17.
 *
 * 官方说明@see [link https://note.youdao.com/share/?token=7EB47E69B1D84591AE49BA4B04B24DE0&gid=47293425#/]
 *
 * 无论是请求还是应答，签名原始串按以下方式组装成字符串：
 *
 * 除 sign 字段外，所有参数按照字段名的 ascii 码从小到大排序后使用 QueryString 的格式（即 key1=value1&key2=value2…）拼接而成，空值和空字符串不传递(即null&""不传递)，不参与签名组串。
 * 签名原始串中，字段名和字段值都采用原始值，不进行 URL Encode。 一码付返回的应答或通知消息可能会由于升级增加参数，请验证应答签名时注意允许这种情况。
 * 举例：调用某个接口，接口有如下字段：
 */
@Slf4j
public class BrcbPaymentWechatSignatureProcessor<REQUEST extends BrcbPaymentApiHttpRequestBody> extends
    DefaultXmlSignatureProcessor<REQUEST> {

  @Override
  public String sign(BrcbPaymentApiHttpRequestBody requestBody, ApiRuntimeContext context) {
    //将签名后的值绑定到签名字段上 sign
    SignatureBody signatureBody = new SignatureBody();
    signatureBody.setRaw(requestBody);
    signatureBody.setAlgorithmic(SignatureAlgorithmic.MD5);
    signatureBody.setCaseControl(CaseControl.TO_UPPER_CASE);
    signatureBody.setExcludeSaltParameter(Boolean.TRUE);
    //使用默认api交互时的字符集
    signatureBody.setCharset(context.getEncoding());
    signatureBody.setSaltParameterPrefix("");
    signatureBody.setDelimiter("&");
    signatureBody.setSalt(requestBody.getMchKey());
    SignatureBinder.bind(signatureBody);
    return signatureBody.getSignature();
  }
}
