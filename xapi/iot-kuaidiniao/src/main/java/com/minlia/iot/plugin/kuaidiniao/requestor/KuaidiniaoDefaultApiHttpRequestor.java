package com.minlia.iot.plugin.kuaidiniao.requestor;

import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoApiHttpRequestBody;
import com.minlia.iot.plugin.kuaidiniao.body.KuaidiniaoApiHttpResponseBody;
import com.minlia.iot.plugin.kuaidiniao.config.KuaidiniaoApiCredentialConfiguration;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.processor.ApiRequestDataAnnotationProcessor;
import com.minlia.iot.processor.DataProcessor;
import com.minlia.iot.requestor.DefaultApiHttpRequestor;

/**
 * Created by will on 9/10/17.
 */
public class KuaidiniaoDefaultApiHttpRequestor<REQUEST extends KuaidiniaoApiHttpRequestBody, RESPONSE extends KuaidiniaoApiHttpResponseBody> extends
    DefaultApiHttpRequestor<REQUEST, RESPONSE> {


  public KuaidiniaoDefaultApiHttpRequestor(
      ApiProcessor<REQUEST, RESPONSE> apiProcessor
      ) {
    super(apiProcessor);
  }

  /**
   * 组装请求参数完成后调用处理器进行请求处理
   */
  @Override
  public StatefulApiResponseBody<RESPONSE> request(REQUEST body) {

    //封装一些通用参数进来, 基本是每次请求都需要的参数
    body.setEbusinessId(((KuaidiniaoApiCredentialConfiguration) getApiProcessor().getContext().getPreferApiCredentialConfiguration()).getEbusinessId());

    DataProcessor apiRequestDataAnnotationProcessor = new ApiRequestDataAnnotationProcessor();
    //绑定指定属性的数据到另一个属性上
    apiRequestDataAnnotationProcessor.process(body);

    //签名
//    SignatureProcessor signatureProcessor = new KuaidiniaoSignatureProcessor();
//    SignatureBody signatureBody = new SignatureBody();
//    signatureBody.setRaw(body);
//    signatureBody.setAlgorithmic(SignatureAlgorithmic.MD5);
//    signatureBody.setSalt(((KuaidiniaoApiCredentialConfiguration) getApiProcessor().getContext().getPreferApiCredentialConfiguration()).getKey());
//    signatureProcessor.sign(signatureBody);

    //最终调用处理器, 进行各种处理
    return super.request(body);
  }


}
