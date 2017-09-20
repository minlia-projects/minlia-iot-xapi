package com.minlia.iot.plugin.kuaidiniao.signature;

import com.minlia.iot.annotation.Signature;
import com.minlia.iot.context.ApiRuntimeContext;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoApiHttpRequestBody;
import com.minlia.iot.signature.StringSignatureEncodeHelper;
import com.minlia.iot.signature.XmlSignatureAnnotationHelper;
import com.minlia.iot.plugin.kuaidiniao.config.KuaidiniaoApiCredentialConfiguration;
import com.minlia.iot.signature.sign.DefaultXmlSignatureProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by will on 9/11/17.
 */
@Slf4j
public class KuaidiniaoSignatureProcessor<REQUEST extends KuaidiniaoApiHttpRequestBody> extends
    DefaultXmlSignatureProcessor<REQUEST> {

  @Override
  public String sign(KuaidiniaoApiHttpRequestBody raw,ApiRuntimeContext context) {

    String field = raw.getClass().getAnnotation(Signature.class).value();
    String source = raw.getClass().getAnnotation(Signature.class).source();
    if (!StringUtils.isEmpty(source)) {
      //取到属性的值

      String value = (String) XmlSignatureAnnotationHelper.getFieldValue(raw, source);
      if (!StringUtils.isEmpty(value)) {
        try {
          //由于在绑定数据时经过了UrlEncode所以这里需要解密再进行下一步操作
          value = StringSignatureEncodeHelper.urlDecoder(value, ApiRuntimeContext.DEFAULT_CHARSET);
          log.debug("VALUE {}", value);
          String signature = StringSignatureEncodeHelper.sign(value, ((KuaidiniaoApiCredentialConfiguration) context.getPreferApiCredentialConfiguration())
              .getAppKey(), ApiRuntimeContext.DEFAULT_CHARSET);
          if (!StringUtils.isEmpty(signature)) {
            //设置到当前BODY的签名字段去
            XmlSignatureAnnotationHelper.setFieldValue(raw, field, signature);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
}
