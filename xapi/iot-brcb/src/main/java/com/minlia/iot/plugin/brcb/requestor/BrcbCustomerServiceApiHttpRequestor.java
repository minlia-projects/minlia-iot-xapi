package com.minlia.iot.plugin.brcb.requestor;

import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.BrcbApiHttpResponseBody;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerServiceApiHttpRequestBody;
import com.minlia.iot.plugin.brcb.config.cs.BrcbCustomerServiceApiCredentialConfiguration;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.requestor.DefaultApiHttpRequestor;

/**
 * Created by will on 9/10/17.
 */
public class BrcbCustomerServiceApiHttpRequestor<REQUEST extends BrcbCustomerServiceApiHttpRequestBody, RESPONSE extends BrcbApiHttpResponseBody> extends
    DefaultApiHttpRequestor<REQUEST, RESPONSE> {


  public BrcbCustomerServiceApiHttpRequestor(ApiProcessor<REQUEST, RESPONSE> apiProcessor) {
    super(apiProcessor);
  }

  /**
   * 组装请求参数完成后调用处理器进行请求处理
   */
  @Override
  public StatefulApiResponseBody<RESPONSE> request(REQUEST body) {

    //封装一些通用参数进来, 基本是每次请求都需要的参数
    body.setAgentNum(((BrcbCustomerServiceApiCredentialConfiguration) getApiProcessor().getContext()
        .getPreferApiCredentialConfiguration()).getAgentNum());

    //BRCB无需此种绑定操作
    //快递鸟需要进行此类特殊绑定操作
//    DataProcessor apiRequestDataAnnotationProcessor = new ApiRequestDataAnnotationProcessor();
//    apiRequestDataAnnotationProcessor.process(body);

    //最终调用处理器, 进行各种处理
    return super.request(body);
  }


}
