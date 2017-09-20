package com.minlia.iot.plugin.swiftpass.signature;

import static com.minlia.iot.context.ApiRuntimeContext.DEFAULT_CHARSET;

import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpRequestBody;
import com.minlia.iot.body.SignatureBody;
import com.minlia.iot.context.ApiRuntimeContext;
import com.minlia.iot.plugin.swiftpass.config.SwiftpassApiCredentialConfiguration;
import com.minlia.iot.signature.CaseControl;
import com.minlia.iot.signature.SignatureAlgorithmic;
import com.minlia.iot.signature.binder.SignatureBinder;
import com.minlia.iot.signature.sign.DefaultXmlSignatureProcessor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by will on 9/11/17.
 */
@Slf4j
public class SwiftpassSignatureProcessor<REQUEST extends SwiftpassApiHttpRequestBody> extends
    DefaultXmlSignatureProcessor<REQUEST> {

  public String sign(SwiftpassApiHttpRequestBody requestBody, ApiRuntimeContext context) {
    //将签名后的值绑定到签名字段上 sign
    SignatureBody signatureBody = new SignatureBody();
    signatureBody.setRaw(requestBody);
    signatureBody.setAlgorithmic(SignatureAlgorithmic.MD5);
    signatureBody.setCaseControl(CaseControl.TO_UPPER_CASE);
    signatureBody.setExcludeSaltParameter(Boolean.FALSE);
    //使用默认api交互时的字符集
    signatureBody.setCharset(context.getEncoding());
    signatureBody.setSaltParameterPrefix("key=");
    signatureBody.setDelimiter("&");
    signatureBody.setCharset(DEFAULT_CHARSET);

    signatureBody.setSalt(
        ((SwiftpassApiCredentialConfiguration) context.getPreferApiCredentialConfiguration())
            .getKey());

    SignatureBinder.bind(signatureBody);

    return signatureBody.getSignature();
  }
}

