package com.minlia.iot.plugin.swiftpass.requestor;

import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpRequestBody;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassApiHttpResponseBody;
import com.minlia.iot.plugin.swiftpass.config.SwiftpassApiCredentialConfiguration;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.requestor.DefaultApiHttpRequestor;

/**
 * Created by will on 9/10/17.
 */
public class SwiftpassDefaultApiHttpRequestor<REQUEST extends SwiftpassApiHttpRequestBody, RESPONSE extends SwiftpassApiHttpResponseBody> extends
    DefaultApiHttpRequestor<REQUEST, RESPONSE> {


  public SwiftpassDefaultApiHttpRequestor( ApiProcessor<REQUEST, RESPONSE> apiProcessor ) {
    super(apiProcessor);
  }

  /**
   * 组装请求参数完成后调用处理器进行请求处理
   */
  @Override
  public StatefulApiResponseBody<RESPONSE> request(REQUEST body) {

    //封装一些通用参数进来, 基本是每次请求都需要的参数
    body.setMchId(((SwiftpassApiCredentialConfiguration) getApiProcessor().getContext()
        .getPreferApiCredentialConfiguration()).getMchId());

    //最终调用处理器, 进行各种处理
    return super.request(body);
  }


}
