package com.minlia.iot.plugin.swiftpass;

/**
 * Created by will on 9/19/17.
 */

import com.minlia.iot.api.AbstractXmlApi;
import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.plugin.swiftpass.body.SwiftpassStatefulApiResponseBody;
import com.minlia.iot.plugin.swiftpass.body.query.SwiftpassWechatNativePaymentResponseBody;
import com.minlia.iot.plugin.swiftpass.requestor.SwiftpassDefaultApiHttpRequestor;
import com.minlia.iot.plugin.swiftpass.signature.SwiftpassSignatureProcessor;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.plugin.swiftpass.body.query.SwiftpassWechatNativePaymentRequestBody;
import com.minlia.iot.plugin.swiftpass.scope.SwiftpassApiScope;
import com.minlia.iot.plugin.swiftpass.signature.SwiftpassSignatureVerificationProcessor;
import com.minlia.iot.processor.DefaultApiProcessor;

/**
 * Created by will on 9/10/17.
 * 最终Api样例
 */
public class SwiftpassApi extends AbstractXmlApi {

  //如果需要创建BUILDER方法, 取消注释即可
  public SwiftpassApi sandbox(Boolean sandbox) {
    apiRuntimeContext.setSandbox(sandbox);
    return this;
  }

  /**
   * 总个数只能为环境的个数, 如ApiRequestMode.PRODUCTION, ApiRequestMode.SANDBOX
   * 如果一个都没有则报错
   */
  public SwiftpassApi(ApiCredentialConfiguration[] apiCredentialConfiguration,
      ApiEndpointConfiguration[] apiEndpointConfiguration) {
    super(apiCredentialConfiguration, apiEndpointConfiguration);
    //定义此接口需要的状态化返回体类型
    apiRuntimeContext.setStatefulResponseBodyClass(SwiftpassStatefulApiResponseBody.class);

    //签名请求体
    apiRuntimeContext.setSignatureRequired(Boolean.TRUE);
    apiRuntimeContext.setSignatureProcessor(new SwiftpassSignatureProcessor());

    //验证返回体签名
    apiRuntimeContext.setSignatureVerificationRequired(Boolean.TRUE);   //可以使用默认配置
    apiRuntimeContext.setSignatureVerificationProcessor(new SwiftpassSignatureVerificationProcessor());   //可以使用默认配置
  }


  /**
   * @param body
   * @return
   */
  public SwiftpassStatefulApiResponseBody<SwiftpassWechatNativePaymentResponseBody> wechatNativePayment(SwiftpassWechatNativePaymentRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(SwiftpassApiScope.ENDPOINT.name());

    body.setService("pay.weixin.native");

    apiRuntimeContext.setBusinessResponseBodyClass(SwiftpassWechatNativePaymentResponseBody.class);
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    return (SwiftpassStatefulApiResponseBody<SwiftpassWechatNativePaymentResponseBody>)new SwiftpassDefaultApiHttpRequestor(processor).request(body);
  }

}
