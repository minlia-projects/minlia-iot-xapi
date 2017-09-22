package com.minlia.iot.plugin.brcb;

/**
 * Created by will on 9/19/17.
 */

import com.minlia.iot.api.AbstractApi;
import com.minlia.iot.api.AbstractJsonApi;
import com.minlia.iot.body.response.StatefulApiResponseBody;
import com.minlia.iot.config.ApiCredentialConfiguration;
import com.minlia.iot.config.ApiEndpointConfiguration;
import com.minlia.iot.http.JsonApiHttpExecutor;
import com.minlia.iot.marshal.deserialize.JsonApiDeserializer;
import com.minlia.iot.marshal.serialize.JsonApiSerializer;
import com.minlia.iot.plugin.brcb.body.BrcbStatefulApiResponseBody;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerEnterRequestBody;
import com.minlia.iot.plugin.brcb.body.api.cs.BrcbCustomerEnterResponseBody;
import com.minlia.iot.plugin.brcb.signature.BrcbCustomerServiceSignatureProcessor;
import com.minlia.iot.plugin.brcb.signature.BrcbSignatureVerificationProcessor;
import com.minlia.iot.processor.ApiProcessor;
import com.minlia.iot.processor.DefaultApiProcessor;
import com.minlia.iot.scope.HttpMediaType;
import com.minlia.iot.plugin.brcb.requestor.BrcbCustomerServiceApiHttpRequestor;
import com.minlia.iot.plugin.brcb.scope.BrcbApiScope;

/**
 * Created by will on 9/10/17.
 * BRCB进件接口为示例, 将继续添加其它接口进来
 */
public class BrcbCustomerServiceApi extends AbstractJsonApi {

  //如果需要创建BUILDER方法, 取消注释即可
  public BrcbCustomerServiceApi sandbox(Boolean sandbox) {
    apiRuntimeContext.setSandbox(sandbox);
    return this;
  }

  /**
   * 总个数只能为环境的个数, 如ApiRequestMode.PRODUCTION, ApiRequestMode.SANDBOX
   * 如果一个都没有则报错
   */
  public BrcbCustomerServiceApi(ApiCredentialConfiguration[] apiCredentialConfiguration,
      ApiEndpointConfiguration[] apiEndpointConfiguration) {
    super(apiCredentialConfiguration, apiEndpointConfiguration);

    //定义此接口需要的状态化返回体类型
    apiRuntimeContext.setStatefulResponseBodyClass(BrcbStatefulApiResponseBody.class);


    //签名请求体
    apiRuntimeContext.setSignatureRequired(Boolean.TRUE);
    apiRuntimeContext.setSignatureProcessor(new BrcbCustomerServiceSignatureProcessor());

    //验证返回体签名
    apiRuntimeContext.setSignatureVerificationRequired(Boolean.TRUE);   //可以使用默认配置
    apiRuntimeContext.setSignatureVerificationProcessor(new BrcbSignatureVerificationProcessor());   //可以使用默认配置
  }

  /**
   * @param body
   * @return
   */
  public StatefulApiResponseBody customerEnter(BrcbCustomerEnterRequestBody body) {
    //必须与ApiEndpointConfiguration中的配置项保持一至,不然会出现找不到此项的错误
    apiRuntimeContext.setApiScope(BrcbApiScope.CUSTOMER_ENTER.name());

    //设置业务返回体类名
    apiRuntimeContext.setBusinessResponseBodyClass(BrcbCustomerEnterResponseBody.class);

    //创建处理器
    ApiProcessor processor = new DefaultApiProcessor(apiRuntimeContext);

    //创建请求器并发起请求
    return new BrcbCustomerServiceApiHttpRequestor(processor).request(body);
  }

}
